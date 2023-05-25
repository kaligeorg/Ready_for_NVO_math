package f105854.ready_for_nvo_math.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping(path ="/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping(path = "/login")
    public String showLoginPage(){
        return "login";
    }
}

