package leoguedex.com.github.HealthCoachWeb.domain;

import jakarta.persistence.*;
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
//
    private String name;
//
    private String email;
//
    private String address;
//
    private String birthDate;
//
    private String phoneNumber;
//
    private Double weight;
//
    private Double height;
//
    private Boolean worksOrStudies;
//
    private String referredBy;
//
    private String consultationReason;
//
    private String expectedOutcome;
// TODO:
    private LocalDateTime whenCreated;

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
