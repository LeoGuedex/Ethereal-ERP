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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private String address;

    private String birthDate;

    private String phoneNumber;

    private Double weight;

    private Double height;

    private Boolean worksOrStudies;

    private String referredBy;

    private String consultationReason1;

    private String consultationReason2;

    private String consultationReason3;

    private String expectedOutcome;

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
