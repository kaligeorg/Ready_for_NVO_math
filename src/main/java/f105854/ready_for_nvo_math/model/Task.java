package f105854.ready_for_nvo_math.model;

import constant.CorrectAnswer;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String condition;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    CorrectAnswer correctAnswer;
    String image;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = true)
    Topic tasksTopic;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = true)
    Lesson tasksLesson;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = true)
    Test tasksTest;
}
