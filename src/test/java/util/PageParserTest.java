package util;

import org.junit.Before;
import org.junit.Test;
import util.page_parser_utils.PageParser;

import java.io.IOException;
import java.util.List;

/**
 * Created by Maciek on 2016-11-22.
 */
public class PageParserTest {

    //private String webPageUrl = "http://butysportowe.pl/";
    private String webPageUrl = "http://www.nasdaq.com/investing/start-investing-1000.stm";
    private PageParser pageParser;

    @Before
    public void initialize() throws IOException {
        pageParser = new PageParser(webPageUrl);
    }

    /*@Test
    public void getPageContentTest() throws IOException {
        System.out.println("Page content : " + pageParser.getPageContent());
    }

    @Test
    public void getPageTitle() throws IOException {
        String pageTitle = pageParser.getPageTitle();
        System.out.println("This is a page title : " + pageTitle);
    }

    @Test
    public void shouldReturnPageTextContent(){
        System.out.println("Page content without tags : " + pageParser.getPageContentWithoutTags());
    }

    @Test
    public void shouldReturnPageKeywords(){
        for(String keyword : pageParser.getPageMetadataKeywordsList()){
            System.out.println("Keyword : " + keyword);
        }
    }*/

    @Test
    public void getAttrValueByTagNameAndAttrNameTest(){
        String attrValueByTagNameAndAttrName = pageParser.getAttrValueByTagNameAndAttrName("meta", "name", "description");
        System.out.println("value from name : " + attrValueByTagNameAndAttrName);
    }

    @Test
    public void getPageKeywordsTest(){
        List<String> pageKeywords = pageParser.getPageKeywords();
        for (String keyWord : pageKeywords){
            System.out.println("page key word : " + keyWord);
        }
    }



}
