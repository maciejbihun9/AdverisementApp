package util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Maciek on 2016-11-20.
 */
public class StopWordsHashtableTest {

    @Test
    public void shouldRemoveElementFromList(){
        List<Integer> list = new ArrayList<Integer>();
        String text = "Ala got cat and she runs on the bike according";
        for(String word : text.split(" ")){
            list.add(word.hashCode());
        }
        List<Integer> filteredWords = WordValidator.removeStopWords(list);

        System.out.println("Words array size : " + filteredWords.size());

    }

}
