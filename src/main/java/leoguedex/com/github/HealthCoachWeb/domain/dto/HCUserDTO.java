package leoguedex.com.github.HealthCoachWeb.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HCUserDTO {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String personFunction;
    private Boolean admin;

}
