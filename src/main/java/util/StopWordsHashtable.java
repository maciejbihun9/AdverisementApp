package util;

import java.util.Hashtable;

/**
 * Created by Maciek on 2016-11-20.
 */
public class StopWordsHashtable {

    private final Hashtable<Integer, String> stopWordsHashTable;

    public StopWordsHashtable(){
        stopWordsHashTable = new Hashtable<>();
        initalizeTable();
    }

    private void initalizeTable(){
        String[] stopWordsStringArray = Vocabulary.stopWordsStringArray;
        for(String stopWord : stopWordsStringArray){
            stopWordsHashTable.put(stopWord.hashCode(), stopWord);
        }
    }

    public Hashtable getStopWordsHashTable(){
        return stopWordsHashTable;
    }
}
