package leoguedex.com.github.EtherealERP.domain.dto;

import leoguedex.com.github.EtherealERP.domain.ETUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDataDTO {

    private String firstName;
    private MultipartFile hcUserPic;
    private boolean updatedUserPic;
    private String lastName;
    private String address;
    private String email;
    private String phone;

    public UpdateUserDataDTO(ETUser ETUser) {
        this.firstName = ETUser.getUserData().getFirstName();
        this.lastName = ETUser.getUserData().getLastName();
        this.address = ETUser.getUserData().getAddress();
        this.email = ETUser.getEmail();
        this.phone = ETUser.getUserData().getPhoneNumber();
    }
}
