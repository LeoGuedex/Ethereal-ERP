package leoguedex.com.github.HealthCoachWeb.service;

import leoguedex.com.github.HealthCoachWeb.Exception.GetAgeFromBirthDateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CustomerServiceTest {
    @Test
    void getAgeFromBirthDate() throws GetAgeFromBirthDateException {
        CustomerService service = new CustomerService();
        LocalDate date = LocalDate.now();

        String dateBirthOne = "22/09/2000";
        String dateBirthTwo = "25/12/2000";
        String dateBirthThree = String.format("%02d/%02d/2000", date.getDayOfMonth(), date.getMonth().getValue());

        Assertions.assertEquals(23, service.getAgeFromBirthDate(dateBirthOne));
        Assertions.assertEquals(22, service.getAgeFromBirthDate(dateBirthTwo));
        Assertions.assertEquals(23, service.getAgeFromBirthDate(dateBirthThree));
    }
}