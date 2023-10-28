package leoguedex.com.github.HealthCoachWeb.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IndicatedByEnum {
    
    FRIEND(0, "Amigos"),
    AD(1, "Anúncios"),
    NOT_INDICATED(2, "Não fui indicado"),
    SEARCH_INTERNET(3, "Pesquisa na internet"),
    OTHERS(4, "Outros");

    private final int cod;
    private final String description;

    public static String codToDescription(Integer cod) {
        for (IndicatedByEnum indicatedByEnum : values()) {
            if (indicatedByEnum.cod == cod) {
                return indicatedByEnum.getDescription();
            }
        }
        return null;
    }
    
}
