package Testing;

import Alg.greedyAlg;
import org.junit.Assert;
import org.junit.Test;
import myData.Data;

public class AlgTest {
    @Test
    public void testMethod(){
        int[] result= greedyAlg.greedy(Data.start,Data.end);
        for (int i:result){
            if (i!=0)
                System.out.print(i+" ");
        }
    }
}
