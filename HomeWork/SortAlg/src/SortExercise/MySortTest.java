package SortExercise;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MySortTest {

    public static void bubbleSort(int[] array) {
        int len = array.length;
        for(int i = 0;i < len - 1;i++) {//比较趟数
            boolean flg = true;  //标记该躺是否发生交换
            for(int j = 0;j < len - 1 - i;j++) {  //每比较一次都有一个元素有序，减去i
                if(array[j] > array[j + 1]) {
                    flg = false;  //发生交换则改为false
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
            //发生交换说明还有元素无序，没有发生交换说明已经有序，可以直接退出
            if(flg) {break;}
        }
        System.out.println("冒泡");
        System.out.println(Arrays.toString(array));
    }

    public static void selectSort(int[] array) {
        for(int i = 0;i < array.length;i++) {
            for(int j = i + 1;j < array.length;j++) {  //j从i+1开始
                if(array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        System.out.println("选择");
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array) {
        int pre = 0;
        int cur = 0;
        for(int i = 0;i < array.length - 1;i++) {
            cur = array[i + 1];  //默认前一个有序，取后一个
            pre = i;  //记住前一个下标
            while(pre >= 0 && cur < array[pre]) {  //后一个比前一个小则交换
                array[pre + 1] = array[pre];  //交换
                pre--;
            }
            //此时pre < 0，pre + 1位置赋值
            array[pre + 1] = cur;
        }
        System.out.println("插入");
        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] array){
        int gap = array.length / 2;
        while(gap > 0) {
            for(int i = gap;i < array.length - 1;i++) {
                int cur = array[i];
                int pre = i - gap;
                while(pre >= 0 && cur < array[pre]) {
                    array[pre + gap] = array[pre];
                    pre -= gap;
                }
                array[pre + gap] = cur;
            }
            gap /=2;
        }
        System.out.println("希尔");
        System.out.println(Arrays.toString(array));
    }


    public static int[] quickSort(int[] array,int left,int right) {
        if(left < right) {
            int pov = partition(array,left,right);
            quickSort(array,left,pov - 1);
            quickSort(array,pov + 1,right);
        }
        return array;
    }

    public static int partition(int[] array,int left,int right) {
        int key = array[left];
        while(left < right) {
            if(left < right && array[right] >= key) {right--;}
            array[left] = array[right];
            if(left < right && array[left] <= key) {left++;}
            array[right] = array[left];
        }
        array[left] = key;
        return left;

    }


    public static void adjustDown(int[] array,int parent,int len) {
        int child = parent * 2 + 1;
        while(child < len) {
            if(child + 1 < len && array[child + 1] > array[child]) {
                child++;
            }
            if(array[parent] < array[child]) {
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;

                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }

    public static void createHeap(int[] array) {
        for(int i = (array.length - 1 - 1) / 2;i >= 0;i--) {
            adjustDown(array,i,array.length);
        }
    }

    public static void HeapSort(int[] array) {
        createHeap(array);

        int len = array.length - 1;
        while(len > 0) {
                int temp = array[0];
                array[0] = array[len];
                array[len] = temp;
                adjustDown(array,0,len);
                len--;
        }
        System.out.println("堆排");
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,1,2,5,7,4,8,6,3,5};
        bubbleSort(array);
        selectSort(array);
        insertSort(array);
        shellSort(array);
        System.out.println("快排");
        System.out.println(Arrays.toString(quickSort(array, 0, array.length - 1)));
        HeapSort(array);
    }
}
