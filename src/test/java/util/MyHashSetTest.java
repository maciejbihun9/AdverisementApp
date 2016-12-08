package util;

import org.junit.Test;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by Maciek on 2016-11-20.
 */
public class MyHashSetTest {


    /*@Test
    public void myHashSetTest(){
        String userINput = "This is just simple user input";
        HashSet<String> setOfWords = MyHashtable.createHashSet(userINput.split(" +"));

        while(setOfWords.iterator().hasNext()){
            String word = setOfWords.iterator().next();
            System.out.println("Word : " + word);
        }

    }*/

   /* @Test
    public void createHashtable(){
        Hashtable<Integer, String> hashedWords = new Hashtable<>();
        for(String word : Vocabulary.stopWordsStringArray){
            hashedWords.put(word.hashCode(), word);
        }

    }*/

    @Test
    public void createhashtableString(){
        Hashtable<Integer, String> hashedWords = new Hashtable<>();
        String output = "{";
        for(String word : Vocabulary.stopWordsStringArray){
            output += word.hashCode();
            output += ", ";
        }
        output += "}";
        System.out.println(output);

        System.out.println("according hash : " + "according".hashCode());
    }

}
