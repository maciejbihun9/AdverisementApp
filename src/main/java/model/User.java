package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciek on 2016-11-12.
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "userId")
    private List<UserInput> userInputs;

    /*@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_page", joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="pageId"))
    private List<AdvertiserPage> advertiserPages;*/

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "USER_PAGE",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PAGE_ID", referencedColumnName = "PAGE_ID"))
    private List<AdvertiserPage> advertiserPages;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_recomendation", joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="recomendationId"))
    private List<Recomendation> recomendations;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(){}

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserInput> getUserInputs() {
        if(userInputs == null){
            userInputs = new ArrayList<UserInput>();
        }
        return userInputs;
    }

    public void setUserInputs(List<UserInput> userInputs) {
        this.userInputs = userInputs;
    }

    public List<AdvertiserPage> getAdvertiserPages() {
        return advertiserPages;
    }

    public void setAdvertiserPages(List<AdvertiserPage> advertiserPages) {
        this.advertiserPages = advertiserPages;
    }

    public List<Recomendation> getRecomendations() {
        return recomendations;
    }

    public void setRecomendations(List<Recomendation> recomendations) {
        this.recomendations = recomendations;
    }
}
