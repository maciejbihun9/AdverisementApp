package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER_INPUT")
public class UserInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_INPUT_ID")
    private long userInputId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User userId;

    @Column(name = "USER_INPUT_VALUE")
    private String userInputValue;

    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "userInputId")
    private List<UserWord> validatedInputWords;

    public long getUserInputId() {
        return userInputId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getUserInputValue() {
        return userInputValue;
    }

    public void setUserInputValue(String userInputValue) {
        this.userInputValue = userInputValue;
    }

    public List<UserWord> getValidatedInputWords() {
        if(validatedInputWords == null){
            validatedInputWords = new ArrayList<>();
        }
        return validatedInputWords;
    }

    public void setValidatedInputWords(List<UserWord> validatedInputWords) {
        this.validatedInputWords = validatedInputWords;
    }
}
