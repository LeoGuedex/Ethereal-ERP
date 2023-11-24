package leoguedex.com.github.HealthCoachWeb.view;

import leoguedex.com.github.HealthCoachWeb.exception.GetAgeFromBirthDateException;
import leoguedex.com.github.HealthCoachWeb.controller.CustomerController;
import leoguedex.com.github.HealthCoachWeb.domain.Customer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

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
    return "redirect:/index";
  }

  @GetMapping("/index")
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
  public String profile() {
    return "users-profile";
  }

  @ExceptionHandler(value = {Exception.class})
  public String handleException() {
    return "pages-error-404";
  }

}
