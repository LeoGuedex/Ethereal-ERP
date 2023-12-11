package leoguedex.com.github.EtherealERP.service;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import leoguedex.com.github.EtherealERP.domain.Customer;
import leoguedex.com.github.EtherealERP.domain.CustomerAlimentation;
import leoguedex.com.github.EtherealERP.domain.CustomerGym;
import leoguedex.com.github.EtherealERP.domain.CustomerHealth;
import leoguedex.com.github.EtherealERP.domain.CustomerNutritionistInformation;
import leoguedex.com.github.EtherealERP.domain.CustomerRotineTable;
import leoguedex.com.github.EtherealERP.domain.ETUser;
import leoguedex.com.github.EtherealERP.domain.ETUserData;
import leoguedex.com.github.EtherealERP.domain.enums.DiseasesEnum;
import leoguedex.com.github.EtherealERP.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DBService {

    private final CustomerRepository customerRepository;
    private final ETUserService userService;
    private final PasswordEncoder encoder;

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
                Set.of(DiseasesEnum.toEnum(RandomUtils.nextInt(0, DiseasesEnum.values().length)))
            );

            customerAlimentation.setCustomer(customer);
            customer.setCustomerAlimentation(customerAlimentation);
            
            customerGym.setCustomer(customer);
            customer.setCustomerGym(customerGym);
            
            customerHealth.setCustomer(customer);
            customer.setCustomerHealth(customerHealth);
            
            customerNutritionistInformation.setCustomer(customer);
            customer.setCustomerNutritionistInformation(customerNutritionistInformation);
            
            customerRotineTable.setCustomer(customer);
            customer.setCustomerRotineTable(customerRotineTable);
            
            customerRepository.save(customer);
            
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
