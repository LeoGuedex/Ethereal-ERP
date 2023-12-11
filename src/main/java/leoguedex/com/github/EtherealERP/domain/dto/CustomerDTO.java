package leoguedex.com.github.EtherealERP.domain.dto;

import leoguedex.com.github.EtherealERP.domain.Customer;
import leoguedex.com.github.EtherealERP.domain.enums.ExpectedEnum;
import leoguedex.com.github.EtherealERP.domain.enums.IndicatedByEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private long id;
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
    private IndicatedByEnum referredBy;
    private ExpectedEnum expectedOutcome;

    public static Customer toOrigin(CustomerDTO customerDTO) {
        return Customer.builder()
                .id(customerDTO.getId())
                .name(customerDTO.getName())
                .age(customerDTO.getAge())
                .email(customerDTO.getEmail())
                .weight(customerDTO.getWeight())
                .height(customerDTO.getHeight())
                .address(customerDTO.getAddress())
                .birthDate(customerDTO.getBirthDate())
                .phoneNumber(customerDTO.getPhoneNumber())
                .worksOrStudies(customerDTO.getWorksOrStudies())
                .consultationReason(customerDTO.getConsultationReason())
                .referredBy(customerDTO.getReferredBy())
                .expectedOutcome(customerDTO.getExpectedOutcome())
                .build();
    }
}
