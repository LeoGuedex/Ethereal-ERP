package leoguedex.com.github.HealthCoachWeb.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum TypePersonEnum {

    SELF(0, "Self"),
    FAMILY_MEMBERS(1, "Family Members"),
    FRIENDS(2, "Friends"),
    OTHERS(3, "Others");

    private final int cod;
    private final String descricao;

    public static TypePersonEnum toEnum(Integer cod) {
        return EnumSet.allOf(TypePersonEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

}
