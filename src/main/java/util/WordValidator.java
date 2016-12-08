package util;

import java.util.*;

/**
 * Created by Maciek on 2016-11-11.
 */
public class WordValidator {

    /**
     *
     * @param userInput
     * @return words from user input string that are not numbers.
     */
    public static String [] getWordsFromText(String userInput){
        String withoutDigits = removeNotCharacters(userInput);
        return withoutDigits.split(" +");
    }

    public static List<Integer> removeStopWords(List <Integer> wordsHashesList){
        List<Integer> wordsToRemove = new ArrayList<Integer>();
        StopWordsHashtable stopWordsHashtable = new StopWordsHashtable();
        Hashtable stopWordsHashes = stopWordsHashtable.getStopWordsHashTable();
        for(Integer wordHash : wordsHashesList){
            if(stopWordsHashes.get(wordHash) != null)
                wordsToRemove.add(wordHash);
        }
        wordsHashesList.removeAll(wordsToRemove);
        return wordsHashesList;
    }

    public static List<Integer> removeAllAdverbs(){
        return new ArrayList<Integer>();
    }

    private static String removeNotCharacters(String userInput){
        return userInput.replaceAll("[^a-zA-Z ]", "").toLowerCase();
    }

}
