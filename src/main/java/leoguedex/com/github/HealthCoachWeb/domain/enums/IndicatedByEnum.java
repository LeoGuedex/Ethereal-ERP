package leoguedex.com.github.HealthCoachWeb.domain.enums;

import java.util.EnumSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IndicatedByEnum {
    
    FRIEND(0, "Amigos"),
    AD(1, "Anúncios"),
    NOT_INDICATED(2, "Não fui indicado"),
    SEARCH_INTERNET(3, "Pesquisei na internet"),
    OTHERS(4, "Outros");

    private final int cod;
    private final String description;

    public static IndicatedByEnum toEnum(Integer cod) {
        return EnumSet.allOf(IndicatedByEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }
    
}
