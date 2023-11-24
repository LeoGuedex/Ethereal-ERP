package leoguedex.com.github.HealthCoachWeb.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import leoguedex.com.github.HealthCoachWeb.service.HCUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private HCUserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userService.findByEmail(username);
  }

}
