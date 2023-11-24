package leoguedex.com.github.HealthCoachWeb.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum SleepTypeEnum {

  EXCELLENT(0, "Excelente"),
  GOOD(1, "Bom"),
  POOR(2, "Ruim"),
  DIFFICULTY_FALLING_ASLEEP(3, "Dificuldade para dormir"),
  RESTORATIVE(4, "Restaurativo"),
  DAYTIME_SLEEPINESS(5, "Dia sonolento"),
  APNEA(6, "Apneia do sono"),
  NIGHT_AGGITATION(7, "Agitação noturna");

  private final int cod;
  private final String description;

  public static SleepTypeEnum toEnum(Integer cod) {
    return EnumSet.allOf(SleepTypeEnum.class).stream()
        .filter(e -> e.getCod() == (cod))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
  }

}
