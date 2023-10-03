package leoguedex.com.github.HealthCoachWeb.service;

import leoguedex.com.github.HealthCoachWeb.Exception.GetAgeFromBirthDateException;
import leoguedex.com.github.HealthCoachWeb.domain.Customer;
import leoguedex.com.github.HealthCoachWeb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer){
        customer.setId(customer.getId());
        
        return customerRepository.save(customer);
    }

    public void delete(Long id){
        customerRepository.deleteById(id);
    }

    public Customer findById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<Customer> findAllCustomers() throws GetAgeFromBirthDateException {
        List<Customer> customers = customerRepository.findAll();
        
        for(Customer thisTime : customers){
            String age = String.valueOf(getAgeFromBirthDate(thisTime.getBirthDate()));
            thisTime.setBirthDate(age);
        }

        return customerRepository.findAll();
    }

    public int getAgeFromBirthDate(String birthDate) throws GetAgeFromBirthDateException {
        Pattern pattern = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{4})");
        Matcher matcher = pattern.matcher(birthDate);

        if (!matcher.matches()) {
            throw new GetAgeFromBirthDateException("Unable to get date from passed parameters.");
        }

        int birthDay = Integer.parseInt(matcher.group(1));
        int birthmonth = Integer.parseInt(matcher.group(2));
        int birthyear = Integer.parseInt(matcher.group(3));

        int currentDay = LocalDateTime.now().getDayOfMonth();
        int currentMonth = LocalDateTime.now().getMonth().getValue();
        int currentYear = LocalDateTime.now().getYear();

        int age = currentYear - birthyear;

        if (currentMonth < birthmonth || (currentMonth == birthmonth && currentDay < birthDay)) {
            age--;
        }
        
        return age;
    }
    
}
