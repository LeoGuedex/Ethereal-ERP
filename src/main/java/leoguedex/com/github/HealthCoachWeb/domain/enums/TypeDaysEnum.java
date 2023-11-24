package leoguedex.com.github.HealthCoachWeb.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum TypeDaysEnum {

  DAY(0, "Dia"),
  WEEK(1, "Semana"),
  MONTH(2, "Mês");

  private final int cod;
  private final String description;

  public static TypeDaysEnum toEnum(Integer cod) {
    return EnumSet.allOf(TypeDaysEnum.class).stream()
        .filter(e -> e.getCod() == (cod))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
  }

}
