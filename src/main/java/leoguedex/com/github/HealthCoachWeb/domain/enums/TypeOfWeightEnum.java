package leoguedex.com.github.HealthCoachWeb.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum TypeOfWeightEnum {

  Yoyo(0, "Io-io"),
  Stable(1, "Estavel"),
  Gain(2, "Ganho"),
  Loss(3, "Perca"),
  RapidGain(4, "Ganho acelerado"),
  CantMaintainWeight(5, "Não mantem peso");

  private final int cod;
  private final String description;

  public static TypeOfWeightEnum toEnum(Integer cod) {
    return EnumSet.allOf(TypeOfWeightEnum.class).stream()
        .filter(e -> e.getCod() == (cod))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
  }

}
