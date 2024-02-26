package leoguedex.com.github.EtherealERP.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
