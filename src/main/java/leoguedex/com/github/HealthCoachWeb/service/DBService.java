package leoguedex.com.github.HealthCoachWeb.service;

import leoguedex.com.github.HealthCoachWeb.domain.*;
import leoguedex.com.github.HealthCoachWeb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    private HCUserRepository hcUserRepository;

    public void createTestCustomer() {
        int amountPeoplesFake = 10;

        FakePeople fakePeople = new FakePeople(amountPeoplesFake);
        List<Customer> customerList = fakePeople.generateCustomer();
        List<CustomerAlimentation> customerAlimentationList = fakePeople.generateCustomerAlimentation();
        List<CustomerHealth> customerHealthList = fakePeople.generateCustomerHealt();
        List<CustomerGym> customerGymList = fakePeople.generateCustomerGym();
        List<CustomerNutritionistInformation> customerNutritionistInformationList = fakePeople.generateCustomerNutritionistInformation();
        List<CustomerRotineTable> customerRotineTableList = fakePeople.generateCustomerRotineTable();

        for(int i = 0 ; i < amountPeoplesFake; i++){
            Customer customer = customerList.get(i);
            CustomerAlimentation customerAlimentation = customerAlimentationList.get(i);
            CustomerHealth customerHealth = customerHealthList.get(i);
            CustomerGym customerGym = customerGymList.get(i);
            CustomerNutritionistInformation customerNutritionistInformation = customerNutritionistInformationList.get(i);
            CustomerRotineTable customerRotineTable = customerRotineTableList.get(i);

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

    public void createLoginAdmin(){
        HCUser user = new HCUser();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEmail("email@email.com");
        user.setName("Administrator");
        user.setPersonFunction("Developer Java");
        user.setAdmin(true);
        hcUserRepository.save(user);
    }
}
