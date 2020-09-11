package SortAlg;

public class InsertionSort {
    public static int[] insertionSort(int[] array){
        if (array.length==0) {
            return array;
        }
        int current;
        for (int i=0;i<array.length-1;i++){
            current=array[i+1];
            int preIndex=i;
            while(preIndex >= 0 && current<array[preIndex]){
                array[preIndex+1]=array[preIndex];
                preIndex--;
            }
            //+1 是因为while循环中最后--
            // --后不符合条件即preIndex<0,因此需要+1
            array[preIndex+1]=current;
        }
        return array;
    }
}

