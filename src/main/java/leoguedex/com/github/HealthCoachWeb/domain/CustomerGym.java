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

    private Double desiredWeight;

    private Double weightOneYearAgo;

    private Double weightTenYearsAgo;

    private TypeOfWeightEnum weightType;

    private String chewing;

    private Boolean doesExercise;

    private String exerciseTypes;

    private String postExerciseFeeling;

    private Integer trainingDaysPerWeek;

    private Boolean intendsToExercise;

    private Boolean isPhysicallyActive;

    private String freeTimeActivities;

    private String exerciseLimitations;

    private String supplements;

    private QuantityPercentageEnum familyBalance;

    private String desiredFreeTimeActivity;

    private String lifeSituationToChange;

    private Integer determinationLevel;

    private Boolean improveWellBeing;

    private Boolean increaseExercise;

    private Boolean loseWeight;

    private Boolean improveSleep;

    private Boolean improveMentalHealth;

    private Boolean improveDiet;

    private Boolean increaseEnergy;

    private Boolean increaseProductivity;

    private Boolean decreaseStress;

    private Boolean improveLifeBalance;

    private Boolean jobSatisfaction;

}
