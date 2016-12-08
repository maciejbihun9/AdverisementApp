package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RECOMENDATION")
public class Recomendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECOMENDATION_ID")
    private long recomendationId;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_recomendation", joinColumns=@JoinColumn(name="recomendationId"),
            inverseJoinColumns=@JoinColumn(name="userId"))
    public List<User> users;


    public long getRecomendationId() {
        return recomendationId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
