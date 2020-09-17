package SortAlg;

public class QuickSort {
    public static int[] quick(int[] array,int left,int right){
        int pivot=0;
        if (left<right){
            //找基准
            pivot=part(array,left,right);
            //递归
            quick(array,left,pivot-1);
            quick(array,pivot+1,right);
        }
        return array;
    }
    public static int part(int[] array,int left,int right){
        //设置基准为左边的元素
        int key=array[left];
        /**
         * 保证基准左边的数都大于基准，右边的数都小于基准
         */
        while(left<right){
            while(left<right && array[right]>=key){
                //右边元素大于基准，right向左移
                right--;
            }
            //否则，将小于基准的元素放到左边
            array[left]=array[right];

            while(left<right&&array[left]<=key){
                //左边的元素小于基准，left向右移
                left++;
            }
            //否则，将大于基准的元素放到右边
            array[right]=array[left];
        }
        //最后将key赋给left，此时left左边都小于array[left]，右边都大于array[left]
        array[left]=key;
        return left;
    }
}
