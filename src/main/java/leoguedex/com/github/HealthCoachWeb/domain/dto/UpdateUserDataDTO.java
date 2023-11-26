package leoguedex.com.github.HealthCoachWeb.domain.dto;

import org.springframework.web.multipart.MultipartFile;

import leoguedex.com.github.HealthCoachWeb.domain.HCUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDataDTO {
  private String firstName;
  private MultipartFile hcUserPic;
  private String lastName;
  private String address;
  private String email;
  private String phone;

  public UpdateUserDataDTO(HCUser hcUser) {

    this.firstName = hcUser.getUserData().getFirstName();
    this.lastName = hcUser.getUserData().getLastName();
    this.address = hcUser.getUserData().getAddress();
    this.email = hcUser.getEmail();
    this.phone = hcUser.getUserData().getPhoneNumber();
  }
}
