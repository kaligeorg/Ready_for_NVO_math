package f105854.ready_for_nvo_math.controller;

import constant.RoleType;
import f105854.ready_for_nvo_math.model.RegistrationRequest;
import f105854.ready_for_nvo_math.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(path = "/register")
    public String register(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String username
            , @RequestParam String password, @RequestParam String email, @RequestParam RoleType roleType) {
        RegistrationRequest registrationRequest = new RegistrationRequest(firstName, lastName, username, password,
                email, roleType );
        registrationService.register(registrationRequest);
        return "/register_success";
    }




    @GetMapping(path = "/register")
    public String showRegistrationPage(Model model){
        RegistrationRequest registrationRequest = new RegistrationRequest();
        model.addAttribute("registrationRequest", registrationRequest);
        return "/register";}
}
