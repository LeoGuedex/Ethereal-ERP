package leoguedex.com.github.EtherealERP.domain;

import jakarta.persistence.*;
import leoguedex.com.github.EtherealERP.domain.enums.ExpectedEnum;
import leoguedex.com.github.EtherealERP.domain.enums.IndicatedByEnum;
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

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerAlimentation customerAlimentation;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerGym customerGym;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerHealth customerHealth;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerNutritionistInformation customerNutritionistInformation;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerRotineTable customerRotineTable;

}
