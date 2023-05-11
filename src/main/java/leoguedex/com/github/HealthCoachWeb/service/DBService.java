package leoguedex.com.github.HealthCoachWeb.service;

import leoguedex.com.github.HealthCoachWeb.domain.*;
import leoguedex.com.github.HealthCoachWeb.domain.enums.*;
import leoguedex.com.github.HealthCoachWeb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public void createTestCustomer() throws ParseException {

        Customer customer = new Customer();
        customer.setName("Cliente Teste");
        customer.setAge(32);
        customer.setEmail("email@email.com");
        customer.setAddress("Rua das Flores, 123");
        customer.setBirthDate("1990-05-12");
        customer.setPhoneNumber("11 99999-9999");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        customer.setWhenCreated(LocalDateTime.parse(formattedDateTime, formatter));

        customer.setWeight(75.5);
        customer.setHeight(1.75);
        customer.setWorksOrStudies(true);
        customer.setReferredBy("Amigo");
        customer.setConsultationReason1("Perder peso");
        customer.setConsultationReason2("Melhorar a alimentação");
        customer.setConsultationReason3("Aumentar a disposição");
        customer.setExpectedOutcome("Perder 10 kg em 6 meses");
        customerRepository.save(customer);


        CustomerAlimentation customerAlimentation = new CustomerAlimentation();
        customerAlimentation.setEatsUponWakingUp(true);
        customerAlimentation.setBreakfast("Pão integral com ovos mexidos e uma xícara de café com leite");
        customerAlimentation.setEatsBeforeLunch(true);
        customerAlimentation.setBeforeLunchMeal("Salada de frutas com iogurte natural");
        customerAlimentation.setEatsLunch(true);
        customerAlimentation.setLunch("Arroz integral, feijão, filé de frango grelhado e salada verde");
        customerAlimentation.setEatsAfternoonSnack(true);
        customerAlimentation.setAfternoonSnack("Um punhado de castanhas");
        customerAlimentation.setEatsDinner(true);
        customerAlimentation.setDinner("Salmão grelhado com brócolis e quinoa");
        customerAlimentation.setEatsBeforeBedtime(false);
        customerAlimentation.setBeforeBedtimeSnack("");
        customerAlimentation.setCustomer(customer);
        customer.setCustomerAlimentation(customerAlimentation);
        customerAlimentationRepository.save(customerAlimentation);


        CustomerGym customerGym = new CustomerGym();
        customerGym.setDesiredWeight(70.5);
        customerGym.setWeightOneYearAgo(75.0);
        customerGym.setWeightTenYearsAgo(80.0);
        customerGym.setWeightType(TypeOfWeightEnum.Gain);
        customerGym.setChewing("Normal");
        customerGym.setDoesExercise(true);
        customerGym.setExerciseTypes("Running, Weightlifting");
        customerGym.setTrainingDaysPerWeek(4);
        customerGym.setPostExerciseFeeling("Energized");
        customerGym.setIntendsToExercise(true);
        customerGym.setIsPhysicallyActive(true);
        customerGym.setFreeTimeActivities("Hiking, Swimming");
        customerGym.setExerciseLimitations("Knee injury");
        customerGym.setSupplements("Protein powder");
        customerGym.setFamilyBalance(QuantityPercentageEnum.HIGH);
        customerGym.setDesiredFreeTimeActivity("Traveling");
        customerGym.setLifeSituationToChange("Stressful job");
        customerGym.setDeterminationLevel(8);
        customerGym.setImproveWellBeing(true);
        customerGym.setIncreaseExercise(true);
        customerGym.setLoseWeight(true);
        customerGym.setImproveSleep(true);
        customerGym.setImproveMentalHealth(true);
        customerGym.setImproveDiet(true);
        customerGym.setIncreaseEnergy(true);
        customerGym.setIncreaseProductivity(true);
        customerGym.setDecreaseStress(true);
        customerGym.setImproveLifeBalance(true);
        customerGym.setJobSatisfaction(true);
        customerGym.setCustomer(customer);
        customer.setCustomerGym(customerGym);
        customerGymRepository.save(customerGym);


        CustomerHealth health = new CustomerHealth();
        health.setMoodDescription("Me sinto bem");
        health.setSleepTypeEnum(SleepTypeEnum.DAYTIME_SLEEPINESS);
        health.setWeekdaySleepHours(7);
        health.setWeekendSleepHours(8);
        health.setConcentration(QuantityPercentageEnum.MEDIUM);
        health.setRecentMemory(QuantityPercentageEnum.LOW);
        health.setLongTermMemory(QuantityPercentageEnum.MEDIUM);
        health.setDaytimeEnergy(QuantityPercentageEnum.HIGH);
        health.setMorningDisposition(QuantityPercentageEnum.LOW);
        health.setAfternoonDisposition(QuantityPercentageEnum.MEDIUM);
        health.setEveningDisposition(QuantityPercentageEnum.HIGH);
        health.setSleepImprovementMethods("Evitar cafeína à noite");
        health.setEnergyReductionMethods("Fazer pequenas pausas durante o dia");
        health.setStressLevel(QuantityPercentageEnum.HIGH);
        health.setStressReductionMethods("Meditar");
        health.setHealthDescription("Sinto dor nas costas às vezes");
        health.setRegularBowelMovement(true);
        health.setIrritatedIntestine(false);
        health.setAcidReflux(true);
        health.setGastritis(false);
        health.setUlcer(false);
        health.setHeartAttack(false);
        health.setHypertension(true);
        health.setHighCholesterol(false);
        health.setEdema(false);
        health.setHypothyroidism(false);
        health.setDiabetes(false);
        health.setInfertility(false);
        health.setWeightGain(true);
        health.setAnemia(false);
        health.setHyperthyroidism(false);
        health.setMetabolicSyndrome(false);
        health.setFattyLiverDisease(false);
        health.setWeightFluctuations(true);
        health.setPolycysticOvarySyndrome(false);
        health.setGout(false);
        health.setUrinaryTractInfection(false);
        health.setFungalInfection(false);
        health.setKidneyStones(false);
        health.setOsteoporosis(false);
        health.setArthritis(false);
        health.setMusclePain(true);
        health.setJointPain(false);
        health.setMuscleFlaccidity(false);
        health.setChronicFatigueSyndrome(false);
        health.setRheumatoidArthritis(false);
        health.setLupus(false);
        health.setEnvironmentalAllergies(true);
        health.setFoodAllergies(false);
        health.setAsthma(false);
        health.setFatigue(false);
        health.setLowImmunity(false);
        health.setChemicalSensitivity(false);
        health.setCancer(false);
        health.setSleepApnea(false);
        health.setDepression(false);
        health.setAnxiety(false);
        health.setHeadaches(true);
        health.setMoodSwings(false);
        health.setPremenstrualSyndrome(false);
        health.setInsomnia(false);
        health.setSmoking(true);
        health.setSleepApnea(false);
        health.setDepression(true);
        health.setAnxiety(true);
        health.setHeadaches(true);
        health.setMoodSwings(false);
        health.setPremenstrualSyndrome(false);
        health.setInsomnia(false);
        health.setSmoking(true);
        health.setCustomer(customer);
        customer.setCustomerHealth(health);
        customerHealthRepository.save(health);


        CustomerNutritionistInformation customerNutritionistInfo = new CustomerNutritionistInformation();
        customerNutritionistInfo.setVisitedNutritionist(true);
        customerNutritionistInfo.setNutritionistRecommendations("Eat more vegetables and fruits, reduce intake of processed foods.");
        customerNutritionistInfo.setMealsPerDay(3);
        customerNutritionistInfo.setCupsOfWaterPerDay(8);
        customerNutritionistInfo.setMostHungryTimeOfDay("Mid-afternoon");
        customerNutritionistInfo.setGoToSnack("Mixed nuts");
        customerNutritionistInfo.setFavoriteFood("Salmon");
        customerNutritionistInfo.setDislikedFood("Brussels sprouts");
        customerNutritionistInfo.setWeekendFoodChoice("Pizza");
        customerNutritionistInfo.setFoodAllergy(false);
        customerNutritionistInfo.setGlutenOrGrainIntolerance(false);
        customerNutritionistInfo.setDrinksAlcohol(true);
        customerNutritionistInfo.setAlcoholPerWeek(3);
        customerNutritionistInfo.setShortOnTimeForMeals(false);
        customerNutritionistInfo.setEatsOutMoreThanHalfTheTime(false);
        customerNutritionistInfo.setUnhealthyFoodAtHome(true);
        customerNutritionistInfo.setUnhealthyEatingAround(true);
        customerNutritionistInfo.setCreativeWithFood(true);
        customerNutritionistInfo.setEatsSomethingRightAfterWakingUp(true);
        customerNutritionistInfo.setGroceryBuyer(TypePersonEnum.SELF);
        customerNutritionistInfo.setPlanMeals(QuantityPercentageEnum.MEDIUM);
        customerNutritionistInfo.setPrepareMeals(QuantityPercentageEnum.LOW);
        customerNutritionistInfo.setCustomer(customer);
        customer.setCustomerNutritionistInformation(customerNutritionistInfo);
        customerNutritionistInformationRepository.save(customerNutritionistInfo);


        CustomerRotineTable customerRotineTable = new CustomerRotineTable();
        customerRotineTable.setRiceType(TypeDaysEnum.DAY);
        customerRotineTable.setRice(3);
        customerRotineTable.setPotatoType(TypeDaysEnum.WEEK);
        customerRotineTable.setPotato(2);
        customerRotineTable.setPastaType(TypeDaysEnum.MONTH);
        customerRotineTable.setPasta(1);
        customerRotineTable.setBrownRiceType(TypeDaysEnum.DAY);
        customerRotineTable.setBrownRice(1);
        customerRotineTable.setWholeWheatPastaType(TypeDaysEnum.WEEK);
        customerRotineTable.setWholeWheatPasta(1);
        customerRotineTable.setQuinoaType(TypeDaysEnum.WEEK);
        customerRotineTable.setQuinoa(0);
        customerRotineTable.setBeansType(TypeDaysEnum.WEEK);
        customerRotineTable.setBeans(4);
        customerRotineTable.setLentilsType(TypeDaysEnum.DAY);
        customerRotineTable.setLentils(2);
        customerRotineTable.setChickpeasType(TypeDaysEnum.MONTH);
        customerRotineTable.setChickpeas(1);
        customerRotineTable.setFishType(TypeDaysEnum.WEEK);
        customerRotineTable.setFish(2);
        customerRotineTable.setRedMeatType(TypeDaysEnum.DAY);
        customerRotineTable.setRedMeat(0);
        customerRotineTable.setPoultryType(TypeDaysEnum.DAY);
        customerRotineTable.setPoultry(3);
        customerRotineTable.setEggsType(TypeDaysEnum.DAY);
        customerRotineTable.setEggs(4);
        customerRotineTable.setSweetPotatoType(TypeDaysEnum.MONTH);
        customerRotineTable.setSweetPotato(3);
        customerRotineTable.setCassavaType(TypeDaysEnum.WEEK);
        customerRotineTable.setCassava(2);
        customerRotineTable.setPumpkinType(TypeDaysEnum.WEEK);
        customerRotineTable.setPumpkin(3);
        customerRotineTable.setYamType(TypeDaysEnum.WEEK);
        customerRotineTable.setYam(2);
        customerRotineTable.setKaleType(TypeDaysEnum.DAY);
        customerRotineTable.setKale(3);
        customerRotineTable.setSpinachType(TypeDaysEnum.DAY);
        customerRotineTable.setSpinach(3);
        customerRotineTable.setArugulaType(TypeDaysEnum.MONTH);
        customerRotineTable.setArugula(2);
        customerRotineTable.setLettuceType(TypeDaysEnum.DAY);
        customerRotineTable.setLettuce(3);
        customerRotineTable.setCauliflowerType(TypeDaysEnum.DAY);
        customerRotineTable.setCauliflower(3);
        customerRotineTable.setBroccoliType(TypeDaysEnum.MONTH);
        customerRotineTable.setBroccoli(3);
        customerRotineTable.setZucchiniType(TypeDaysEnum.DAY);
        customerRotineTable.setZucchini(2);
        customerRotineTable.setSoupsType(TypeDaysEnum.WEEK);
        customerRotineTable.setSoups(3);
        customerRotineTable.setSaladsType(TypeDaysEnum.MONTH);
        customerRotineTable.setSalads(3);
        customerRotineTable.setNutsType(TypeDaysEnum.WEEK);
        customerRotineTable.setNuts(3);
        customerRotineTable.setSeedsType(TypeDaysEnum.MONTH);
        customerRotineTable.setSeeds(null);
        customerRotineTable.setFruitsType(TypeDaysEnum.DAY);
        customerRotineTable.setFruits(3);
        customerRotineTable.setFlourType(TypeDaysEnum.DAY);
        customerRotineTable.setFlour(0);
        customerRotineTable.setMilkType(TypeDaysEnum.DAY);
        customerRotineTable.setMilk(3);
        customerRotineTable.setYogurtType(TypeDaysEnum.DAY);
        customerRotineTable.setYogurt(3);
        customerRotineTable.setCheeseType(TypeDaysEnum.WEEK);
        customerRotineTable.setCheese(2);
        customerRotineTable.setSlicedBreadType(TypeDaysEnum.MONTH);
        customerRotineTable.setSlicedBread(2);
        customerRotineTable.setFrenchBreadType(TypeDaysEnum.MONTH);
        customerRotineTable.setFrenchBread(2);
        customerRotineTable.setWholeWheatBreadType(TypeDaysEnum.WEEK);
        customerRotineTable.setWholeWheatBread(3);
        customerRotineTable.setProcessedMeatsType(TypeDaysEnum.MONTH);
        customerRotineTable.setProcessedMeats(0);
        customerRotineTable.setBiscuitsType(TypeDaysEnum.WEEK);
        customerRotineTable.setBiscuits(0);
        customerRotineTable.setDessertType(TypeDaysEnum.MONTH);
        customerRotineTable.setDessert(0);
        customerRotineTable.setSodaType(TypeDaysEnum.MONTH);
        customerRotineTable.setSoda(0);
        customerRotineTable.setBoxedJuiceType(TypeDaysEnum.DAY);
        customerRotineTable.setBoxedJuice(0);
        customerRotineTable.setFrozenFoodsType(TypeDaysEnum.WEEK);
        customerRotineTable.setFrozenFoods(0);
        customerRotineTable.setOrganic(QuantityPercentageEnum.NONE);
        customerRotineTable.setCustomer(customer);
        customer.setCustomerRotineTable(customerRotineTable);
        customerRotineTableRepository.save(customerRotineTable);
    }

    public void createLoginAdmin(){
        HCUser user = new HCUser();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEmail("email@email.com");
        user.setName("Leonardo Guedes");
        user.setPersonFunction("Developer Java");
        user.setAdmin(true);
        hcUserRepository.save(user);
    }

}
