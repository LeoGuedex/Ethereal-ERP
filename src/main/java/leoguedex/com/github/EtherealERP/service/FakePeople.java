package leoguedex.com.github.EtherealERP.service;

import com.github.javafaker.Faker;
import leoguedex.com.github.EtherealERP.domain.Customer;
import leoguedex.com.github.EtherealERP.domain.enums.ExpectedEnum;
import leoguedex.com.github.EtherealERP.domain.enums.IndicatedByEnum;
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

    public static List<Customer> generateCustomer(int amountPeople) {

        List<Customer> customerList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amountPeople; i++) {
            Customer customer = new Customer();
            Faker faker = new Faker(new Locale("pt-BR"));

            String name = faker.name().firstName();
            String lastName = faker.name().lastName();
            customer.setName(name + " " + lastName);

            String email =
                    name + "@" + faker.internet().domainWord() + "." + faker.internet().domainSuffix();
            customer.setEmail(removeAccentsAndSpaces(email));

            customer.setAddress(faker.address().fullAddress());
            customer.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").format(faker.date().birthday()));
            customer.setPhoneNumber(faker.phoneNumber().phoneNumber());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String formattedDateTime = LocalDateTime.now().format(formatter);
            customer.setWhenCreated(formattedDateTime);

            customer.setWeight(random.nextDouble(50.0, 200.0));
            customer.setHeight(random.nextDouble(1.50, 2.10));
            customer.setWorksOrStudies(random.nextBoolean());

            customer.setReferredBy(
                    IndicatedByEnum.toEnum(random.nextInt(0, IndicatedByEnum.values().length)));

            int option = random.nextInt(0, (ExpectedEnum.values().length) - 1);
            customer.setExpectedOutcome(ExpectedEnum.toEnum(option));
            customer.setConsultationReason("Motivo desconhecido");

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
