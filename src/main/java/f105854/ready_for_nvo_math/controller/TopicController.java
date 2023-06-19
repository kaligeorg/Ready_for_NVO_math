package f105854.ready_for_nvo_math.controller;

import f105854.ready_for_nvo_math.model.Topic;
import f105854.ready_for_nvo_math.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping(path = "/topics")
    public String showTopicsPage(Model model) {
        List<Topic> topics = topicService.findAll();
        model.addAttribute("topics", topics);
        return "topics";
    }

    @GetMapping(path = "/topics/view")
    public String showTopicsForStudentsPage(Model model) {
        List<Topic> topics = topicService.findAll();
        model.addAttribute("topics", topics);
        return "topics-view";
    }

    @GetMapping(path = "/topics/add")
    public String showAddTopicPage(Model model) {
        model.addAttribute("topic", new Topic());
        return "topics-add";
    }

    @PostMapping(path = "/topics/add")
    public String addTopic(@ModelAttribute Topic topic) {
        topicService.addTopic(topic);
        return "redirect:/topics";
    }

    @GetMapping("/topics/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Topic topic = topicService.findTopicById(id);
        model.addAttribute("topic", topic);
        return "topics-edit";
    }

    @PostMapping("/topics/edit/{id}")
    public String updateTopic(@ModelAttribute Topic topic) throws Exception {
        topicService.updateTopic(topic);
        return "redirect:/topics";
    }

    @GetMapping("/topics/delete/{id}")
    public String deleteTopic(@PathVariable("id") int id) {
        topicService.deleteTopic(id);
        return "redirect:/topics";
    }
}
