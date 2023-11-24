package leoguedex.com.github.HealthCoachWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import leoguedex.com.github.HealthCoachWeb.domain.HCUser;
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

}
