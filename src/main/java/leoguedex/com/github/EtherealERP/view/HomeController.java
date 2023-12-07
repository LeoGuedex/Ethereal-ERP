package leoguedex.com.github.EtherealERP.view;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.websocket.server.PathParam;
import leoguedex.com.github.EtherealERP.controller.CustomerController;
import leoguedex.com.github.EtherealERP.domain.Customer;
import leoguedex.com.github.EtherealERP.domain.ETUser;
import leoguedex.com.github.EtherealERP.domain.dto.AllCustomerDTO;
import leoguedex.com.github.EtherealERP.domain.dto.UpdateUserDataDTO;
import leoguedex.com.github.EtherealERP.domain.enums.DiseasesEnum;
import leoguedex.com.github.EtherealERP.domain.enums.ExpectedEnum;
import leoguedex.com.github.EtherealERP.domain.enums.HealthGoalsEnum;
import leoguedex.com.github.EtherealERP.domain.enums.IndicatedByEnum;
import leoguedex.com.github.EtherealERP.domain.enums.QuantityPercentageEnum;
import leoguedex.com.github.EtherealERP.domain.enums.SleepTypeEnum;
import leoguedex.com.github.EtherealERP.domain.enums.TypeOfWeightEnum;
import leoguedex.com.github.EtherealERP.domain.enums.TypePersonEnum;

@Controller
public class HomeController {

    private final CustomerController customerController;

    public HomeController(CustomerController customerController) {
        this.customerController = customerController;
    }

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

    @GetMapping("/newCustomer")
    public String newCustomer(Model model) {
        model.addAttribute(new AllCustomerDTO());
        model.addAttribute("IndicatedByEnumValues", IndicatedByEnum.values());
        model.addAttribute("ExpectedEnumValues", ExpectedEnum.values());
        model.addAttribute("TypeOfWeighValues", TypeOfWeightEnum.values());
        model.addAttribute("QuantityPercentageValues", QuantityPercentageEnum.values());
        model.addAttribute("SleepTypeValues", SleepTypeEnum.values());
        model.addAttribute("DiseasesValues", DiseasesEnum.values());
        model.addAttribute("TypePersonValues", TypePersonEnum.values());
        model.addAttribute("HealthGoalsValues", HealthGoalsEnum.values());

        return "new-customer-layouts";

    }

    @GetMapping("/contact")
    public String contact() {
        return "pages-contact";
    }

    @GetMapping("/showCustomers")
    public String showCustomers(Model model) {
        List<Customer> customers = customerController.findAllCustomers().getBody();
        model.addAttribute("customers", customers);

        return "tables-data";
    }

    @GetMapping("/profile")
    public String profile(Model model, @PathParam("updatedData") Boolean updatedData) {
        ETUser ETUser = (ETUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userDataDTO", new UpdateUserDataDTO(ETUser));
        model.addAttribute("updatedData", updatedData);
        return "users-profile";
    }

    @ExceptionHandler(value = { Exception.class })
    public String handleException() {
        return "pages-error-404";
    }

}
