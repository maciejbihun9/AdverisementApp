package serviceImpl;

import model.AdvertiserPage;
import model.PageContentKeyWord;
import model.PageKeyWord;
import h2repository.AdvertiserPageRepository;
import h2repository.PageContentKeyWordRepository;
import h2repository.PageKeyWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdvertiserService;
import util.WordValidator;
import util.page_parser_utils.PageParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciek on 2016-12-01.
 */
@Service
public class AdvertiserServiceImpl implements AdvertiserService {

    @Autowired
    AdvertiserPageRepository pageRepository;

    @Autowired
    PageContentKeyWordRepository pageContentKeyWordRepository;

    @Autowired
    PageKeyWordRepository pageKeyWordRepository;

    @Override
    public AdvertiserPage saveAdvertiserPage(AdvertiserPage advertiserPage) {
        return pageRepository.save(advertiserPage);
    }

    @Override
    public AdvertiserPage getAdvertiserPageById(long pageId) {
        return pageRepository.findOne(pageId);
    }

    @Override
    public void removeAdvertiserPage(AdvertiserPage advertiserPage) {
        pageRepository.delete(advertiserPage);
    }

    @Override
    public List<AdvertiserPage> getAllAdvertiserPages() {
        return pageRepository.findAll();
    }

    @Override
    public PageContentKeyWord savePageContentKeyWord(PageContentKeyWord pageContentKeyWord) {
        return pageContentKeyWordRepository.save(pageContentKeyWord);
    }

    @Override
    public void saveAdvertiserPageDetails(AdvertiserPage advertiserPage) {
        PageParser pageParser = null;
        try {
            pageParser = new PageParser(advertiserPage.getPageUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pageTitle = pageParser.getPageTitle();

        //extract page keywords
        List<String> pageMetadataKeywords = pageParser.getPageKeywords();
        if(pageMetadataKeywords.size() == 1){
            pageMetadataKeywords = pageParser.getPageDescriptionKeywords();
        }

        String pageContentWithoutTags = pageParser.getPageContentWithoutTags();

        advertiserPage.setPageName(pageTitle);
        //advertiserPage.setPageKeyWords(pageMetadataKeywords);

        //SET PAGE CONTENT KEY WORDS
        String[] pageContentWords = WordValidator.getWordsFromText(pageContentWithoutTags);

        AdvertiserPage savedAdvertiserPage = pageRepository.save(advertiserPage);

        //save metadata keywords
        List<PageKeyWord> pageKeyWords = saveMetadataKeyWords(pageMetadataKeywords, savedAdvertiserPage);

        //save page content words
        List<PageContentKeyWord> pageContentKeyWords = saveContentKeyWords(pageContentWords, savedAdvertiserPage);

        savedAdvertiserPage.getPageKeyWords().addAll(pageKeyWords);

        savedAdvertiserPage.getPageContentKeyWords().addAll(pageContentKeyWords);
        //save content key words

        pageRepository.save(savedAdvertiserPage);
    }

    private List<PageKeyWord> saveMetadataKeyWords(List<String> pageKeywords, AdvertiserPage advertiserPage){
        List<PageKeyWord> pageKeyWords = new ArrayList<>();
        for(String word : pageKeywords){
            PageKeyWord pageKeyWord = new PageKeyWord();
            pageKeyWord.setPageKeyWord(word);
            pageKeyWord.setAdvertiserPageId(advertiserPage);
            pageKeyWordRepository.save(pageKeyWord);
            pageKeyWords.add(pageKeyWord);
        }
        return pageKeyWords;
    }

    private List<PageContentKeyWord> saveContentKeyWords(String [] pageContentWords, AdvertiserPage advertiserPage){
        List<Integer> wordHashCodes = new ArrayList<Integer>();
        List<PageContentKeyWord> pageContentKeyWords = new ArrayList<>();
        for(String word : pageContentWords){
            wordHashCodes.add(word.hashCode());
        }
        List<Integer> validatedWordHashCodes = WordValidator.removeStopWords(wordHashCodes);
        for(String keyWord : pageContentWords){
            if(validatedWordHashCodes.contains(keyWord.hashCode())) {
                PageContentKeyWord pageContentKeyWord = new PageContentKeyWord();
                pageContentKeyWord.setPageContentKeyWord(keyWord);
                pageContentKeyWord.setAdvertiserPageId(advertiserPage);
                pageContentKeyWordRepository.save(pageContentKeyWord);
                pageContentKeyWords.add(pageContentKeyWord);
            }
        }
        return pageContentKeyWords;
    }

}
