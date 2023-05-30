package f105854.ready_for_nvo_math.model;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String senderName;
    String senderEmail;
    String messageContent;
    String answer;
    boolean isAnswered;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    Admin relatedAdmin;

    public Message() {
    }

    public Message(boolean isAnswered) {
        this.isAnswered = false;
    }

    public Message(int id, String senderName, String senderEmail, String messageContent) {
        this.id = id;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.messageContent = messageContent;
    }



    public Message(int id, String senderName, String senderEmail, String messageContent, String answer,
                   boolean isAnswered, Admin relatedAdmin) {
        this.id = id;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.messageContent = messageContent;
        this.answer = answer;
        this.isAnswered = isAnswered;
        this.relatedAdmin = relatedAdmin;
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

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
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

    public Admin getRelatedAdmin() {
        return relatedAdmin;
    }

    public void setRelatedAdmin(Admin relatedAdmin) {
        this.relatedAdmin = relatedAdmin;
    }
}
