package leoguedex.com.github.HealthCoachWeb.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExpectedEnum {
    PREVENT_DISEASE(0, "Evitar a longo prazo o aparecimento de doenças"),
    BODY_COMPOSITION(1,  "Mudar meu corpo em 6 meses"),
    FOOD_ALLERGY(2, "Reduzir meus problemas com amêndoas"),
    NUTRITIONAL_DEFICIENCY(3, "No próximo exame de sangue normalizar minhas vitaminas"),
    CONTROL_SUGAR(4,  "Reduzir minhas diabetes"),
    LIQUID_RETENTION(5, "No próximos meses gostaria de reduzir o inchaço causado pela retenção"),
    CIRCULATORY_SYSTEM(6, "Gostaria de desentupir minhas veias"),
    KIDNEY_HEALTH(8, "Gostaria de uma dieta para auxiliar a saída da pedra do meu rim"),
    PHYSICAL_CONDITIONING(9, "Sou atleta e gostaria de me manter em alta performance");

    private final int cod;
    private final String description;

    public static String codToDescription(Integer cod) {
        for (ExpectedEnum expectedEnum : values()) {
            if (expectedEnum.cod == cod) {
                return expectedEnum.getDescription();
            }
        }
        return null;
    }
}
