package leoguedex.com.github.HealthCoachWeb.service;

import com.github.javafaker.Faker;
import leoguedex.com.github.HealthCoachWeb.domain.Customer;
import leoguedex.com.github.HealthCoachWeb.domain.enums.ExpectedEnum;
import leoguedex.com.github.HealthCoachWeb.domain.enums.IndicatedByEnum;
import leoguedex.com.github.HealthCoachWeb.domain.enums.ReasonEnum;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Getter
@Setter
public class FakePeople {
    
    private static final double WEIGHT_MIN = 50.0;
    private static final double WEIGHT_MAX = 200.0;
    private static final double HEIGHT_MIN = 1.50;
    private static final double HEIGHT_MAX = 2.10;
    private static final String NOTHING = "No meal";

    public static List<Customer> generateCustomer(int amountPeople) {
        
        List<Customer> customerList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amountPeople; i++) {
            Customer customer = new Customer();
            Faker faker = new Faker(new Locale("pt-BR"));

            String name = faker.name().firstName();
            String lastName = faker.name().lastName();
            customer.setName(name + " " + lastName);

            String email = name + "@" + faker.internet().domainWord() + "." + faker.internet().domainSuffix();
            customer.setEmail(removeAccentsAndSpaces(email));

            customer.setAddress(faker.address().fullAddress());
            customer.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").format(faker.date().birthday()));
            customer.setPhoneNumber(faker.phoneNumber().phoneNumber());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = LocalDateTime.now().format(formatter);
            customer.setWhenCreated(LocalDateTime.parse(formattedDateTime, formatter));

            customer.setWeight(random.nextDouble(WEIGHT_MIN, WEIGHT_MAX));
            customer.setHeight(random.nextDouble(HEIGHT_MIN, HEIGHT_MAX));
            customer.setWorksOrStudies(random.nextBoolean());

            customer.setReferredBy(IndicatedByEnum.codToDescription(random.nextInt(0,IndicatedByEnum.values().length)));

            int option = random.nextInt(0, (ReasonEnum.values().length) - 1);
            customer.setConsultationReason(ReasonEnum.codToDescription(option));
            customer.setExpectedOutcome(ExpectedEnum.codToDescription(option));

            customerList.add(customer);
        }

        return customerList;
    }

    private static String removeAccentsAndSpaces(String text) {
        return text.replaceAll("[ÀÁÂÃÄÅàáâãäå]", "a")
                .replaceAll("[ÈÉÊËèéêë]", "e")
                .replaceAll("[ÌÍÎÏìíîï]", "i")
                .replaceAll("[ÒÓÔÕÖØòóôõöø]", "o")
                .replaceAll("[ÙÚÛÜùúûü]", "u")
                .replaceAll("[Çç]", "c")
                .replaceAll("[Ññ]", "n")
                .replaceAll(" ", "")
                .toLowerCase();
    }
}
