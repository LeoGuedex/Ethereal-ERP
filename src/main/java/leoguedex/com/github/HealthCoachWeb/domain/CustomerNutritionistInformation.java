package leoguedex.com.github.HealthCoachWeb.domain;

import jakarta.persistence.*;
import leoguedex.com.github.HealthCoachWeb.domain.enums.QuantityPercentageEnum;
import leoguedex.com.github.HealthCoachWeb.domain.enums.TypePersonEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerNutritionistInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

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

}
