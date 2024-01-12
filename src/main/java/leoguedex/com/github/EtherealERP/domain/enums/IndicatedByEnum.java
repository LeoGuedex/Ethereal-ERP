package leoguedex.com.github.EtherealERP.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum IndicatedByEnum {

    FRIEND(0, "By friends"),
    AD(1, "By ads"),
    NOT_INDICATED(2, "I wasn't nominated"),
    SEARCH_INTERNET(3, "I searched the internet"),
    OTHERS(4, "Others");

    private final int cod;
    private final String description;

    public static IndicatedByEnum toEnum(Integer cod) {
        return EnumSet.allOf(IndicatedByEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

}
