package f105854.ready_for_nvo_math.model;


import javax.persistence.*;
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

    @OneToMany(mappedBy = "lessonsContent", cascade =  CascadeType.ALL)
    List<LessonContent> lessonContents;


    @OneToMany(mappedBy = "tasksLesson", cascade = CascadeType.ALL)
    List<Task> listOfTasksInLesson;

    public Lesson() {
    }

    public Lesson(int id, String title, Topic lessonsTopic, List<LessonContent> lessonContents, List<Task> listOfTasksInLesson) {
        this.id = id;
        this.title = title;
        this.lessonsTopic = lessonsTopic;
        this.lessonContents = lessonContents;
        this.listOfTasksInLesson = listOfTasksInLesson;
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

    public List<LessonContent> getLessonContents() {
        return lessonContents;
    }

    public void setLessonContents(List<LessonContent> lessonContents) {
        this.lessonContents = lessonContents;
    }

    public List<Task> getListOfTasksInLesson() {
        return listOfTasksInLesson;
    }

    public void setListOfTasksInLesson(List<Task> listOfTasksInLesson) {
        this.listOfTasksInLesson = listOfTasksInLesson;
    }
}
