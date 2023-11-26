package leoguedex.com.github.EtherealERP.domain;

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

    private String lunch;
    private String dinner;
    private String breakfast;
    private Boolean eatsLunch;
    private Boolean eatsDinner;
    private String afternoonSnack;
    private String beforeLunchMeal;
    private Boolean eatsBeforeLunch;
    private Boolean eatsUponWakingUp;
    private Boolean eatsAfternoonSnack;
    private Boolean eatsBeforeBedtime;
    private String beforeBedtimeSnack;

}