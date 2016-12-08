package model;

import javax.persistence.*;

/**
 * Created by Maciek on 2016-11-30.
 */
@Entity
@Table(name = "PAGE_CONTENT_KEY_WORD")
public class PageContentKeyWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAGE_CONTENT_KEY_WORD_ID")
    private Long pageContentKeyWordId;

    @ManyToOne
    @JoinColumn(name = "PAGE_ID", referencedColumnName = "PAGE_ID")
    private AdvertiserPage advertiserPageId;

    @Column(name = "PAGE_CONTENT_KEY_WORD")
    private String pageContentKeyWord;

    public Long getPageContentKeyWordId() {
        return pageContentKeyWordId;
    }

    public String getPageContentKeyWord() {
        return pageContentKeyWord;
    }

    public void setPageContentKeyWord(String pageContentKeyWord) {
        this.pageContentKeyWord = pageContentKeyWord;
    }

    public AdvertiserPage getAdvertiserPageId() {
        return advertiserPageId;
    }

    public void setAdvertiserPageId(AdvertiserPage advertiserPageId) {
        this.advertiserPageId = advertiserPageId;
    }
}
