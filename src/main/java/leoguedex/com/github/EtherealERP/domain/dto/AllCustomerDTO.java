package leoguedex.com.github.EtherealERP.domain.dto;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;

import leoguedex.com.github.EtherealERP.domain.Customer;
import leoguedex.com.github.EtherealERP.domain.CustomerAlimentation;
import leoguedex.com.github.EtherealERP.domain.CustomerGym;
import leoguedex.com.github.EtherealERP.domain.CustomerHealth;
import leoguedex.com.github.EtherealERP.domain.CustomerNutritionistInformation;
import leoguedex.com.github.EtherealERP.domain.CustomerRotineTable;
import leoguedex.com.github.EtherealERP.domain.enums.DiseasesEnum;
import leoguedex.com.github.EtherealERP.domain.enums.ExpectedEnum;
import leoguedex.com.github.EtherealERP.domain.enums.HealthGoalsEnum;
import leoguedex.com.github.EtherealERP.domain.enums.IndicatedByEnum;
import leoguedex.com.github.EtherealERP.domain.enums.QuantityPercentageEnum;
import leoguedex.com.github.EtherealERP.domain.enums.SleepTypeEnum;
import leoguedex.com.github.EtherealERP.domain.enums.TypeDaysEnum;
import leoguedex.com.github.EtherealERP.domain.enums.TypeOfWeightEnum;
import leoguedex.com.github.EtherealERP.domain.enums.TypePersonEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllCustomerDTO {

    // Customer
    private long id;
    private String name;
    private Integer age;
    private String email;
    private Double weight;
    private Double height;
    private String address;
    private String birthDate;
    private String phoneNumber;
    private Boolean worksOrStudies;
    private String consultationReason;
    private IndicatedByEnum referredBy;
    private ExpectedEnum expectedOutcome;

    // CustomerAlimentation
    private Boolean eatsUponWakingUp;
    private Boolean eatsBeforeLunch;
    private String beforeLunchMeal;
    private String lunch;
    private String dinner;
    private String breakfast;
    private Boolean eatsLunch;
    private Boolean eatsDinner;
    private String afternoonSnack;
    private Boolean eatsAfternoonSnack;
    private Boolean eatsBeforeBedtime;
    private String beforeBedtimeSnack;

    // CustomerGym
    private Boolean doesExercise;
    private String trainingDaysPerWeek;
    private String exerciseTypes;
    private String postExerciseFeeling;
    private Boolean intendsToExercise;
    private Boolean isPhysicallyActive;
    private TypeOfWeightEnum weightType;
    private Double desiredWeight;
    private String freeTimeActivities;
    private String desiredFreeTimeActivity;
    private String exerciseLimitations;
    private String supplements;
    private String lifeSituationToChange;
    private QuantityPercentageEnum familyBalance;
    private Integer determinationLevel;
    private List<String> goalsArray;

    // CustomerHealth
    private String moodDescription;
    private SleepTypeEnum sleepTypeEnum;
    private String weekdaySleepHours;
    private String weekendSleepHours;
    private Integer concentration;
    private Integer recentMemory;
    private Integer longTermMemory;
    private Integer morningDisposition;
    private Integer afternoonDisposition;
    private Integer eveningDisposition;
    private Integer daytimeEnergy;
    private Integer stressLevel;
    private String sleepImprovementMethods;
    private String energyReductionMethods;
    private String stressReductionMethods;
    private String healthDescription;
    private List<String> diseasesArray;

    // CustomerNutritionistInformation
    private Boolean visitedNutritionist;
    private Boolean shortOnTimeForMeals;
    private Boolean eatsOutMoreThanHalfTheTime;
    private Boolean unhealthyFoodAtHome;
    private Boolean unhealthyEatingAround;
    private Boolean creativeWithFood;
    private Boolean eatsSomethingRightAfterWakingUp;
    private String chewing;
    private Integer mealsPerDay;
    private Integer cupsOfWaterPerDay;
    private String mostHungryTimeOfDay;
    private String goToSnack;
    private String favoriteFood;
    private String dislikedFood;
    private String weekendFoodChoice;
    private Integer prepareMeals;
    private TypePersonEnum groceryBuyer;
    private Integer planMeals;
    private Boolean foodAllergy;
    private Boolean drinksAlcohol;
    private Integer alcoholPerWeek;
    private Boolean glutenOrGrainIntolerance;
    private String nutritionistRecommendations;

    private String foodFrequencyArray;

    public static Customer toCustomer(AllCustomerDTO customer) {
        return Customer.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .email(customer.getEmail())
                .weight(customer.getWeight())
                .address(customer.getAddress())
                .birthDate(customer.getBirthDate())
                .phoneNumber(customer.getPhoneNumber())
                .worksOrStudies(customer.getWorksOrStudies())
                .consultationReason(customer.getConsultationReason())
                .whenCreated(String.valueOf(LocalDateTime.now()))
                .referredBy(customer.getReferredBy())
                .expectedOutcome(customer.getExpectedOutcome())
                .build();
    }

    public static CustomerAlimentation toCustomerAlimentation(AllCustomerDTO customer) {
        return CustomerAlimentation.builder()
                .lunch(customer.getLunch())
                .dinner(customer.getDinner())
                .breakfast(customer.getBreakfast())
                .eatsLunch(customer.getEatsLunch())
                .afternoonSnack(customer.getAfternoonSnack())
                .beforeLunchMeal(customer.getBeforeLunchMeal())
                .eatsBeforeLunch(customer.getEatsBeforeLunch())
                .eatsUponWakingUp(customer.getEatsUponWakingUp())
                .eatsAfternoonSnack(customer.getEatsAfternoonSnack())
                .eatsBeforeBedtime(customer.getEatsBeforeBedtime())
                .beforeBedtimeSnack(customer.getBeforeBedtimeSnack())
                .build();
    }

    public static CustomerGym toCustomerGym(AllCustomerDTO customer) {
        return CustomerGym.builder()
                .supplements(customer.getSupplements())
                .doesExercise(customer.getDoesExercise())
                .desiredWeight(customer.getDesiredWeight())
                .exerciseTypes(customer.getExerciseTypes())
                .intendsToExercise(customer.getIntendsToExercise())
                .freeTimeActivities(customer.getFreeTimeActivities())
                .isPhysicallyActive(customer.getIsPhysicallyActive())
                .postExerciseFeeling(customer.getPostExerciseFeeling())
                .exerciseLimitations(customer.getExerciseLimitations())
                .determinationLevel(customer.getDeterminationLevel())
                .trainingDaysPerWeek(customer.getTrainingDaysPerWeek())
                .weightType(customer.getWeightType())
                .lifeSituationToChange(customer.getLifeSituationToChange())
                .desiredFreeTimeActivity(customer.getDesiredFreeTimeActivity())
                .familyBalance(customer.getFamilyBalance())
                .goalsArray(
                        customer.getGoalsArray()
                                .stream()
                                .map(m -> HealthGoalsEnum.toDescriptionEnum(m.replaceAll("[\\[\\]\"']", "")))
                                .collect(Collectors.toSet()))
                .build();
    }

    public static CustomerHealth toCustomerHealth(AllCustomerDTO customer) {
        return CustomerHealth.builder()
                .weekdaySleepHours(customer.getWeekdaySleepHours())
                .weekendSleepHours(customer.getWeekendSleepHours())
                .moodDescription(customer.getMoodDescription())
                .healthDescription(customer.getHealthDescription())
                .sleepTypeEnum(customer.getSleepTypeEnum())
                .energyReductionMethods(customer.getEnergyReductionMethods())
                .stressReductionMethods(customer.getStressReductionMethods())
                .sleepImprovementMethods(customer.getSleepImprovementMethods())
                .stressLevel(QuantityPercentageEnum.toEnum(customer.getStressLevel()))
                .recentMemory(QuantityPercentageEnum.toEnum(customer.getRecentMemory()))
                .concentration(QuantityPercentageEnum.toEnum(customer.getConcentration()))
                .daytimeEnergy(QuantityPercentageEnum.toEnum(customer.getDaytimeEnergy()))
                .longTermMemory(QuantityPercentageEnum.toEnum(customer.getLongTermMemory()))
                .morningDisposition(QuantityPercentageEnum.toEnum(customer.getMorningDisposition()))
                .afternoonDisposition(QuantityPercentageEnum.toEnum(customer.getAfternoonDisposition()))
                .eveningDisposition(QuantityPercentageEnum.toEnum(customer.getEveningDisposition()))
                .diseases(
                        customer.getDiseasesArray()
                                .stream()
                                .map(m -> DiseasesEnum.toDescriptionEnum(m.replaceAll("[\\[\\]\"']", "")))
                                .collect(Collectors.toSet())

                )
                .build();

    }

    public static CustomerNutritionistInformation toCustomerNutritionistInformation(AllCustomerDTO customer) {
        return CustomerNutritionistInformation.builder()
                .chewing(customer.getChewing())
                .goToSnack(customer.getGoToSnack())
                .mealsPerDay(customer.getMealsPerDay())
                .favoriteFood(customer.getFavoriteFood())
                .dislikedFood(customer.getDislikedFood())
                .foodAllergy(customer.getFoodAllergy())
                .drinksAlcohol(customer.getDrinksAlcohol())
                .alcoholPerWeek(customer.getAlcoholPerWeek())
                .weekendFoodChoice(customer.getWeekendFoodChoice())
                .creativeWithFood(customer.getCreativeWithFood())
                .cupsOfWaterPerDay(customer.getCupsOfWaterPerDay())
                .mostHungryTimeOfDay(customer.getMostHungryTimeOfDay())
                .shortOnTimeForMeals(customer.getShortOnTimeForMeals())
                .groceryBuyer(customer.getGroceryBuyer())
                .unhealthyFoodAtHome(customer.getUnhealthyFoodAtHome())
                .visitedNutritionist(customer.getVisitedNutritionist())
                .unhealthyEatingAround(customer.getUnhealthyEatingAround())
                .glutenOrGrainIntolerance(customer.getGlutenOrGrainIntolerance())
                .planMeals(QuantityPercentageEnum.toEnum(customer.getPlanMeals()))
                .eatsOutMoreThanHalfTheTime(customer.getEatsOutMoreThanHalfTheTime())
                .nutritionistRecommendations(customer.getNutritionistRecommendations())
                .prepareMeals(QuantityPercentageEnum.toEnum(customer.getPrepareMeals()))
                .eatsSomethingRightAfterWakingUp(customer.getEatsSomethingRightAfterWakingUp())
                .build();
    }

    public static CustomerRotineTable toCustomerRotineTable(AllCustomerDTO customer) {

        if(customer.getFoodFrequencyArray().isEmpty()){
            return new CustomerRotineTable();
        }

        JSONArray data = new JSONArray(customer.getFoodFrequencyArray());

        List<String> fieldListNames = Stream.of(CustomerRotineTable.class.getDeclaredFields())
                .map(m -> m.getName())
                .toList();

        CustomerRotineTable customerRotineTable = new CustomerRotineTable();

        for (int i = 0; i < data.length(); i++) {
            String fieldName = data.getJSONObject(i).getString("name");
            String fieldValue = data.getJSONObject(i).getString("frequencyName");

            if (fieldListNames.contains(fieldName)) {
                try {
                    CustomerRotineTable.class
                            .getMethod("set".concat(StringUtils.capitalize(fieldName)), TypeDaysEnum.class)
                            .invoke(customerRotineTable, TypeDaysEnum.toDescriptinEnum(fieldValue));
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                        | NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }
            } else {
                return null;
            }
        }
        return customerRotineTable;
    }
}
