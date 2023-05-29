package f105854.ready_for_nvo_math.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = true)
    User user;

    @OneToMany(mappedBy = "relatedAdmin", cascade = CascadeType.ALL)
    List<Message> messages;

    public Admin() {
    }

    public Admin(int id, User user, List<Message> messages) {
        this.id = id;
        this.user = user;
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
