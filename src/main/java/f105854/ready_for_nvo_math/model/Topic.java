package f105854.ready_for_nvo_math.model;

import constant.Topic_Class;
import javax.persistence.*;
import java.util.List;

import java.util.List;

@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @Column(name = "topic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String topic;
    String description;
    Topic_Class topic_class;

    @OneToMany(mappedBy = "tasksTopic", cascade = CascadeType.ALL)
    List<Task> listOfTasksInTopic;

    @OneToMany(mappedBy = "lessonsTopic", cascade = CascadeType.ALL)
    List<Lesson> listOfLessonsInTopic;

    @OneToMany(mappedBy = "testsTopic", cascade = CascadeType.ALL)
    List<Test> listOfTestsInTopic;

    public Topic() {
    }

    public Topic(int id, String topic, String description, Topic_Class topic_class, List<Task> listOfTasksInTopic,
                 List<Lesson> listOfLessonsInTopic, List<Test> listOfTestsInTopic) {
        this.id = id;
        this.topic = topic;
        this.description = description;
        this.topic_class = topic_class;
        this.listOfTasksInTopic = listOfTasksInTopic;
        this.listOfLessonsInTopic = listOfLessonsInTopic;
        this.listOfTestsInTopic = listOfTestsInTopic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic_Class getTopic_class() {
        return topic_class;
    }

    public void setTopic_class(Topic_Class topic_class) {
        this.topic_class = topic_class;
    }

    public List<Task> getListOfTasksInTopic() {
        return listOfTasksInTopic;
    }

    public void setListOfTasksInTopic(List<Task> listOfTasksInTopic) {
        this.listOfTasksInTopic = listOfTasksInTopic;
    }

    public List<Lesson> getListOfLessonsInTopic() {
        return listOfLessonsInTopic;
    }

    public void setListOfLessonsInTopic(List<Lesson> listOfLessonsInTopic) {
        this.listOfLessonsInTopic = listOfLessonsInTopic;
    }

    public List<Test> getListOfTestsInTopic() {
        return listOfTestsInTopic;
    }

    public void setListOfTestsInTopic(List<Test> listOfTestsInTopic) {
        this.listOfTestsInTopic = listOfTestsInTopic;
    }
}
