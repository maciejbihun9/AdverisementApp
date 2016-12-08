package model;


import javax.persistence.*;

/**
 * Created by Maciek on 2016-11-12.
 */
@Entity
@Table(name = "USER_WORD")
public class UserWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_WORD_ID")
    private long userWordId;

    @ManyToOne
    @JoinColumn(name = "USER_INPUT_ID", referencedColumnName = "USER_INPUT_ID")
    private UserInput userInputId;

    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "WORD_NAME")
    private String wordName;

    @Column(name = "WORD_COUNTER")
    private String wordCounter;

    @Column(name = "LAST_USED_DATE")
    private String lastUsedDate;

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getWordCounter() {
        return wordCounter;
    }

    public void setWordCounter(String wordCounter) {
        this.wordCounter = wordCounter;
    }

    public String getLastUsedDate() {
        return lastUsedDate;
    }

    public void setLastUsedDate(String lastUsedDate) {
        this.lastUsedDate = lastUsedDate;
    }

    public long getUserWordId() {
        return userWordId;
    }

    public void setUserWordId(long userWordId) {
        this.userWordId = userWordId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public UserInput getUserInputId() {
        return userInputId;
    }

    public void setUserInputId(UserInput userInputId) {
        this.userInputId = userInputId;
    }
}
