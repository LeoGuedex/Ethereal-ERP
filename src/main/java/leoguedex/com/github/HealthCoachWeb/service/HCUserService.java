package leoguedex.com.github.HealthCoachWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import leoguedex.com.github.HealthCoachWeb.domain.HCUser;
import leoguedex.com.github.HealthCoachWeb.domain.dto.UpdatePasswordDTO;
import leoguedex.com.github.HealthCoachWeb.domain.dto.UpdateUserDataDTO;
import leoguedex.com.github.HealthCoachWeb.exception.ApiException;
import leoguedex.com.github.HealthCoachWeb.repository.HCUserRepository;

@Service
public class HCUserService {

  @Autowired
  private HCUserRepository repository;

  @Autowired
  private PasswordEncoder encoder;

  public HCUser findByEmail(String email) {
    return repository.findByEmail(email)
        .orElseThrow(() -> new NotFoundException("email not found."));
  }

  public HCUser createUser(HCUser user) {
    return repository.save(user);
  }

  public boolean updateLogedUserData(UpdateUserDataDTO newUserData) {

    HCUser logedUser = getLogedUser();
    logedUser.setEmail(newUserData.getEmail());
    logedUser.getUserData().setAddress(newUserData.getAddress());
    logedUser.getUserData().setFirstName(newUserData.getFirstName());
    logedUser.getUserData().setLastName(newUserData.getLastName());
    logedUser.getUserData().setPhoneNumber(newUserData.getPhone());

    repository.save(logedUser);

    return true;
  }
  
  public void updatePassword(UpdatePasswordDTO updatePasswordDTO) {
    
    HCUser logedUser = getLogedUser();

    Boolean passwordMatch = encoder.matches(updatePasswordDTO.getCurrentPassword(), logedUser.getPassword());
    if (!passwordMatch) {
      throw new ApiException("the old password doesn't match", HttpStatus.BAD_REQUEST);
    }
    logedUser.setPassword(encoder.encode(updatePasswordDTO.getNewPassword()));
    repository.save(logedUser);
  }

  private HCUser getLogedUser() {
    return (HCUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }

}
