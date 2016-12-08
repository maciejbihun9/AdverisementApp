package util.page_parser_utils;

import model.AdvertiserPage;
import h2repository.AdvertiserPageRepository;
import h2repository.PageContentKeyWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.AdvertiserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciek on 2016-11-23.
 */
@Component
public class PageParserEnvironment {

    @Autowired
    AdvertiserPageRepository advertiserPageRepository;

    @Autowired
    PageContentKeyWordRepository pageContentKeyWordRepository;

    @Autowired
    AdvertiserService advertiserService;

    private static final PageContentExecutor pageContentExecutor = new PageContentExecutor();

    public PageParserEnvironment(){

    }

    public void storePage(AdvertiserPage advertiserPage) throws IOException {
        Runnable parsedPageRunnable = createRunnable(advertiserPage);
        pageContentExecutor.submitTaskToExecutor(parsedPageRunnable);
    }

    private Runnable createRunnable(AdvertiserPage advertiserPage) throws IOException {
        Runnable pageParserRunnable = () -> {
            advertiserService.saveAdvertiserPageDetails(advertiserPage);
        };
        return pageParserRunnable;
    }

    private List<String> getPageContentKeyWords(String pageContent){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        return arrayList;
    }

}
