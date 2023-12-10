package leoguedex.com.github.EtherealERP.view;

import jakarta.websocket.server.PathParam;
import leoguedex.com.github.EtherealERP.controller.CustomerController;
import leoguedex.com.github.EtherealERP.domain.Customer;
import leoguedex.com.github.EtherealERP.domain.ETUser;
import leoguedex.com.github.EtherealERP.domain.dto.CustomerWithColor;
import leoguedex.com.github.EtherealERP.domain.dto.UpdateUserDataDTO;
import leoguedex.com.github.EtherealERP.service.RandomGenerateColors;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

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
    public String index(Model model) {
        ModelMapper modelMapper = new ModelMapper();
        int amountCustomers = customerController.findAllCustomers().getBody().size();
        List<Customer> customersNotColor = customerController.newlyRegistered().getBody();

        List<String> colors = new RandomGenerateColors(customersNotColor.size()).getRandomColor();

        List<CustomerWithColor> customers = new ArrayList<>();

        for (int i = 0; i < customersNotColor.size(); i++) {
            CustomerWithColor customerWithColor = modelMapper.map(customersNotColor.get(i), CustomerWithColor.class);
            customerWithColor.setColor(colors.get(i));

            customers.add(customerWithColor);
        }

        model.addAttribute("amountCustomers", amountCustomers);
        model.addAttribute("newlyRegistered", customers);

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

    @ExceptionHandler(value = {Exception.class})
    public String handleException() {
        return "pages-error-404";
    }

}
