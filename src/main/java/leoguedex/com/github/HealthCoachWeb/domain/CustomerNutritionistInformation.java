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

    private Boolean visitedNutritionist;

    private String nutritionistRecommendations;

    private Integer mealsPerDay;
    private Integer cupsOfWaterPerDay;
    
    private String mostHungryTimeOfDay;

    private String goToSnack;

    private String favoriteFood;

    private String dislikedFood;

    private String weekendFoodChoice;

    private Boolean foodAllergy;
    private Boolean glutenOrGrainIntolerance;
    private Boolean drinksAlcohol;
    private Integer alcoholPerWeek;

    private Boolean ShortOnTimeForMeals;
    private Boolean eatsOutMoreThanHalfTheTime;
    private Boolean unhealthyFoodAtHome;
    private Boolean unhealthyEatingAround;
    private Boolean creativeWithFood;
    private Boolean eatsSomethingRightAfterWakingUp;

    private TypePersonEnum groceryBuyer;

    private QuantityPercentageEnum planMeals;

    private QuantityPercentageEnum prepareMeals;

}
