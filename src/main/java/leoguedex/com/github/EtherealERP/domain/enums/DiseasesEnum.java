package leoguedex.com.github.EtherealERP.domain.enums;

import java.util.EnumSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DiseasesEnum {
    ACID_REFLUX(0, "Acid Reflux"),
    ANEMIA(1, "Anemia"),
    ANXIETY(2, "Anxiety"),
    ARTHRITIS(3, "Arthritis"),
    ASTHMA(4, "Asthma"),
    CANCER(5, "Cancer"),
    CHEMICAL_SENSITIVITY(6, "Chemical Sensitivity"),
    CHRONIC_FATIGUE_SYNDROME(7, "Chronic Fatigue Syndrome"),
    DEPRESSION(8, "Depression"),
    DIABETES(9, "Diabetes"),
    EDEMA(10, "Edema"),
    ENVIRONMENTAL_ALLERGIES(11, "Environmental Allergies"),
    FATTY_LIVER_DISEASE(12, "Fatty Liver Disease"),
    FOOD_ALLERGIES(13, "Food Allergies"),
    FUNGAL_INFECTION(14, "Fungal Infection"),
    GOUT(15, "Gout"),
    HEADACHES(16, "Headaches"),
    HEART_ATTACK(17, "Heart Attack"),
    HIGH_CHOLESTEROL(18, "High Cholesterol"),
    HYPERTENSION(19, "Hypertension"),
    HYPERTHYROIDISM(20, "Hyperthyroidism"),
    HYPOTHYROIDISM(21, "Hypothyroidism"),
    INFERTILITY(22, "Infertility"),
    INSOMNIA(23, "Insomnia"),
    IRRITATED_INTESTINE(24, "Irritated Intestine"),
    JOINT_PAIN(25, "Joint Pain"),
    KIDNEY_STONES(26, "Kidney Stones"),
    LUPUS(27, "Lupus"),
    LOW_IMMUNITY(28, "Low Immunity"),
    METABOLIC_SYNDROME(29, "Metabolic Syndrome"),
    MOOD_SWINGS(30, "Mood Swings"),
    MUSCLE_FLACCIDITY(31, "Muscle Flaccidity"),
    MUSCLE_PAIN(32, "Muscle Pain"),
    OSTEOPOROSIS(33, "Osteoporosis"),
    POLYCYSTIC_OVARY_SYNDROME(34, "Polycystic Ovary Syndrome"),
    PREMENSTRUAL_SYNDROME(35, "Premenstrual Syndrome"),
    RHEUMATOID_ARTHRITIS(36, "Rheumatoid Arthritis"),
    SLEEP_APNEA(37, "Sleep Apnea"),
    SMOKING(38, "Smoking"),
    URINARY_TRACT_INFECTION(39, "Urinary Tract Infection"),
    WEIGHT_GAIN(40, "Weight Gain"),
    REGULAR_BOWEL_MOVEMENT(41, "Regular Bowel Movement");

    private final int cod;
    private final String description;

    public static DiseasesEnum toEnum(Integer cod) {
        return EnumSet.allOf(DiseasesEnum.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

     public static DiseasesEnum toDescriptionEnum(String description) {
        return EnumSet.allOf(DiseasesEnum.class).stream()
                .filter(e -> e.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid description: " + description));
    }
}
