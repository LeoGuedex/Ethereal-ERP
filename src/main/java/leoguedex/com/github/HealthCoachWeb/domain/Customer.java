package leoguedex.com.github.HealthCoachWeb.domain;

import jakarta.persistence.*;
import leoguedex.com.github.HealthCoachWeb.domain.enums.ExpectedEnum;
import leoguedex.com.github.HealthCoachWeb.domain.enums.IndicatedByEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String email;
    private Double weight;
    private Double height;
    private String address;
    private String birthDate;
    private String phoneNumber;
    private Boolean worksOrStudies;
    private String consultationReason;
    private String whenCreated;
    private IndicatedByEnum referredBy;
    private ExpectedEnum expectedOutcome;

    @OneToOne(mappedBy = "customer")
    private CustomerAlimentation customerAlimentation;

    @OneToOne(mappedBy = "customer")
    private CustomerGym customerGym;

    @OneToOne(mappedBy = "customer")
    private CustomerHealth customerHealth;

    @OneToOne(mappedBy = "customer")
    private CustomerNutritionistInformation customerNutritionistInformation;

    @OneToOne(mappedBy = "customer")
    private CustomerRotineTable customerRotineTable;

}
