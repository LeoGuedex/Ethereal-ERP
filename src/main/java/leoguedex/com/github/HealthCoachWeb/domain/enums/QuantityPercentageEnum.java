package leoguedex.com.github.HealthCoachWeb.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum QuantityPercentageEnum {
    NONE(0, "None"),
    LOW(25, "Low"),
    MEDIUM(50, "Medium"),
    HIGH(75, "High"),
    MAX(100, "Max");

    private final int cod;
    private final String descricao;

    public static QuantityPercentageEnum toEnum(Integer cod) {
        return EnumSet.allOf(QuantityPercentageEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

}
