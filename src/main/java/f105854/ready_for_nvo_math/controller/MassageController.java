package f105854.ready_for_nvo_math.controller;

import constant.RoleType;
import f105854.ready_for_nvo_math.model.Massage;
import f105854.ready_for_nvo_math.services.MassageService;
import f105854.ready_for_nvo_math.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MassageController {
    @Autowired
    private MassageService massageService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/massages")
    public String showAllFormsPage(Model model) {
        List<Massage> massages = this.massageService.findAll();
        model.addAttribute("massages", massages);

        return "massages";
    }


    @GetMapping(path = "/unansweredForms")
    public String showUnansweredFormsPage(Model model) {
        int adminID = 0;
        if(userService.getCurrentUser().getRoleType() == RoleType.ADMIN)
            adminID = userService.getCurrentUser().getId();
        List<Massage> unansweredForms = this.massageService.getUnansweredForms(adminID);
        model.addAttribute("adminId", adminID);
        model.addAttribute("unansweredForms", unansweredForms);

        return "massages-unanswered";
    }

    @GetMapping("/massages/answer/{id}")
    public String answerMassage(Model model, @PathVariable("id") int id){
        Massage massage = massageService.findById(id);
        model.addAttribute("massage", massage);
        return "massages-answer";
    }

    @PostMapping("/massages/{id}")
    public String answerMassage(@ModelAttribute Massage massage) {
        massageService.answerMassage(massage);
        return "redirect:/unansweredForms";
    }

    @GetMapping(path = "/massages/add")
    public String showAddMassagePage(Model model) {
        model.addAttribute("massage", new Massage());

        return "massages-add";
    }

    @PostMapping(path = "/massages/add")
    public String addMassage(@ModelAttribute Massage massage) {

        massageService.addMassage(massage);

        return "redirect:/";
    }

    @GetMapping("/massages/delete/{id}")
    public String deleteMassage(@PathVariable("id") int id) {
        massageService.deleteMassage(id);
        return "redirect:/unansweredForms";
    }
}
