package leoguedex.com.github.HealthCoachWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import leoguedex.com.github.HealthCoachWeb.domain.dto.UpdateUserDataDTO;
import leoguedex.com.github.HealthCoachWeb.service.HCUserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hcuser")
public class HCUserController {

  private final HCUserService service;
  
  @PostMapping
  public String updateUser(@ModelAttribute UpdateUserDataDTO fileUpload) {

    boolean updatedData = service.updateLogedUserData(fileUpload);

    if(updatedData) {
      return "redirect:/profile?updatedData=true";
    }
    
    return "redirect:/profile?updatedData=false";
  }
}
