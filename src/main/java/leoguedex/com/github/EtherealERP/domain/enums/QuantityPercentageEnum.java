package leoguedex.com.github.EtherealERP.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum QuantityPercentageEnum {

    NONE(0, "Nenhum"),
    LOW(25, "Baixo"),
    MEDIUM(50, "Medio"),
    HIGH(75, "Alto"),
    MAX(100, "Maximo");

    private final int cod;
    private final String description;

    public static QuantityPercentageEnum toEnum(Integer cod) {
        return EnumSet.allOf(QuantityPercentageEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

}
