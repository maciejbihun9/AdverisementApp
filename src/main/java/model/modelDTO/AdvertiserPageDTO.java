package model.modelDTO;

import model.PageKeyWord;
import model.User;

import javax.persistence.Column;
import java.util.List;

/**
 * Created by Maciek on 2016-12-08.
 */
public class AdvertiserPageDTO {

    private Long pageId;

    private String pageName;

    private String pageUrl;

    private String adWebSiteUrl;

    private String budget;

    private String category;

    private String priceForService;

    private List<User> users;

    private List<PageKeyWordDTO> pageKeyWordsDTOs;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<PageKeyWordDTO> getPageKeyWords() {
        return pageKeyWordsDTOs;
    }

    public void setPageKeyWords(List<PageKeyWordDTO> pageKeyWordsDTOs) {
        this.pageKeyWordsDTOs = pageKeyWordsDTOs;
    }
}
