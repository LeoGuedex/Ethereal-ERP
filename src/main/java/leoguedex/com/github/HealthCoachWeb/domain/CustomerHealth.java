package leoguedex.com.github.HealthCoachWeb.domain;

import jakarta.persistence.*;
import leoguedex.com.github.HealthCoachWeb.domain.enums.QuantityPercentageEnum;
import leoguedex.com.github.HealthCoachWeb.domain.enums.SleepTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerHealth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

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
    
}
