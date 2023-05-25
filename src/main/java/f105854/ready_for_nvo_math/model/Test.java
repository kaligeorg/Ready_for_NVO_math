package f105854.ready_for_nvo_math.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tests")
public class Test {
    @Id
    @Column(name = "test_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = true)
    Topic testsTopic;

    @OneToMany(mappedBy = "tasksTest", cascade = CascadeType.ALL)
    List<Task> listOfTasksInTest;

    public Test() {
    }

    public Test(int id, String title, Topic topic, List<Task> tasks) {
        this.id = id;
        this.title = title;
        this.testsTopic = topic;
        this.listOfTasksInTest = tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Topic getTopic() {
        return testsTopic;
    }

    public void setTopic(Topic topic) {
        this.testsTopic = topic;
    }

    public List<Task> getTasks() {
        return listOfTasksInTest;
    }

    public void setTasks(List<Task> tasks) {
        this.listOfTasksInTest = tasks;
    }
}
