package leoguedex.com.github.HealthCoachWeb.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum SleepTypeEnum {
    EXCELLENT(0, "Excellent"),
    GOOD(1, "Good"),
    POOR(2, "Poor"),
    DIFFICULTY_FALLING_ASLEEP(3, "Difficulty Falling Asleep"),
    RESTORATIVE(4, "Restorative"),
    DAYTIME_SLEEPINESS(5, "Day time Sleepiness"),
    SNORING(6, "Snoring"),
    APNEA(7, "Apnea"),
    NIGHT_AGGITATION(8, "Night Agitation");

    private final int cod;
    private final String SleepTypeEnum;

    public static SleepTypeEnum toEnum(Integer cod) {
        return EnumSet.allOf(SleepTypeEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

}
