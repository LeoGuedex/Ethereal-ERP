package leoguedex.com.github.HealthCoachWeb.service;

import com.github.javafaker.Faker;
import leoguedex.com.github.HealthCoachWeb.domain.*;
import leoguedex.com.github.HealthCoachWeb.domain.enums.QuantityPercentageEnum;
import leoguedex.com.github.HealthCoachWeb.domain.enums.TypeOfWeightEnum;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static leoguedex.com.github.HealthCoachWeb.service.FoodOptions.*;
import static leoguedex.com.github.HealthCoachWeb.service.PhysicalActivityOptions.*;

@Getter
@Setter
public class FakePeople {
    private static final double WEIGHT_MIN = 50.0;
    private static final double WEIGHT_MAX = 200.0;
    private static final double HEIGHT_MIN = 1.50;
    private static final double HEIGHT_MAX = 2.10;
    private static final String NOTHING = "No meal";
    private int amountPeople;
    private Random random;

    public FakePeople(int amountPeople) {
        this.amountPeople = amountPeople;
        random = new Random();
    }

    public List<Customer> generateCustomer() {
        List<Customer> customerList = new ArrayList<>();

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

            customer.setReferredBy(INDICATED_BY[random.nextInt(0, INDICATED_BY.length)]);

            int option = random.nextInt(0, REASONS.length - 1);
            customer.setConsultationReason(REASONS[option]);
            customer.setExpectedOutcome(EXPECTED[option]);

            customerList.add(customer);
        }

        return customerList;
    }

    public List<CustomerAlimentation> generateCustomerAlimentation() {
        List<CustomerAlimentation> customerAlimentationList = new ArrayList<>();

        for (int i = 0; i < amountPeople; i++) {
            CustomerAlimentation customerAlimentation = new CustomerAlimentation();

            boolean eatWhenWakeUp = random.nextBoolean();

            customerAlimentation.setEatsUponWakingUp(eatWhenWakeUp);
            customerAlimentation.setBreakfast(eatWhenWakeUp ? BREAKFAST[random.nextInt(0, BREAKFAST.length)] : NOTHING);

            boolean eatWhenBeforeLunch = random.nextBoolean();
            customerAlimentation.setEatsBeforeLunch(eatWhenBeforeLunch);
            customerAlimentation.setBeforeLunchMeal(eatWhenBeforeLunch ? SNACK_BEFORE_LUNCH[random.nextInt(0, SNACK_BEFORE_LUNCH.length)] : NOTHING);

            boolean eatWhenLunch = random.nextBoolean();
            customerAlimentation.setEatsLunch(eatWhenLunch);
            customerAlimentation.setLunch(eatWhenLunch ? LUNCH[random.nextInt(0, LUNCH.length)] : NOTHING);

            boolean eatWhenAfternoonSnack = random.nextBoolean();
            customerAlimentation.setEatsAfternoonSnack(eatWhenAfternoonSnack);
            customerAlimentation.setAfternoonSnack(eatWhenAfternoonSnack ? AFTERNOON_SNACK[random.nextInt(0, AFTERNOON_SNACK.length)] : NOTHING);

            boolean eatWhenDinner = random.nextBoolean();
            customerAlimentation.setEatsDinner(eatWhenDinner);
            customerAlimentation.setDinner(eatWhenDinner ? DINNER[random.nextInt(0, DINNER.length)] : NOTHING);

            boolean eatWhenBeforeBedTime = random.nextBoolean();
            customerAlimentation.setEatsBeforeBedtime(eatWhenBeforeBedTime);
            customerAlimentation.setBeforeBedtimeSnack(eatWhenBeforeBedTime ? BED_TIME_SNACKS[random.nextInt(0, BED_TIME_SNACKS.length)] : NOTHING);

            customerAlimentationList.add(customerAlimentation);
        }
        return customerAlimentationList;
    }

    public List<CustomerGym> generateCustomerGym() {
        List<CustomerGym> customerGymList = new ArrayList<>();
        for (int i = 0; i < amountPeople; i++) {
            CustomerGym customerGym = new CustomerGym();

            double randomDesiredWeigth = random.nextDouble(WEIGHT_MIN, WEIGHT_MAX);
            double formatRandomWeight = Double.parseDouble(String.format(Locale.US,"%.2f",randomDesiredWeigth));
            customerGym.setDesiredWeight(formatRandomWeight);

            double randomWeigthOneYearAgo = random.nextDouble(WEIGHT_MIN, WEIGHT_MAX);
            double formatRandomWeigthOneYearAgo = Double.parseDouble(String.format(Locale.US,"%.2f",randomWeigthOneYearAgo));
            customerGym.setWeightOneYearAgo(formatRandomWeigthOneYearAgo);

            double formatWeightTenYearAgo = Double.parseDouble(String.format(Locale.US,"%.2f",formatRandomWeigthOneYearAgo - random.nextDouble(1,11)));
            customerGym.setWeightTenYearsAgo(formatWeightTenYearAgo);
            customerGym.setWeightType(TypeOfWeightEnum.toEnum(random.nextInt(0, TypeOfWeightEnum.values().length)));

            boolean doExercise = random.nextBoolean();
            customerGym.setDoesExercise(doExercise);
            customerGym.setExerciseTypes(doExercise ? TYPES_EXERCISES[random.nextInt(0, TYPES_EXERCISES.length)] : "");
            customerGym.setTrainingDaysPerWeek(doExercise ? random.nextInt(0, 7) : 0);
            customerGym.setPostExerciseFeeling(doExercise ? FEELINGS_POS_EXERCISE[random.nextInt(0, FEELINGS_POS_EXERCISE.length)] : "");

            customerGym.setIntendsToExercise(random.nextBoolean());
            customerGym.setIsPhysicallyActive(random.nextBoolean());
            customerGym.setFreeTimeActivities(FREE_TIME_ACTIVITIES[random.nextInt(0, FREE_TIME_ACTIVITIES.length)]);
            customerGym.setExerciseLimitations(EXERCISE_LIMITATIONS[random.nextInt(0, EXERCISE_LIMITATIONS.length)]);

            customerGym.setSupplements(SUPPLEMENTS[random.nextInt(0, SUPPLEMENTS.length)]);
            customerGym.setFamilyBalance(QuantityPercentageEnum.HIGH);
            customerGym.setDesiredFreeTimeActivity(DESIRED_FREE_TIME_ACTIVITIES[random.nextInt(0, DESIRED_FREE_TIME_ACTIVITIES.length)]);
            customerGym.setLifeSituationToChange(LIFE_SITUATIONS_TO_CHANGE[random.nextInt(0, LIFE_SITUATIONS_TO_CHANGE.length)]);
            customerGym.setDeterminationLevel(random.nextInt(0,11));

            customerGym.setImproveWellBeing(random.nextBoolean());
            customerGym.setIncreaseExercise(random.nextBoolean());
            customerGym.setLoseWeight(random.nextBoolean());
            customerGym.setImproveSleep(random.nextBoolean());
            customerGym.setImproveMentalHealth(random.nextBoolean());
            customerGym.setImproveDiet(random.nextBoolean());
            customerGym.setIncreaseEnergy(random.nextBoolean());
            customerGym.setIncreaseProductivity(random.nextBoolean());
            customerGym.setDecreaseStress(random.nextBoolean());
            customerGym.setImproveLifeBalance(random.nextBoolean());
            customerGym.setJobSatisfaction(random.nextBoolean());

            customerGymList.add(customerGym);
        }
        return customerGymList;
    }

    public List<CustomerHealth> generateCustomerHealt() {
        List<CustomerHealth> customerHealthList = new ArrayList<>();
        for (int i = 0 ; i < amountPeople ; i++){
            CustomerHealth customerHealth = new CustomerHealth();



            customerHealthList.add(customerHealth);
        }
        return customerHealthList;
    }

    public List<CustomerNutritionistInformation> generateCustomerNutritionistInformation() {
        return null;
    }

    public List<CustomerRotineTable> generateCustomerRotineTable() {
        return null;
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
