package leoguedex.com.github.EtherealERP.domain.enums;

import java.util.EnumSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeDaysEnum {

    DAILY(0, "Daily"),
    WEEKLY(1, "Weekly"),
    MONTHLY(2, "Monthly"),
    ALWAYS(3, "Always");

    private final int cod;
    private final String description;

    public static TypeDaysEnum toEnum(Integer cod) {
        return EnumSet.allOf(TypeDaysEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

    public static TypeDaysEnum toDescriptinEnum(String description) {
        return EnumSet.allOf(TypeDaysEnum.class).stream()
                .filter(e -> e.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid description: " + description));
    }

}
