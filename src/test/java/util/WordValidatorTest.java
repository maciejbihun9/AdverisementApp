package util;

import org.junit.Test;

/**
 * Created by Maciek on 2016-11-20.
 */
public class WordValidatorTest {

    @Test
    public void shouldPrintToConsoleOnlyWords(){
        String soemInput = "This is my simple input about nothing2, da12 33but for me it's great, example how it works. 123124 --;;;321";
        String[] wordsFromText = WordValidator.getWordsFromText(soemInput);
        for(String word : wordsFromText){
            System.out.println("word : " + word);
        }
    }

    @Test
    public void testStringHashCOde(){
        String string1 = "Ea";
        String string2 = "FB";

        System.out.println("Hash : " + string1.hashCode() + " "  + string2.hashCode());
    }



}
