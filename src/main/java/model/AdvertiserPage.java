package model;
import type.CurrentComStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ADVERTISER_PAGE")
public class AdvertiserPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAGE_ID")
    private Long pageId;

    /*@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_page", joinColumns=@JoinColumn(name="pageId"),
            inverseJoinColumns=@JoinColumn(name="userId"))
    private List<User> users;*/

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(name = "USER_PAGE",
            joinColumns = @JoinColumn(name = "PAGE_ID", referencedColumnName = "PAGE_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"))
    private List<User> users;

    @Column(name = "PAGE_NAME")
    private String pageName;

    @Column(name = "PAGE_URL")
    private String pageUrl;

    @Column(name = "AD_URL")
    private String adWebSiteUrl;

    @Column(name = "BUDGET")
    private String budget;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "PRICE_FOR_SERVICE")
    private String priceForService;

    /*@Column(name = "PAGE_KEY_WORDS", length = 1000)
    private String pageKeyWords;

    @Column(name = "PAGE_CONTENT_KEYWORDS", length = 1000)
    private String pageContentKeywords;*/

    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "advertiserPageId", fetch = FetchType.EAGER)
    private List<PageKeyWord> pageKeyWords;

    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "advertiserPageId")
    private List<PageContentKeyWord> pageContentKeyWords;

    @Enumerated(EnumType.STRING)
    private CurrentComStatus currentCommStatus;

    public Long getPageId() {
        return pageId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getAdWebSiteUrl() {
        return adWebSiteUrl;
    }

    public void setAdWebSiteUrl(String adWebSiteUrl) {
        this.adWebSiteUrl = adWebSiteUrl;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriceForService() {
        return priceForService;
    }

    public void setPriceForService(String priceForService) {
        this.priceForService = priceForService;
    }

    public CurrentComStatus getCurrentCommStatus() {
        return currentCommStatus;
    }

    public void setCurrentCommStatus(CurrentComStatus currentCommStatus) {
        this.currentCommStatus = currentCommStatus;
    }

    public List<PageKeyWord> getPageKeyWords() {
        if(pageKeyWords == null){
            pageKeyWords = new ArrayList<PageKeyWord>();
        }
        return pageKeyWords;
    }

    public void setPageKeyWords(List<PageKeyWord> pageKeyWords) {
        this.pageKeyWords = pageKeyWords;
    }

    public List<PageContentKeyWord> getPageContentKeyWords() {
        if(pageContentKeyWords == null){
            pageContentKeyWords = new ArrayList<PageContentKeyWord>();
        }
        return pageContentKeyWords;
    }

    public void setPageContentKeyWords(List<PageContentKeyWord> pageContentKeyWords) {
        this.pageContentKeyWords = pageContentKeyWords;
    }


}
