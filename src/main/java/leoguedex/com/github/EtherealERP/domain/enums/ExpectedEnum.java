package leoguedex.com.github.EtherealERP.domain.enums;

import java.util.EnumSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExpectedEnum {

    PREVENT_DISEASE(0, "Prevent Diseases"),
    BODY_COMPOSITION(1, "Improve Body Composition"),
    FOOD_ALLERGY(2, "Treat Food Allergies"),
    NUTRITIONAL_DEFICIENCY(3, "Nutritional Correction"),
    CONTROL_SUGAR(4, "Manage Diabetes"),
    LIQUID_RETENTION(5, "Reduce Swelling due to Liquid Retention"),
    CIRCULATORY_SYSTEM(6, "Cardio and Circulatory Health"),
    KIDNEY_HEALTH(7, "Healthy Eating for Kidney Health"),
    PHYSICAL_CONDITIONING(8, "High-Performance Physical Conditioning");

    private final int cod;
    private final String description;

    public static ExpectedEnum toEnum(Integer cod) {
        return EnumSet.allOf(ExpectedEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

}
