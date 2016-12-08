package model.modelDTO;

import model.AdvertiserPage;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Maciek on 2016-12-08.
 */
public class PageKeyWordDTO {

    private Long pagekeyWordId;

    private AdvertiserPageDTO advertiserPageDTOId;

    private String pageKeyWord;

    public Long getPagekeyWordId() {
        return pagekeyWordId;
    }

    public void setPagekeyWordId(Long pagekeyWordId) {
        this.pagekeyWordId = pagekeyWordId;
    }

    public AdvertiserPageDTO getAdvertiserPageId() {
        return advertiserPageDTOId;
    }

    public void setAdvertiserPageDTOId(AdvertiserPageDTO advertiserPageDTOId) {
        this.advertiserPageDTOId = advertiserPageDTOId;
    }

    public String getPageKeyWord() {
        return pageKeyWord;
    }

    public void setPageKeyWord(String pageKeyWord) {
        this.pageKeyWord = pageKeyWord;
    }
}
