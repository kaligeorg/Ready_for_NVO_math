package f105854.ready_for_nvo_math.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @Column(name = "lesson_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = true)
    Topic lessonsTopic;

    String content;
    String image;
    String diagram;

    @OneToMany(mappedBy = "tasksLesson", cascade = CascadeType.ALL)
    List<Task> ListOfTasksInLesson;

    public Lesson() {
    }

    public Lesson(int id, String title, Topic lessonsTopic, String content, String image, String diagram,
                  List<Task> listOfTasksInLesson) {
        this.id = id;
        this.title = title;
        this.lessonsTopic = lessonsTopic;
        this.content = content;
        this.image = image;
        this.diagram = diagram;
        ListOfTasksInLesson = listOfTasksInLesson;
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

    public Topic getLessonsTopic() {
        return lessonsTopic;
    }

    public void setLessonsTopic(Topic lessonsTopic) {
        this.lessonsTopic = lessonsTopic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDiagram() {
        return diagram;
    }

    public void setDiagram(String diagram) {
        this.diagram = diagram;
    }

    public List<Task> getListOfTasksInLesson() {
        return ListOfTasksInLesson;
    }

    public void setListOfTasksInLesson(List<Task> listOfTasksInLesson) {
        ListOfTasksInLesson = listOfTasksInLesson;
    }
}
