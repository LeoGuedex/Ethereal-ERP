package leoguedex.com.github.EtherealERP.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.websocket.server.PathParam;
import leoguedex.com.github.EtherealERP.controller.CustomerController;
import leoguedex.com.github.EtherealERP.domain.Customer;
import leoguedex.com.github.EtherealERP.domain.CustomerRotineTable;
import leoguedex.com.github.EtherealERP.domain.ETUser;
import leoguedex.com.github.EtherealERP.domain.dto.AllCustomerDTO;
import leoguedex.com.github.EtherealERP.domain.dto.CustomerWithColor;
import leoguedex.com.github.EtherealERP.domain.dto.UpdateUserDataDTO;
import leoguedex.com.github.EtherealERP.domain.enums.DiseasesEnum;
import leoguedex.com.github.EtherealERP.domain.enums.ExpectedEnum;
import leoguedex.com.github.EtherealERP.domain.enums.HealthGoalsEnum;
import leoguedex.com.github.EtherealERP.domain.enums.IndicatedByEnum;
import leoguedex.com.github.EtherealERP.domain.enums.QuantityPercentageEnum;
import leoguedex.com.github.EtherealERP.domain.enums.SleepTypeEnum;
import leoguedex.com.github.EtherealERP.domain.enums.TypeDaysEnum;
import leoguedex.com.github.EtherealERP.domain.enums.TypeOfWeightEnum;
import leoguedex.com.github.EtherealERP.domain.enums.TypePersonEnum;
import leoguedex.com.github.EtherealERP.service.RandomGenerateColors;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CustomerController customerController;

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
        model.addAttribute("TypeDaysValues", TypeDaysEnum.values());
        model.addAttribute("HealthGoalsValues", HealthGoalsEnum.values());

        List<String> customerRotineTableValues = Stream.of(CustomerRotineTable.class.getDeclaredFields())
                .filter(field -> !Arrays.asList("customer", "id").contains(field.getName()))
                .map(field -> field.getName())
                .toList();

        model.addAttribute("CustomerRotineTableValues", customerRotineTableValues);

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
