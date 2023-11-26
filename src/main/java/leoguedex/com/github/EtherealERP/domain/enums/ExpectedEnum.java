package leoguedex.com.github.EtherealERP.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum ExpectedEnum {

    PREVENT_DISEASE(0, "Prevenir Doenças"),
    BODY_COMPOSITION(1, "Melhorar composição corporal"),
    FOOD_ALLERGY(2, "Tratar doenças alimentares"),
    NUTRITIONAL_DEFICIENCY(3, "Correção da nutrição"),
    CONTROL_SUGAR(4, "Controlar diabetes"),
    LIQUID_RETENTION(5, "Desinchar pela retenção de líquidos"),
    CIRCULATORY_SYSTEM(6, "Cardio e circulação"),
    KIDNEY_HEALTH(7, "Alimentação saudavel"),
    PHYSICAL_CONDITIONING(8, "Alta performance");

    private final int cod;
    private final String description;

    public static ExpectedEnum toEnum(Integer cod) {
        return EnumSet.allOf(ExpectedEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

}
