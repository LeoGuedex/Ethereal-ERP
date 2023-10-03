package leoguedex.com.github.HealthCoachWeb.service;

import leoguedex.com.github.HealthCoachWeb.domain.Customer;
import leoguedex.com.github.HealthCoachWeb.domain.CustomerAlimentation;
import leoguedex.com.github.HealthCoachWeb.domain.CustomerGym;
import org.junit.jupiter.api.Test;

import java.util.List;

class FakePeopleTest {
    @Test
    void CustomerGenerateTest(){
        FakePeople fakePeople = new FakePeople(100);
        List<Customer> customerList = fakePeople.generateCustomer();
        for(Customer customer: customerList){
            System.out.println(customer.toString());
        }
        System.out.println("\n");
    }

    @Test
    void CustomerGenerateAlimentationTest(){
        FakePeople fakePeople = new FakePeople(100);
        List<CustomerAlimentation> customerAlimentationList = fakePeople.generateCustomerAlimentation();
        for(CustomerAlimentation customerAlimentation: customerAlimentationList){
            System.out.println(customerAlimentation.toString());
        }
        System.out.println("\n");
    }
    @Test
    void CustomerGenerateGymTest(){
        FakePeople fakePeople = new FakePeople(100);
        List<CustomerGym> customerGymList = fakePeople.generateCustomerGym();
        for (CustomerGym customerGym : customerGymList){
            System.out.println(customerGym.toString());
        }
        System.out.println("/n");
    }
}