package model.modelTranslator;

import model.AdvertiserPage;
import model.PageKeyWord;
import model.modelDTO.AdvertiserPageDTO;
import model.modelDTO.PageKeyWordDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciek on 2016-12-08.
 */
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class AvertiserPageTranslator {

    public AdvertiserPageDTO transateToDTO(AdvertiserPage advertiserPage){

        AdvertiserPageDTO advertiserPageDTO = new AdvertiserPageDTO();
        advertiserPageDTO.setPageId(advertiserPage.getPageId());
        advertiserPageDTO.setPageName(advertiserPage.getPageName());
        advertiserPageDTO.setPageUrl(advertiserPage.getPageUrl());
        advertiserPageDTO.setBudget(advertiserPage.getBudget());
        advertiserPageDTO.setCategory(advertiserPage.getCategory());
        List<PageKeyWordDTO> pageKeyWordDTOs = translateToDTOs(advertiserPage);
        advertiserPageDTO.setPageKeyWords(pageKeyWordDTOs);


        return advertiserPageDTO;
    }

    private List<PageKeyWordDTO> translateToDTOs(AdvertiserPage advertiserPage){
        List<PageKeyWordDTO> pageKeyWordDTOs = new ArrayList<>();
        PageKeyWordDTO pageKeyWordDTO = new PageKeyWordDTO();

        for(PageKeyWord pageKeyWord : advertiserPage.getPageKeyWords()){

            pageKeyWordDTO.setPageKeyWord(pageKeyWord.getPageKeyWord());
            pageKeyWordDTO.setPagekeyWordId(pageKeyWord.getPagekeyWordId());
            pageKeyWordDTOs.add(pageKeyWordDTO);
        }
        return pageKeyWordDTOs;
    }

}
