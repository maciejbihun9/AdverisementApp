package util;

import org.junit.Test;

/**
 * Created by Maciek on 2016-12-04.
 */
public class TestFunctions {


    @Test
    public void testHashes(){
        String word1 = "Maciek";
        String word2 = "maciek";

        System.out.println("Maciek mały : " + word2.hashCode());
        System.out.println("Maciek duzy : " + word1.hashCode());
    }

}
