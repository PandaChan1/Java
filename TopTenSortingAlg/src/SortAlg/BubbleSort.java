package SortAlg;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BubbleSort {
public static int[] BubbleSort(int[] array){
    if (array.length==0) {
        return array;
    }
    for (int i=0;i<array.length;i++){
        for (int j=0;j<array.length-1-i;j++){
            if (array[j+1]<array[j]){
                int temp=array[j+1];
                array[j+1]=array[j];
                array[j]=temp;
            }
        }
    }
    return array;
}
}







