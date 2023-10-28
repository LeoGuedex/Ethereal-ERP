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

    private Boolean doesExercise;

    private String exerciseTypes;

    private Integer trainingDaysPerWeek;

    private String postExerciseFeeling;

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

    @Override
    public String toString() {
        return "CustomerGym{" +
                "id=" + id +
                ", desiredWeight=" + desiredWeight +
                ", weightOneYearAgo=" + weightOneYearAgo +
                ", weightTenYearsAgo=" + weightTenYearsAgo +
                ", weightType=" + weightType +
                ", doesExercise=" + doesExercise +
                ", exerciseTypes='" + exerciseTypes + '\'' +
                ", trainingDaysPerWeek=" + trainingDaysPerWeek +
                ", postExerciseFeeling='" + postExerciseFeeling + '\'' +
                ", intendsToExercise=" + intendsToExercise +
                ", isPhysicallyActive=" + isPhysicallyActive +
                ", freeTimeActivities='" + freeTimeActivities + '\'' +
                ", exerciseLimitations='" + exerciseLimitations + '\'' +
                ", supplements='" + supplements + '\'' +
                ", familyBalance=" + familyBalance +
                ", desiredFreeTimeActivity='" + desiredFreeTimeActivity + '\'' +
                ", lifeSituationToChange='" + lifeSituationToChange + '\'' +
                ", determinationLevel=" + determinationLevel +
                ", improveWellBeing=" + improveWellBeing +
                ", increaseExercise=" + increaseExercise +
                ", loseWeight=" + loseWeight +
                ", improveSleep=" + improveSleep +
                ", improveMentalHealth=" + improveMentalHealth +
                ", improveDiet=" + improveDiet +
                ", increaseEnergy=" + increaseEnergy +
                ", increaseProductivity=" + increaseProductivity +
                ", decreaseStress=" + decreaseStress +
                ", improveLifeBalance=" + improveLifeBalance +
                ", jobSatisfaction=" + jobSatisfaction +
                '}';
    }

}
