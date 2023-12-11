package leoguedex.com.github.EtherealERP.domain;


import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
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
