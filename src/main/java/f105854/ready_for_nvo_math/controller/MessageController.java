package f105854.ready_for_nvo_math.controller;

import constant.RoleType;
import f105854.ready_for_nvo_math.model.Message;
import f105854.ready_for_nvo_math.services.MessageService;
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
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/unansweredMessages")
    public String showAllFormsPage(Model model) {
        List<Message> messages = messageService.findAll();
        model.addAttribute("messages", messages);

        return "messages-unanswered";
    }

    @GetMapping(path = "/messages")
    public String showMyFormsPage(Model model) {
        int userId = userService.getCurrentUser().getId();
        List<Message> messages = messageService.findBySenderID(userId);
        model.addAttribute("messages", messages);

        return "messages-sent";
    }

    @GetMapping("/messages/answer/{id}")
    public String answerMessage(Model model, @PathVariable("id") int id){
        Message message = messageService.findById(id);
        model.addAttribute("message", message);
        return "messages-answer";
    }

    @PostMapping("/messages/answer/{id}")
    public String answerMessage(@ModelAttribute Message message) throws Exception{
        messageService.answerMessage(message);
        return "redirect:/unansweredMessages";
    }

    @GetMapping(path = "/messages/add")
    public String showAddMessagePage(Model model) {
        model.addAttribute("message", new Message());
        return "messages-add";
    }

    @PostMapping(path = "/messages/add")
    public String addMessage(@ModelAttribute Message message) {
        messageService.addMessage(message);
        return "redirect:/messages";
    }

    @GetMapping("/messages/deleteSent/{id}")
    public String deleteSentMessage(@PathVariable("id") int id) {
        messageService.deleteMessage(id);
        return "redirect:/messages";
    }

    @GetMapping("/messages/delete/{id}")
    public String deleteMessage(@PathVariable("id") int id) {
        messageService.deleteMessage(id);
        return "redirect:/unansweredMessages";
    }
}
