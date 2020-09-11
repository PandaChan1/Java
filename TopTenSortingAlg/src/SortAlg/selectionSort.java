package SortAlg;

public class selectionSort {
    public static int[] selectionSort(int[] array){
        if (array.length==0){
            return array;
        }
        for (int i=0;i<array.length;i++){
            int minindex=i;
            for (int j=i;j<array.length;j++) {
                if (array[j] < array[minindex]) { //找到最小的数
                    minindex = j; //将最小数的索引保存
                }
                }
                //交换
                int temp=array[minindex];
                array[minindex]=array[i];
                array[i]=temp;
        }
        return array;
    }
}
