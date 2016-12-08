package util;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Maciek on 2016-11-20.
 */
public class StopWordsHashSet {

    private final HashSet<Integer> stopWordsHashSet;

    public StopWordsHashSet(){
        stopWordsHashSet = new HashSet<>();
        initalizeSet(stopWordsHashSet);
    }

    public Iterator<Integer> getStopWordsIterator(){
        return stopWordsHashSet.iterator();
    }

    private void initalizeSet(HashSet<Integer> stopWordsHashSet){
        String[] stopWordsStringArray = Vocabulary.stopWordsStringArray;
        for(String stopWord : stopWordsStringArray){
            stopWordsHashSet.add(stopWord.hashCode());
        }
    }

}
