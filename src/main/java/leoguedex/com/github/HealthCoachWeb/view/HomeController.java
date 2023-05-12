package leoguedex.com.github.HealthCoachWeb.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

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

    @GetMapping("/data")
    public String table() {
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
