package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.Message;
import f105854.ready_for_nvo_math.repository.MessageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageServiceTest {
    @Autowired
    MessageService messageService;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserService userService;

    @Test
    void answerMessage() throws Exception{
        Message message = messageService.findById(1);
        message.setAnswer("Проверете си отново решението.");
        messageService.answerMessage(message);
        Assertions.assertEquals("Проверете си отново решението.", messageService.findById(message.getId()).getAnswer());
    }

    @Test
    void addMessage() {
        Message message = new Message(0, userService.findUserById(2), "Има грешка в задача 1 на урок 1.");
        messageRepository.save(message);
        Assertions.assertEquals(messageService.findAll().size(), 3);
    }

    @Test
    void deleteMessage() throws Exception{
        Message message = messageRepository.save(new Message(0, userService.findUserById(2), "Има грешка в задача 1 на урок 1."));
        messageService.deleteMessage(message.getId());
        Assertions.assertFalse(messageService.findAll().contains(message));
    }
}