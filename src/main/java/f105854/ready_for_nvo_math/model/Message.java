package f105854.ready_for_nvo_math.model;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "messageList")
    User sender;

    String messageContent;
    String answer;
    boolean isAnswered;

    public Message() {
    }

    public Message(boolean isAnswered) {
        this.isAnswered = false;
    }

    public Message(int id, User sender, String messageContent) {
        this.id = id;
        this.sender = sender;
        this.messageContent = messageContent;
    }

    public Message(int id, User sender, String messageContent, String answer,
                   boolean isAnswered) {
        this.id = id;
        this.sender = sender;
        this.messageContent = messageContent;
        this.answer = answer;
        this.isAnswered = isAnswered;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
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

}
