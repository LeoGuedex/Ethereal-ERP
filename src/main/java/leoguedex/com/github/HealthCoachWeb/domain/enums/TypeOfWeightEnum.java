package leoguedex.com.github.HealthCoachWeb.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum TypeOfWeightEnum {
    Yoyo(0, "Yoyo"),
    Stable(1, "Stable"),
    Gain(2, "Gain"),
    Loss(3, "Loss"),
    RapidGain(4, "Rapid Gain"),
    CantMaintainWeight(5, "Cant Maintan Weight");

    private final int cod;
    private final String descricao;

    public static TypeOfWeightEnum toEnum(Integer cod) {
        return EnumSet.allOf(TypeOfWeightEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

}
