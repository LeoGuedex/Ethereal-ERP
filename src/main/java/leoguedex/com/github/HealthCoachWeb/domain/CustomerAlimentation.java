package leoguedex.com.github.HealthCoachWeb.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAlimentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Boolean eatsUponWakingUp;

    private String breakfast;

    private Boolean eatsBeforeLunch;

    private String beforeLunchMeal;

    private Boolean eatsLunch;

    private String lunch;

    private Boolean eatsAfternoonSnack;

    private String afternoonSnack;

    private Boolean eatsDinner;

    private String dinner;

    private Boolean eatsBeforeBedtime;

    private String beforeBedtimeSnack;

    @Override
    public String toString() {
        return "CustomerAlimentation{" +
                "id=" + id +
                ", eatsUponWakingUp=" + eatsUponWakingUp +
                ", breakfast='" + breakfast + '\'' +
                ", eatsBeforeLunch=" + eatsBeforeLunch +
                ", beforeLunchMeal='" + beforeLunchMeal + '\'' +
                ", eatsLunch=" + eatsLunch +
                ", lunch='" + lunch + '\'' +
                ", eatsAfternoonSnack=" + eatsAfternoonSnack +
                ", afternoonSnack='" + afternoonSnack + '\'' +
                ", eatsDinner=" + eatsDinner +
                ", dinner='" + dinner + '\'' +
                ", eatsBeforeBedtime=" + eatsBeforeBedtime +
                ", beforeBedtimeSnack='" + beforeBedtimeSnack + '\'' +
                '}';
    }

}