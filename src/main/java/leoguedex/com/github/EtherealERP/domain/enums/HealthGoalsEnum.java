package leoguedex.com.github.EtherealERP.domain.enums;

import java.util.EnumSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HealthGoalsEnum {

    IMPROVE_SLEEP(0, "Improve Sleep"),
    LOSE_WEIGHT(1, "Lose Weight"),
    IMPROVE_DIET(2, "Improve Diet"),
    INCREASE_PHYSICAL_ACTIVITY(3, "Increase Physical Activity"),
    INCREASE_ENERGY(4, "Increase Energy"),
    DECREASE_STRESS(5, "Decrease Stress"),
    IMPROVE_LIFE_BALANCE(6, "Improve Life Balance"),
    IMPROVE_MENTAL_HEALTH(7, "Improve Mental Health"),
    INCREASE_PRODUCTIVITY(8, "Increase Productivity"),
    IMPROVE_WELL_BEING(9, "Improve Well-being"),
    INCREASE_EXERCISE(10, "Increase Exercise");

    private final Integer cod;
    private final String description;

    public static HealthGoalsEnum toEnum(Integer cod) {
        return EnumSet.allOf(HealthGoalsEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(("Invalid Id: " + cod)));
    }

    public static HealthGoalsEnum toDescriptionEnum(String description) {
        return EnumSet.allOf(HealthGoalsEnum.class).stream()
                .filter(e -> e.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(("Invalid description: " + description)));
    }

}
