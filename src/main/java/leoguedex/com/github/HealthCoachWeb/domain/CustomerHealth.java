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

    private String moodDescription;

    private SleepTypeEnum sleepTypeEnum;

    private int weekdaySleepHours;

    private int weekendSleepHours;

    private QuantityPercentageEnum concentration;

    private QuantityPercentageEnum recentMemory;

    private QuantityPercentageEnum longTermMemory;

    private QuantityPercentageEnum daytimeEnergy;

    private QuantityPercentageEnum morningDisposition;

    private QuantityPercentageEnum afternoonDisposition;

    private QuantityPercentageEnum eveningDisposition;

    private String sleepImprovementMethods;

    private String energyReductionMethods;

    private QuantityPercentageEnum stressLevel;

    private String stressReductionMethods;

    private String healthDescription;

    private Boolean regularBowelMovement;

    private Boolean irritatedIntestine;

    private Boolean acidReflux;

    private Boolean gastritis;

    private Boolean ulcer;

    private Boolean heartAttack;

    private Boolean hypertension;

    private Boolean highCholesterol;

    private Boolean edema;

    private Boolean hypothyroidism;

    private Boolean diabetes;

    private Boolean infertility;

    private Boolean weightGain;

    private Boolean anemia;

    private Boolean hyperthyroidism;

    private Boolean metabolicSyndrome;

    private Boolean fattyLiverDisease;

    private Boolean weightFluctuations;

    private Boolean polycysticOvarySyndrome;

    private Boolean gout;

    private Boolean urinaryTractInfection;

    private Boolean fungalInfection;

    private Boolean kidneyStones;

    private Boolean osteoporosis;

    private Boolean arthritis;

    private Boolean musclePain;

    private Boolean jointPain;

    private Boolean muscleFlaccidity;

    private Boolean chronicFatigueSyndrome;

    private Boolean rheumatoidArthritis;

    private Boolean lupus;

    private Boolean environmentalAllergies;

    private Boolean foodAllergies;

    private Boolean asthma;

    private Boolean fatigue;

    private Boolean lowImmunity;

    private Boolean chemicalSensitivity;

    private Boolean cancer;

    private Boolean sleepApnea;

    private Boolean depression;

    private Boolean anxiety;

    private Boolean headaches;

    private Boolean moodSwings;

    private Boolean premenstrualSyndrome;

    private Boolean insomnia;

    private Boolean smoking;

}
