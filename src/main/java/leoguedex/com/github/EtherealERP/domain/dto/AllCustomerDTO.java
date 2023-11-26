package leoguedex.com.github.EtherealERP.domain.dto;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import leoguedex.com.github.EtherealERP.domain.Customer;
import leoguedex.com.github.EtherealERP.domain.CustomerAlimentation;
import leoguedex.com.github.EtherealERP.domain.CustomerGym;
import leoguedex.com.github.EtherealERP.domain.CustomerHealth;
import leoguedex.com.github.EtherealERP.domain.CustomerNutritionistInformation;
import leoguedex.com.github.EtherealERP.domain.CustomerRotineTable;
import leoguedex.com.github.EtherealERP.domain.enums.ExpectedEnum;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private LocalDateTime whenCreated;
    private IndicatedByEnum referredBy;
    private ExpectedEnum expectedOutcome;
    private CustomerAlimentation customerAlimentation;
    private CustomerGym customerGym;
    private CustomerHealth customerHealth;
    private CustomerNutritionistInformation customerNutritionistInformation;
    private CustomerRotineTable customerRotineTable;
    private String lunch;
    private String dinner;
    private String breakfast;
    private Boolean eatsLunch;
    private Boolean eatsDinner;
    private String afternoonSnack;
    private String beforeLunchMeal;
    private Boolean eatsBeforeLunch;
    private Boolean eatsUponWakingUp;
    private Boolean eatsAfternoonSnack;
    private Boolean eatsBeforeBedtime;
    private String beforeBedtimeSnack;
    private String supplements;
    private Boolean loseWeight;
    private Boolean improveDiet;
    private Boolean doesExercise;
    private Double desiredWeight;
    private Boolean improveSleep;
    private String exerciseTypes;
    private Boolean increaseEnergy;
    private Boolean decreaseStress;
    // TODO:
    private Double weightOneYearAgo;
    private Double weightTenYearsAgo;
    private Boolean jobSatisfaction;
    private Boolean improveWellBeing;
    private Boolean increaseExercise;
    private Boolean intendsToExercise;
    private String freeTimeActivities;
    private Boolean isPhysicallyActive;
    private String postExerciseFeeling;
    private String exerciseLimitations;
    private Integer determinationLevel;
    private Boolean improveLifeBalance;
    private Integer trainingDaysPerWeek;
    private Boolean improveMentalHealth;
    private TypeOfWeightEnum weightType;
    private String lifeSituationToChange;
    private Boolean increaseProductivity;
    private String desiredFreeTimeActivity;
    private QuantityPercentageEnum familyBalance;
    private Boolean gout;
    private Boolean ulcer;
    private Boolean edema;
    private Boolean lupus;
    private Boolean anemia;
    private Boolean cancer;
    private Boolean asthma;
    private Boolean fatigue;
    private Boolean anxiety;
    private Boolean smoking;
    private Boolean diabetes;
    private Boolean insomnia;
    private Boolean gastritis;
    private Boolean headaches;
    private Boolean arthritis;
    private Boolean jointPain;
    private Boolean weightGain;
    private Boolean sleepApnea;
    private Boolean depression;
    private Boolean moodSwings;
    private Boolean musclePain;
    private Boolean acidReflux;
    private Boolean heartAttack;
    private Boolean lowImmunity;
    private Boolean infertility;
    private Boolean hypertension;
    private Boolean kidneyStones;
    private Boolean osteoporosis;
    private Boolean hypothyroidism;
    private Boolean hyperthyroidism;
    private Boolean chemicalSensitivity;
    private Boolean highCholesterol;
    private Boolean premenstrualSyndrome;
    private Boolean fungalInfection;
    private Boolean muscleFlaccidity;
    private Boolean metabolicSyndrome;
    private Boolean fattyLiverDisease;
    private Boolean chronicFatigueSyndrome;
    private Boolean irritatedIntestine;
    private Boolean weightFluctuations;
    private Boolean rheumatoidArthritis;
    private Boolean polycysticOvarySyndrome;
    private Boolean foodAllergies;
    private Boolean regularBowelMovement;
    private Boolean urinaryTractInfection;
    private Boolean environmentalAllergies;
    private int weekdaySleepHours;
    private int weekendSleepHours;
    private String moodDescription;
    private String healthDescription;
    private SleepTypeEnum sleepTypeEnum;
    private String energyReductionMethods;
    private String stressReductionMethods;
    private String sleepImprovementMethods;
    private QuantityPercentageEnum stressLevel;
    private QuantityPercentageEnum recentMemory;
    private QuantityPercentageEnum concentration;
    private QuantityPercentageEnum daytimeEnergy;
    private QuantityPercentageEnum longTermMemory;
    private QuantityPercentageEnum morningDisposition;
    private QuantityPercentageEnum afternoonDisposition;
    private QuantityPercentageEnum eveningDisposition;
    private String chewing;
    private String goToSnack;
    private Integer mealsPerDay;
    private String favoriteFood;
    private String dislikedFood;
    private Boolean foodAllergy;
    private Boolean drinksAlcohol;
    private Integer alcoholPerWeek;
    private String weekendFoodChoice;
    private Boolean creativeWithFood;
    private Integer cupsOfWaterPerDay;
    private String mostHungryTimeOfDay;
    private Boolean shortOnTimeForMeals;
    private TypePersonEnum groceryBuyer;
    private Boolean unhealthyFoodAtHome;
    private Boolean visitedNutritionist;
    private Boolean unhealthyEatingAround;
    private Boolean glutenOrGrainIntolerance;
    private QuantityPercentageEnum planMeals;
    private Boolean eatsOutMoreThanHalfTheTime;
    private String nutritionistRecommendations;
    private QuantityPercentageEnum prepareMeals;
    private Boolean eatsSomethingRightAfterWakingUp;
    private TypeDaysEnum rice;
    private TypeDaysEnum potato;
    private TypeDaysEnum pasta;
    private TypeDaysEnum brownRice;
    private TypeDaysEnum wholeWheatPasta;
    private TypeDaysEnum quinoa;
    private TypeDaysEnum beans;
    private TypeDaysEnum lentils;
    private TypeDaysEnum chickpeas;
    private TypeDaysEnum fish;
    private TypeDaysEnum redMeat;
    private TypeDaysEnum poultry;
    private TypeDaysEnum eggs;
    private TypeDaysEnum sweetPotato;
    private TypeDaysEnum cassava;
    private TypeDaysEnum pumpkin;
    private TypeDaysEnum yam;
    private TypeDaysEnum kale;
    private TypeDaysEnum spinach;
    private TypeDaysEnum arugula;
    private TypeDaysEnum lettuce;
    private TypeDaysEnum cauliflower;
    private TypeDaysEnum broccoli;
    private TypeDaysEnum zucchini;
    private TypeDaysEnum soups;
    private TypeDaysEnum salads;
    private TypeDaysEnum nuts;
    private TypeDaysEnum seeds;
    private TypeDaysEnum fruits;
    private TypeDaysEnum flour;
    private TypeDaysEnum milk;
    private TypeDaysEnum yogurt;
    private TypeDaysEnum cheese;
    private TypeDaysEnum slicedBread;
    private TypeDaysEnum frenchBread;
    private TypeDaysEnum wholeWheatBread;
    private TypeDaysEnum processedMeats;
    private TypeDaysEnum biscuits;
    private TypeDaysEnum dessert;
    private TypeDaysEnum soda;
    private TypeDaysEnum boxedJuice;
    private TypeDaysEnum frozenFoods;

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
                .loseWeight(customer.getLoseWeight())
                .improveDiet(customer.getImproveDiet())
                .doesExercise(customer.getDoesExercise())
                .desiredWeight(customer.getDesiredWeight())
                .improveSleep(customer.getImproveSleep())
                .exerciseTypes(customer.getExerciseTypes())
                .increaseEnergy(customer.getIncreaseEnergy())
                .decreaseStress(customer.getDecreaseStress())
                .weightOneYearAgo(customer.getWeightOneYearAgo())
                .weightTenYearsAgo(customer.getWeightTenYearsAgo())
                .jobSatisfaction(customer.getJobSatisfaction())
                .improveWellBeing(customer.getImproveWellBeing())
                .increaseExercise(customer.getIncreaseExercise())
                .intendsToExercise(customer.getIntendsToExercise())
                .freeTimeActivities(customer.getFreeTimeActivities())
                .isPhysicallyActive(customer.getIsPhysicallyActive())
                .postExerciseFeeling(customer.getPostExerciseFeeling())
                .exerciseLimitations(customer.getExerciseLimitations())
                .determinationLevel(customer.getDeterminationLevel())
                .improveLifeBalance(customer.getImproveLifeBalance())
                .trainingDaysPerWeek(customer.getTrainingDaysPerWeek())
                .improveMentalHealth(customer.getImproveMentalHealth())
                .weightType(customer.getWeightType())
                .lifeSituationToChange(customer.getLifeSituationToChange())
                .increaseProductivity(customer.getIncreaseProductivity())
                .desiredFreeTimeActivity(customer.getDesiredFreeTimeActivity())
                .familyBalance(customer.getFamilyBalance())
                .build();
    }

    public static CustomerHealth toCustomerHealth(AllCustomerDTO customer) {
        return CustomerHealth.builder()
                .gout(customer.getGout())
                .ulcer(customer.getUlcer())
                .edema(customer.getEdema())
                .lupus(customer.getLupus())
                .anemia(customer.getAnemia())
                .cancer(customer.getCancer())
                .asthma(customer.getAsthma())
                .fatigue(customer.getFatigue())
                .anxiety(customer.getAnxiety())
                .smoking(customer.getSmoking())
                .diabetes(customer.getDiabetes())
                .insomnia(customer.getInsomnia())
                .gastritis(customer.getGastritis())
                .headaches(customer.getHeadaches())
                .arthritis(customer.getArthritis())
                .jointPain(customer.getJointPain())
                .weightGain(customer.getWeightGain())
                .sleepApnea(customer.getSleepApnea())
                .depression(customer.getDepression())
                .moodSwings(customer.getMoodSwings())
                .musclePain(customer.getMusclePain())
                .acidReflux(customer.getAcidReflux())
                .heartAttack(customer.getHeartAttack())
                .lowImmunity(customer.getLowImmunity())
                .infertility(customer.getInfertility())
                .hypertension(customer.getHypertension())
                .kidneyStones(customer.getKidneyStones())
                .osteoporosis(customer.getOsteoporosis())
                .hypothyroidism(customer.getHypothyroidism())
                .hyperthyroidism(customer.getHyperthyroidism())
                .chemicalSensitivity(customer.getChemicalSensitivity())
                .highCholesterol(customer.getHighCholesterol())
                .premenstrualSyndrome(customer.getPremenstrualSyndrome())
                .fungalInfection(customer.getFungalInfection())
                .muscleFlaccidity(customer.getMuscleFlaccidity())
                .metabolicSyndrome(customer.getMetabolicSyndrome())
                .fattyLiverDisease(customer.getFattyLiverDisease())
                .chronicFatigueSyndrome(customer.getChronicFatigueSyndrome())
                .irritatedIntestine(customer.getIrritatedIntestine())
                .weightFluctuations(customer.getWeightFluctuations())
                .rheumatoidArthritis(customer.getRheumatoidArthritis())
                .polycysticOvarySyndrome(customer.getPolycysticOvarySyndrome())
                .foodAllergies(customer.getFoodAllergies())
                .regularBowelMovement(customer.getRegularBowelMovement())
                .urinaryTractInfection(customer.getUrinaryTractInfection())
                .environmentalAllergies(customer.getEnvironmentalAllergies())
                .weekdaySleepHours(customer.getWeekdaySleepHours())
                .weekendSleepHours(customer.getWeekendSleepHours())
                .moodDescription(customer.getMoodDescription())
                .healthDescription(customer.getHealthDescription())
                .sleepTypeEnum(customer.getSleepTypeEnum())
                .energyReductionMethods(customer.getEnergyReductionMethods())
                .stressReductionMethods(customer.getStressReductionMethods())
                .sleepImprovementMethods(customer.getSleepImprovementMethods())
                .stressLevel(customer.getStressLevel())
                .recentMemory(customer.getRecentMemory())
                .concentration(customer.getConcentration())
                .daytimeEnergy(customer.getDaytimeEnergy())
                .longTermMemory(customer.getLongTermMemory())
                .morningDisposition(customer.getMorningDisposition())
                .afternoonDisposition(customer.getAfternoonDisposition())
                .eveningDisposition(customer.getEveningDisposition())
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
                .planMeals(customer.getPlanMeals())
                .eatsOutMoreThanHalfTheTime(customer.getEatsOutMoreThanHalfTheTime())
                .nutritionistRecommendations(customer.getNutritionistRecommendations())
                .prepareMeals(customer.getPrepareMeals())
                .eatsSomethingRightAfterWakingUp(customer.getEatsSomethingRightAfterWakingUp())
                .build();
    }

    public static CustomerRotineTable toCustomerRotineTable(AllCustomerDTO customer) {
        return CustomerRotineTable.builder()
                .rice(customer.getRice())
                .potato(customer.getPotato())
                .pasta(customer.getPasta())
                .brownRice(customer.getBrownRice())
                .wholeWheatPasta(customer.getWholeWheatPasta())
                .quinoa(customer.getQuinoa())
                .beans(customer.getBeans())
                .lentils(customer.getLentils())
                .chickpeas(customer.getChickpeas())
                .fish(customer.getFish())
                .redMeat(customer.getRedMeat())
                .poultry(customer.getPoultry())
                .eggs(customer.getEggs())
                .sweetPotato(customer.getSweetPotato())
                .cassava(customer.getCassava())
                .pumpkin(customer.getPumpkin())
                .yam(customer.getYam())
                .kale(customer.getKale())
                .spinach(customer.getSpinach())
                .arugula(customer.getArugula())
                .lettuce(customer.getLettuce())
                .cauliflower(customer.getCauliflower())
                .broccoli(customer.getBroccoli())
                .zucchini(customer.getZucchini())
                .soups(customer.getSoups())
                .salads(customer.getSalads())
                .nuts(customer.getNuts())
                .seeds(customer.getSeeds())
                .fruits(customer.getFruits())
                .flour(customer.getFlour())
                .milk(customer.getMilk())
                .yogurt(customer.getYogurt())
                .cheese(customer.getCheese())
                .slicedBread(customer.getSlicedBread())
                .frenchBread(customer.getFrenchBread())
                .wholeWheatBread(customer.getWholeWheatBread())
                .processedMeats(customer.getProcessedMeats())
                .biscuits(customer.getBiscuits())
                .dessert(customer.getDessert())
                .soda(customer.getSoda())
                .boxedJuice(customer.getBoxedJuice())
                .frozenFoods(customer.getFrozenFoods())
                .build();
    }
}
