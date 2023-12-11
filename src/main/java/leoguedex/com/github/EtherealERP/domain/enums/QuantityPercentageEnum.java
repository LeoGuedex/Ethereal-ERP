package leoguedex.com.github.EtherealERP.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum QuantityPercentageEnum {

    NONE(0, "NONE"),
    LOW(25, "LOW"),
    MEDIUM(50, "MEDIUM"),
    HIGH(75, "HIGH"),
    MAX(100, "MAX");

    private final int cod;
    private final String description;

    public static QuantityPercentageEnum toEnum(Integer cod) {
        return EnumSet.allOf(QuantityPercentageEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

    public static QuantityPercentageEnum toDescriptionEnum(String description) {
        return EnumSet.allOf(QuantityPercentageEnum.class).stream()
                .filter(e -> e.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(("Invalid description: " + description)));
    }

}
