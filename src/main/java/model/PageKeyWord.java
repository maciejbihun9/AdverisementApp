package model;

import javax.persistence.*;

/**
 * Created by Maciek on 2016-11-30.
 */
@Entity
@Table(name = "PAGE_KEY_WORD")
public class PageKeyWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAGE_KEY_WORD_ID")
    private Long pagekeyWordId;

    @ManyToOne
    @JoinColumn(name = "PAGE_ID", referencedColumnName = "PAGE_ID")
    private AdvertiserPage advertiserPageId;

    @Column(name = "PAGE_KEY_WORD")
    private String pageKeyWord;

    public Long getPagekeyWordId() {
        return pagekeyWordId;
    }

    public AdvertiserPage getAdvertiserPageId() {
        return advertiserPageId;
    }

    public void setAdvertiserPageId(AdvertiserPage advertiserPageId) {
        this.advertiserPageId = advertiserPageId;
    }

    public String getPageKeyWord() {
        return pageKeyWord;
    }

    public void setPageKeyWord(String pageKeyWord) {
        this.pageKeyWord = pageKeyWord;
    }
}
