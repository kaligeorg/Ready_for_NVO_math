package f105854.ready_for_nvo_math.services;

import constant.Topic_Class;
import f105854.ready_for_nvo_math.model.Topic;
import f105854.ready_for_nvo_math.repository.TopicRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TopicServiceTest {
    @Autowired
    TopicService topicService;

    @Autowired
    TopicRepository topicRepository;

    @Test
    void addTopic() {
        Topic topicAdd = new Topic("Прогресии", "В този раздел ще научиш какво се нарича числова редица, как се задава една числова редица, какво представляват аритметичната и геометричната прогресии, как се задава общият член и как се намира сумата на първите n члена на всяка от тях.", Topic_Class.TENTH);
        topicService.addTopic(topicAdd);
        Assertions.assertEquals(topicService.findAll().size(), 3);
    }

    @Test
    void updateTopic() throws Exception{
        Topic topicUpdate = new Topic(2, "Прогресии", "В този раздел ще научиш какво се нарича числова редица, как се задава една числова редица, какво представляват аритметичната и геометричната прогресии, как се задава общият член и как се намира сумата на първите n члена на всяка от тях.", Topic_Class.TENTH, null, null, null);
        topicService.updateTopic(topicUpdate);
        Assertions.assertEquals("Прогресии", topicService.findTopicById(topicUpdate.getId()).getTopicName());
    }

    @Test
    void deleteTopic() throws Exception{
        Topic topic = topicRepository.save(new Topic("Прогресии", "В този раздел ще научиш какво се нарича числова редица, как се задава една числова редица, какво представляват аритметичната и геометричната прогресии, как се задава общият член и как се намира сумата на първите n члена на всяка от тях.", Topic_Class.TENTH));
        topicService.deleteTopic(topic.getId());
        Assertions.assertFalse(topicService.findAll().contains(topic));
    }
}