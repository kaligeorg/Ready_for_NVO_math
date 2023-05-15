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

    public Task() {
    }

    public Task(int id, String condition, String answer1, String answer2, String answer3, String answer4,
                CorrectAnswer correctAnswer, String image, Topic tasksTopic, Lesson tasksLesson, Test tasksTest) {
        this.id = id;
        this.condition = condition;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.image = image;
        this.tasksTopic = tasksTopic;
        this.tasksLesson = tasksLesson;
        this.tasksTest = tasksTest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public CorrectAnswer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(CorrectAnswer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Topic getTasksTopic() {
        return tasksTopic;
    }

    public void setTasksTopic(Topic tasksTopic) {
        this.tasksTopic = tasksTopic;
    }

    public Lesson getTasksLesson() {
        return tasksLesson;
    }

    public void setTasksLesson(Lesson tasksLesson) {
        this.tasksLesson = tasksLesson;
    }

    public Test getTasksTest() {
        return tasksTest;
    }

    public void setTasksTest(Test tasksTest) {
        this.tasksTest = tasksTest;
    }
}
