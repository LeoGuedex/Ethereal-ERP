package leoguedex.com.github.EtherealERP.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum TypePersonEnum {

    SELF(0, "Sozinho"),
    FAMILY_MEMBERS(1, "Família"),
    FRIENDS(2, "Amigos"),
    OTHERS(3, "Outros");

    private final int cod;
    private final String description;

    public static TypePersonEnum toEnum(Integer cod) {
        return EnumSet.allOf(TypePersonEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

}
