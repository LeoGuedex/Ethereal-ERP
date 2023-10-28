package leoguedex.com.github.HealthCoachWeb.domain;

import jakarta.persistence.*;
import leoguedex.com.github.HealthCoachWeb.domain.enums.QuantityPercentageEnum;
import leoguedex.com.github.HealthCoachWeb.domain.enums.TypeOfWeightEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerGym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String supplements;
    private Boolean loseWeight;
    private Boolean improveDiet;
    private Boolean doesExercise;
    private Double desiredWeight;
    private Boolean improveSleep;
    private String exerciseTypes;
    private Boolean increaseEnergy;
    private Boolean decreaseStress;
    private Double weightOneYearAgo;
    private Boolean jobSatisfaction;
    private Double weightTenYearsAgo;
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

}
