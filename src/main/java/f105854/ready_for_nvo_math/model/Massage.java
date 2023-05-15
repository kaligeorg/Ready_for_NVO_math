package f105854.ready_for_nvo_math.model;

import jakarta.persistence.*;

@Entity
@Table(name = "massages")
public class Massage {
    @Id
    @Column(name = "massage_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String senderName;
    String senderEmail;
    String massage;
    String answer;
    boolean isAnswered;

    public Massage() {
    }

    public Massage(boolean isAnswered) {
        this.isAnswered = false;
    }

    public Massage(int id, String senderName, String senderEmail, String massage) {
        this.id = id;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.massage = massage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }
}
