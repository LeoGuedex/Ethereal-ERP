package leoguedex.com.github.EtherealERP.service;

import com.github.javafaker.Faker;
import leoguedex.com.github.EtherealERP.domain.Customer;
import leoguedex.com.github.EtherealERP.domain.enums.ExpectedEnum;
import leoguedex.com.github.EtherealERP.domain.enums.IndicatedByEnum;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class FakePeople {
    private final int amountPeople;
    private final Faker faker;
    private final Random random;

    public FakePeople(int amountPeople) {
        this.amountPeople = amountPeople;
        faker = new Faker(new Locale("pt-BR"));
        random = new Random();
    }

    public List<Customer> generateCustomer() {

        List<Customer> customerList = new ArrayList<>();

        for (int i = 0; i < amountPeople; i++) {
            Customer customer = new Customer();

            String name = generateName();

            customer.setName(name);

            customer.setEmail(removeAccentsAndSpaces(generateEmail(name)));

            customer.setAddress(faker.address().fullAddress());
            customer.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").format(faker.date().birthday()));
            customer.setPhoneNumber(faker.phoneNumber().phoneNumber());

            customer.setWhenCreated(generateDateCreated());

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

    private String generateName() {
        String name = faker.name().firstName();
        String lastName = faker.name().lastName();

        return name + " " + lastName;
    }

    private String generateEmail(String name) {
        return name + "@" + faker.internet().domainWord() + "." + faker.internet().domainSuffix();
    }

    private String generateDateCreated(){
        LocalDateTime localDateTime = LocalDateTime.ofInstant(faker.date().birthday(1,3).toInstant(), ZoneId.systemDefault());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        return localDateTime.format(dateTimeFormatter);
    }
    private String removeAccentsAndSpaces(String text) {
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
