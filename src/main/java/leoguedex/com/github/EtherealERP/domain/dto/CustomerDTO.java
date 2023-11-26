package leoguedex.com.github.EtherealERP.domain.dto;

import java.time.LocalDateTime;

import leoguedex.com.github.EtherealERP.domain.enums.ExpectedEnum;
import leoguedex.com.github.EtherealERP.domain.enums.IndicatedByEnum;
import lombok.Data;

@Data
public class CustomerDTO {
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
    private LocalDateTime whenCreated;
    private IndicatedByEnum referredBy;
    private ExpectedEnum expectedOutcome;
}
