package testing;

import offer.Find;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class find_test{
   @Test
    public void findtest(){
       int target=7;
       int[][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean result=Find.find(target,array);
        System.out.println("result =="+result);
   }

}
