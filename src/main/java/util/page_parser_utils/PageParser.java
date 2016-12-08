package util.page_parser_utils;


import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Maciek on 2016-11-22.
 */
public class PageParser {

    private static final String CONTENT = "content";
    private static final String DESCRIPTION = "description";
    private static final String KEY_WORDS = "keywords";
    private static final String META_TAG_NAME = "meta";
    private static final String META_ATTR_NAME = "name";

    private String pageUrl;

    private Document pageDocument;

    public PageParser(String pageUrl) throws IOException {
        this.pageUrl = pageUrl;
        this.pageDocument = Jsoup.parse(getPageContent());
    }

    public String getPageContent() throws IOException {
        URL url = new URL(pageUrl);
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        String encoding = con.getContentEncoding();  // ** WRONG: should use "con.getContentType()" instead but it returns something like "text/html; charset=UTF-8" so this value must be parsed to extract the actual encoding
        encoding = encoding == null ? "UTF-8" : encoding;
        return IOUtils.toString(in, encoding);
    }

    public String getPageTitle(){
        return pageDocument.getElementsByTag("title").first().text();
    }

    public String getPageContentWithoutTags() {
        return pageDocument.body().text();
    }

    public String getAttrValueByTagNameAndAttrName(String tagName, String attrName, String attrNameValue){
        List<Element> elementsByTagName = getElementsByTagName(tagName);
        for(Element element : elementsByTagName){
            if(element.attr(attrName).equalsIgnoreCase(attrNameValue)){
                return element.attr(CONTENT);
            }
        }
        return "";
    }

    public List<String> getPageDescriptionKeywords(){
        String keyWordsString = getAttrValueByTagNameAndAttrName(META_TAG_NAME, META_ATTR_NAME, DESCRIPTION);
        //split by commas and spaces
        return new ArrayList<>(Arrays.asList(keyWordsString.split("\\s*(\\s|,|=>)\\s*")));
    }

    public List<String> getPageKeywords(){
        String keyWordsString = getAttrValueByTagNameAndAttrName(META_TAG_NAME, META_ATTR_NAME, KEY_WORDS);
        //split by commas and spaces
        return new ArrayList<>(Arrays.asList(keyWordsString.split("\\s*(\\s|,|=>)\\s*")));
    }

    private String getByTagAttr(String tag, String attr, String metaAttrName){
        Elements metadataElements = pageDocument.getElementsByTag(tag);
        return metadataElements.first().attr(attr);
    }

    private List<Element> getElementsByTagName(String tagName){
        return pageDocument.getElementsByTag(tagName);
    }

}
