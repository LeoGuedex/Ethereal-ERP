package leoguedex.com.github.HealthCoachWeb.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.NoSuchElementException;

@Getter
@AllArgsConstructor
public enum ReasonEnum {
    PREVENT_DISEASE(0, "Previnir doenças"),
    BODY_COMPOSITION(1, "Melhorar composição corporal"),
    FOOD_ALLERGY(2, "Tratar alergias alimentares"),
    NUTRITIONAL_DEFICIENCY(3, "Tratar deficiências nutricionais"),
    CONTROL_SUGAR(4, "Controle de açucar no sangue"),
    LIQUID_RETENTION(5, "Reduzir retenção de líquidos"),
    CIRCULATORY_SYSTEM(6, "Melhorar o sistema circulatório"),
    KIDNEY_HEALTH(8, "Melhorar saúde renal"),
    PHYSICAL_CONDITIONING(9, "Condicionamento físico");

    private final int cod;
    private final String description;

    public static String codToDescription(Integer cod) {
        for (ReasonEnum indicatedByEnum : values()) {
            if (indicatedByEnum.cod == cod) {
                return indicatedByEnum.getDescription();
            }
        }
        return null;
    }
}
