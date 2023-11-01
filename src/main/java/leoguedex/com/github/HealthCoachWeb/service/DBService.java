package leoguedex.com.github.HealthCoachWeb.service;

import leoguedex.com.github.HealthCoachWeb.domain.*;
import leoguedex.com.github.HealthCoachWeb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    @Autowired
    private CustomerAlimentationRepository customerAlimentationRepository;

    @Autowired
    private CustomerGymRepository customerGymRepository;

    @Autowired
    private CustomerHealthRepository customerHealthRepository;

    @Autowired
    private CustomerNutritionistInformationRepository customerNutritionistInformationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerRotineTableRepository customerRotineTableRepository;

    @Autowired
    private HCUserService hcUserRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void createTestCustomer() {
        int amountPeopleFake = 30;
        List<Customer> customerList = FakePeople.generateCustomer(amountPeopleFake);

        for (int i = 0; i < amountPeopleFake; i++) {
            Customer customer = customerList.get(i);
            CustomerAlimentation customerAlimentation = new CustomerAlimentation();
            CustomerHealth customerHealth = new CustomerHealth();
            CustomerGym customerGym = new CustomerGym();
            CustomerNutritionistInformation customerNutritionistInformation = new CustomerNutritionistInformation();
            CustomerRotineTable customerRotineTable = new CustomerRotineTable();

            customerRepository.save(customer);

            customerAlimentation.setCustomer(customer);
            customer.setCustomerAlimentation(customerAlimentation);
            customerAlimentationRepository.save(customerAlimentation);

            customerGym.setCustomer(customer);
            customer.setCustomerGym(customerGym);
            customerGymRepository.save(customerGym);

            customerHealth.setCustomer(customer);
            customer.setCustomerHealth(customerHealth);
            customerHealthRepository.save(customerHealth);

            customerNutritionistInformation.setCustomer(customer);
            customer.setCustomerNutritionistInformation(customerNutritionistInformation);
            customerNutritionistInformationRepository.save(customerNutritionistInformation);

            customerRotineTable.setCustomer(customer);
            customer.setCustomerRotineTable(customerRotineTable);
            customerRotineTableRepository.save(customerRotineTable);
        }
    }

    public void createLoginAdmin() {
        HCUser user = new HCUser();

        user.setPassword(encoder.encode("admin"));
        user.setEmail("email@email.com");
        user.setAdmin(true);
        user.setName("Admin User");
        user.setPersonFunction("Trainee");

        hcUserRepository.createUser(user);
    }

}
