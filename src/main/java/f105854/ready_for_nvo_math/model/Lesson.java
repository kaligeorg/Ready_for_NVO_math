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

    @OneToMany(mappedBy = "lessonsContent", cascade =  CascadeType.ALL)
    List<LessonContent> content;


    @OneToMany(mappedBy = "tasksLesson", cascade = CascadeType.ALL)
    List<Task> ListOfTasksInLesson;

    public Lesson() {
    }

    public Lesson(int id, String title, Topic lessonsTopic, List<LessonContent> content, List<String> image,
                  List<Task> listOfTasksInLesson) {
        this.id = id;
        this.title = title;
        this.lessonsTopic = lessonsTopic;
        this.content = content;
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

    public List<LessonContent> getContent() {
        return content;
    }

    public void setContent(List<LessonContent> content) {
        this.content = content;
    }

    public List<Task> getListOfTasksInLesson() {
        return ListOfTasksInLesson;
    }

    public void setListOfTasksInLesson(List<Task> listOfTasksInLesson) {
        ListOfTasksInLesson = listOfTasksInLesson;
    }
}
