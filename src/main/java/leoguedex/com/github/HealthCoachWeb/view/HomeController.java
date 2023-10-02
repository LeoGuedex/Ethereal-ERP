package leoguedex.com.github.HealthCoachWeb.view;

import leoguedex.com.github.HealthCoachWeb.Exception.GetAgeFromBirthDateException;
import leoguedex.com.github.HealthCoachWeb.controller.CustomerController;
import leoguedex.com.github.HealthCoachWeb.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CustomerController customerController;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/forms")
    public String forms() {
        return "forms-layouts";
    }

    @GetMapping("/contact")
    public String contact() {
        return "pages-contact";
    }

    @GetMapping("/404")
    public String error404() {
        return "pages-error-404";
    }

    @GetMapping("/showCustomers")
    public String showCustomers(Model model) throws GetAgeFromBirthDateException {
        List<Customer> customers = customerController.findAllCustomers().getBody();
        model.addAttribute("customers",customers);
        return "tables-data";
    }

    @GetMapping("/profile")
    public String profile() {
        return "users-profile";
    }

    @ExceptionHandler(value = { Exception.class })
    public String handleException() {
        return "pages-error-404";
    }

}
