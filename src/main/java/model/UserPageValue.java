package model;

import javax.persistence.*;

@Entity
@Table(name = "USER_PAGE")
public class UserPageValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_PAGE_VALUE_ID")
    private Long userPageValueId;

    @ManyToOne
    @JoinColumn(name = "PAGE_ID", referencedColumnName = "PAGE_ID")
    private AdvertiserPage owningPage;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User userId;

    @Column(name = "CLICKS")
    private Long clicks;

    @Column(name = "VIEWS")
    private Long views;

    @Column(name = "PLACE_IN_USER")
    private Long placeInUser;

    @Column(name = "WORDS_MATCHED_IN_QUERY")
    private Long numberOfWordsMatched;

    public Long getUserPageValueId() {
        return userPageValueId;
    }

    public AdvertiserPage getOwningPage() {
        return owningPage;
    }

    public void setOwningPage(AdvertiserPage owningPage) {
        this.owningPage = owningPage;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getPlaceInUser() {
        return placeInUser;
    }

    public Long getNumberOfWordsMatched() {
        return numberOfWordsMatched;
    }

    public void setNumberOfWordsMatched(Long numberOfWordsMatched) {
        this.numberOfWordsMatched = numberOfWordsMatched;
    }

    public void setPlaceInUser(Long placeInUser) {
        this.placeInUser = placeInUser;
    }
}
