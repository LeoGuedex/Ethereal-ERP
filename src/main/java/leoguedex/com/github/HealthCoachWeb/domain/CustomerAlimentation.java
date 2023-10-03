package leoguedex.com.github.HealthCoachWeb.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
//TODO: Fazer uma seleção e aparecer um texto para escrever
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

}