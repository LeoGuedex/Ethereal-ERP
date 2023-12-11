package leoguedex.com.github.EtherealERP.service;

import leoguedex.com.github.EtherealERP.domain.*;
import leoguedex.com.github.EtherealERP.domain.enums.DiseasesEnum;
import leoguedex.com.github.EtherealERP.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DBService {

    private final CustomerAlimentationRepository customerAlimentationRepository;
    private final CustomerGymRepository customerGymRepository;
    private final CustomerHealthRepository customerHealthRepository;
    private final CustomerNutritionistInformationRepository customerNutritionistInformationRepository;
    private final CustomerRepository customerRepository;
    private final CustomerRotineTableRepository customerRotineTableRepository;
    private final ETUserService userService;
    private final PasswordEncoder encoder;

    public DBService(CustomerAlimentationRepository customerAlimentationRepository, CustomerGymRepository customerGymRepository, CustomerHealthRepository customerHealthRepository, CustomerNutritionistInformationRepository customerNutritionistInformationRepository, CustomerRepository customerRepository, CustomerRotineTableRepository customerRotineTableRepository, ETUserService userService, PasswordEncoder encoder) {
        this.customerAlimentationRepository = customerAlimentationRepository;
        this.customerGymRepository = customerGymRepository;
        this.customerHealthRepository = customerHealthRepository;
        this.customerNutritionistInformationRepository = customerNutritionistInformationRepository;
        this.customerRepository = customerRepository;
        this.customerRotineTableRepository = customerRotineTableRepository;
        this.userService = userService;
        this.encoder = encoder;
    }

    public void createTestCustomer() {
        int amountPeopleFake = 30;

        FakePeople fakePeople = new FakePeople(amountPeopleFake);
        List<Customer> customerList = fakePeople.generateCustomer();

        for (int i = 0; i < amountPeopleFake; i++) {
            Customer customer = customerList.get(i);
            CustomerAlimentation customerAlimentation = new CustomerAlimentation();
            CustomerHealth customerHealth = new CustomerHealth();
            CustomerGym customerGym = new CustomerGym();
            CustomerNutritionistInformation customerNutritionistInformation = new CustomerNutritionistInformation();
            CustomerRotineTable customerRotineTable = new CustomerRotineTable();

            customerHealth.setDiseases(
                Set.of(DiseasesEnum.toEnum(0), DiseasesEnum.toEnum(1))
            );

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
        ETUserData userData = new ETUserData();
        userData.setAddress("Av. Nossa Senhora, N 100, Copacabana-RJ");
        userData.setFirstName("Billy");
        userData.setLastName("The Kid");
        userData.setPhoneNumber("(11) 99999-8888");

        ETUser user = new ETUser();
        user.setPassword(encoder.encode("admin"));
        user.setEmail("email@email.com");
        user.setAdmin(true);
        user.setName("Admin User");
        user.setPersonFunction("Trainee");
        user.setUserData(userData);

        userService.createUser(user);
    }

}
