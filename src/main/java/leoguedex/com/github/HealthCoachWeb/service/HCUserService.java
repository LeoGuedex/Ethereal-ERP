package leoguedex.com.github.HealthCoachWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import leoguedex.com.github.HealthCoachWeb.domain.HCUser;
import leoguedex.com.github.HealthCoachWeb.domain.dto.UpdateUserDataDTO;
import leoguedex.com.github.HealthCoachWeb.repository.HCUserRepository;

@Service
public class HCUserService {

  @Autowired
  private HCUserRepository repository;

  public HCUser findByEmail(String email) {
    return repository.findByEmail(email)
        .orElseThrow(() -> new NotFoundException("email not found."));
  }

  public HCUser createUser(HCUser user) {
    return repository.save(user);
  }

  public boolean updateLogedUserData(UpdateUserDataDTO newUserData) {

    HCUser logedUser = (HCUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    logedUser.setEmail(newUserData.getEmail());
    logedUser.getUserData().setAddress(newUserData.getAddress());
    logedUser.getUserData().setFirstName(newUserData.getFirstName());
    logedUser.getUserData().setLastName(newUserData.getLastName());
    logedUser.getUserData().setPhoneNumber(newUserData.getPhone());

    repository.save(logedUser);

    return true;
  }

}
