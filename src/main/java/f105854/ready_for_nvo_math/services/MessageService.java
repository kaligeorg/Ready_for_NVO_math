package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.Message;
import f105854.ready_for_nvo_math.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private AdminService adminService;

    
    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public List<Message> getUnansweredForms(@PathVariable("adminID") int adminID){
        return adminService.findAdminById(adminID).getMessages().stream().filter(f-> !f.isAnswered()).collect(Collectors.toList());
    }

    public Message findById(@PathVariable("id") int id){
        return messageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid message Id:" + id));
    }

    public void answerMessage(@ModelAttribute Message form) {
        Message message = findById(form.getId());
        message.setAnswered(true);
        message.setAnswer(form.getAnswer());
        messageRepository.save(message);
    }

    public void addMessage(@ModelAttribute Message message) {
        messageRepository.save(message);
    }

    public void deleteMessage(@PathVariable("id") int id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer form Id:" + id));
        messageRepository.delete(message);
    }
}
