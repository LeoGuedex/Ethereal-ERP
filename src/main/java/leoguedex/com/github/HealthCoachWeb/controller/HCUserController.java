package leoguedex.com.github.HealthCoachWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import leoguedex.com.github.HealthCoachWeb.domain.dto.UpdateUserDataDTO;

@Controller
@RequestMapping("/hcuser")
public class HCUserController {
  
  @PostMapping
  public String updateUser(@ModelAttribute UpdateUserDataDTO fileUpload) {

    return "redirect:/profile";
  }
}
