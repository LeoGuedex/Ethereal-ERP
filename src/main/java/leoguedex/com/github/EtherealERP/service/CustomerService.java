package leoguedex.com.github.EtherealERP.service;

import leoguedex.com.github.EtherealERP.domain.Customer;
import leoguedex.com.github.EtherealERP.domain.dto.AllCustomerDTO;
import leoguedex.com.github.EtherealERP.exception.GetAgeFromBirthDateException;
import leoguedex.com.github.EtherealERP.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(AllCustomerDTO customer) {
        return customerRepository.save(AllCustomerDTO.toCustomer(customer));
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<Customer> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        customers.forEach(c -> {
            try {
                c.setAge(getAgeFromBirthDate(c.getBirthDate()));
                customerRepository.save(c);
            } catch (GetAgeFromBirthDateException e) {
                e.printStackTrace();
            }
        });

        return customers;
    }

    private Integer getAgeFromBirthDate(String birthDate) throws GetAgeFromBirthDateException {
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
