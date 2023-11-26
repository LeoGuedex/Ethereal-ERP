package leoguedex.com.github.HealthCoachWeb.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import leoguedex.com.github.HealthCoachWeb.controller.CustomerController;
import leoguedex.com.github.HealthCoachWeb.domain.Customer;
import leoguedex.com.github.HealthCoachWeb.domain.HCUser;
import leoguedex.com.github.HealthCoachWeb.domain.dto.UpdateUserDataDTO;
import leoguedex.com.github.HealthCoachWeb.exception.GetAgeFromBirthDateException;

@Controller
public class HomeController {

  @Autowired
  private CustomerController customerController;

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/")
  public String home() {
    return "redirect:/home";
  }

  @GetMapping("/home")
  public String index() {
    return "home";
  }

  @GetMapping("/forms")
  public String forms() {
    return "forms-layouts";
  }

  @GetMapping("/contact")
  public String contact() {
    return "pages-contact";
  }

  @GetMapping("/showCustomers")
  public String showCustomers(Model model) throws GetAgeFromBirthDateException {
    List<Customer> customers = customerController.findAllCustomers().getBody();
    model.addAttribute("customers", customers);

    return "tables-data";
  }

  @GetMapping("/profile")
  public String profile(Model model) {
    HCUser hcUser = (HCUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    model.addAttribute("userDataDTO", new UpdateUserDataDTO(hcUser));
    return "users-profile";
  }

  @ExceptionHandler(value = {Exception.class})
  public String handleException() {
    return "pages-error-404";
  }

}
