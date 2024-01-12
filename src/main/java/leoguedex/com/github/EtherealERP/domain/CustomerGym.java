package leoguedex.com.github.EtherealERP.domain;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import leoguedex.com.github.EtherealERP.domain.enums.HealthGoalsEnum;
import leoguedex.com.github.EtherealERP.domain.enums.QuantityPercentageEnum;
import leoguedex.com.github.EtherealERP.domain.enums.TypeOfWeightEnum;
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
    private Long id;

    @MapsId
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String supplements;
    private Double desiredWeight;
    private String exerciseTypes;
    private Double weightOneYearAgo;
    private Double weightTenYearsAgo;
    private Boolean jobSatisfaction;
    private Boolean intendsToExercise;
    private String freeTimeActivities;
    private Boolean doesExercise;
    private Boolean isPhysicallyActive;
    private String postExerciseFeeling;
    private String exerciseLimitations;
    private Integer determinationLevel;
    private String trainingDaysPerWeek;
    private TypeOfWeightEnum weightType;
    private String lifeSituationToChange;
    private String desiredFreeTimeActivity;
    private QuantityPercentageEnum familyBalance;

    @ElementCollection(targetClass = HealthGoalsEnum.class)
    @CollectionTable(name = "Goals", joinColumns = @JoinColumn(name = "customer_id"))
    @Enumerated(EnumType.STRING)
    private Set<HealthGoalsEnum> goalsArray;
}
