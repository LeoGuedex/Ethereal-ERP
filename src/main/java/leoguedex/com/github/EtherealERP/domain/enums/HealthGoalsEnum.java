package leoguedex.com.github.EtherealERP.domain.enums;

import java.util.EnumSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HealthGoalsEnum {

    IMPROVE_SLEEP(0, "Improve Sleep"),
    LOSE_WEIGHT(1, "Improve Sleep"),
    IMPROVE_DIET(2, "Improve Sleep"),
    DOES_EXERCISE(3, "Improve Sleep"),
    INCREASE_ENERGY(4, "Improve Sleep"),
    DECREASE_STRESS(5, "Improve Sleep"),
    IMPROVE_LIFE_BALANCE(6, "Improve Sleep"),
    IMPROVE_MENTAL_HEALTH(7, "Improve Sleep"),
    INCREASE_PRODUCTIVITY(8, "Improve Sleep"),
    IMPROVE_WELL_BEING(9, "Improve Sleep"),
    INCREASE_EXERCISE(10, "Improve Sleep");

    private final Integer cod;
    private final String description;

    public static HealthGoalsEnum toEnum(Integer cod) {
        return EnumSet.allOf(HealthGoalsEnum.class).stream()
        .filter(e -> e.getCod() == (cod))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(("Invalid Id: " + cod)));
        
    }
}
