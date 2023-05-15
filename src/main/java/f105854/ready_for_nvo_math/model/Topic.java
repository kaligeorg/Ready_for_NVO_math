package f105854.ready_for_nvo_math.model;

import constant.Topic_Class;
import jakarta.persistence.*;

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

}
