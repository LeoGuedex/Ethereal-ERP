package leoguedex.com.github.EtherealERP.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import leoguedex.com.github.EtherealERP.domain.Customer;
import leoguedex.com.github.EtherealERP.domain.CustomerAlimentation;
import leoguedex.com.github.EtherealERP.domain.CustomerGym;
import leoguedex.com.github.EtherealERP.domain.CustomerHealth;
import leoguedex.com.github.EtherealERP.domain.CustomerNutritionistInformation;
import leoguedex.com.github.EtherealERP.domain.CustomerRotineTable;
import leoguedex.com.github.EtherealERP.domain.dto.AllCustomerDTO;
import leoguedex.com.github.EtherealERP.exception.GetAgeFromBirthDateException;
import leoguedex.com.github.EtherealERP.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public Customer create(AllCustomerDTO customer) {
        Customer customerSaved = AllCustomerDTO.toCustomer(customer);

        CustomerAlimentation customerAlimentation = AllCustomerDTO.toCustomerAlimentation(customer);
        CustomerGym customerGym = AllCustomerDTO.toCustomerGym(customer);
        CustomerHealth customerHealth = AllCustomerDTO.toCustomerHealth(customer);
        CustomerNutritionistInformation customerNutritionistInformation = AllCustomerDTO.toCustomerNutritionistInformation(customer);
        CustomerRotineTable customerRotineTable = AllCustomerDTO.toCustomerRotineTable(customer);

        customerAlimentation.setCustomer(customerSaved);
        customerGym.setCustomer(customerSaved);
        customerHealth.setCustomer(customerSaved);
        customerNutritionistInformation.setCustomer(customerSaved);
        customerRotineTable.setCustomer(customerSaved);

        customerSaved.setCustomerNutritionistInformation(customerNutritionistInformation);
        customerSaved.setCustomerRotineTable(customerRotineTable);
        customerSaved.setCustomerAlimentation(customerAlimentation);
        customerSaved.setCustomerGym(customerGym);
        customerSaved.setCustomerHealth(customerHealth);

        return customerRepository.save(customerSaved);

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

    public List<Customer> findNewlyRegistered() {
        return customerRepository.selectNewlyRegistered();
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
