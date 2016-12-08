package service;

import model.AdvertiserPage;
import model.PageContentKeyWord;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Maciek on 2016-12-01.
 */
@Service
public interface AdvertiserService {

    AdvertiserPage saveAdvertiserPage(AdvertiserPage advertiserPage);

    AdvertiserPage getAdvertiserPageById(long pageId);

    void removeAdvertiserPage(AdvertiserPage advertiserPage);

    List<AdvertiserPage> getAllAdvertiserPages();

    PageContentKeyWord savePageContentKeyWord(PageContentKeyWord pageContentKeyWord);

    void saveAdvertiserPageDetails(AdvertiserPage advertiserPage);



}
