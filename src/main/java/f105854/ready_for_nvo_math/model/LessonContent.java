package f105854.ready_for_nvo_math.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lesson_content")
public class LessonContent {
    @Id
    @Column(name = "content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String content;
    String image;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = true)
    Lesson lessonsContent;

    public LessonContent() {
    }

    public LessonContent(int id, String content, String image, Lesson lessonsContent) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.lessonsContent = lessonsContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Lesson getLessonsContent() {
        return lessonsContent;
    }

    public void setLessonsContent(Lesson lessonsContent) {
        this.lessonsContent = lessonsContent;
    }
}
