package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.Topic;
import f105854.ready_for_nvo_math.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> findAll() {
        List<Topic> topics = topicRepository.findAll();
        return topics;
    }

    public void addTopic(@ModelAttribute Topic topic) {
        topicRepository.save(topic);
    }

    public Topic findTopicById(@PathVariable("id") int id) {
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid topic ID: " + id));
        return topic;
    }

    public void updateTopic(@ModelAttribute Topic topic) throws Exception {
        Topic topicInDB = topicRepository.findById(topic.getId()).orElse(null);
        if (topicInDB != null) {
            topicInDB.setTopicName(topic.getTopicName());
            topicInDB.setDescription(topic.getDescription());
            topicInDB.setTopic_class(topic.getTopic_class());
            topicRepository.save(topicInDB);
        } else {
            throw new Exception("Topic not found!");
        }
    }


    public void deleteTopic(@PathVariable("id") int id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid topic ID: " + id));
        topicRepository.delete(topic);
    }
}
