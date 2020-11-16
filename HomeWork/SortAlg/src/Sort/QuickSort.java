package Sort;

/**
 *@ClassName: QuickSort
 *@Description 快排
 *@Author PandaChan1
 *@Date 2020/11/13
 *@Time 10:35
 */


/**
 *最好情况：O(n*log n)
 * 最坏：O(n^2)  当序列有序时，每次都要比较
 * 平均：O(n * log n)
 * 稳定性：不稳定
 */
public class QuickSort {

    public static void insertSort2(int[] array,int left,int right) {
        for (int i = 0; i < array.length - 1; i++) {
            int cur = array[i + 1];
            int pre = i;
            while(pre >= 0 && cur < array[pre]) {
                array[pre + 1] = array[pre];
                pre--;
            }
            array[pre + 1] = cur;
        }
    }


    public static int[] quickSort(int[] array,int left,int right) {
        if(left < right) {
            //1、优化 当 low high 之间的数据个数小于某个值时  采用直接插入排序
            if (right - left + 1 < 100) {
                insertSort2(array,left,right);
                return array;
            }

            //2、三数取中法
            midOfThree(array,left,right);

            int pov = partition(array,left,right);
            quickSort(array,left,pov - 1);
            quickSort(array,pov + 1,right);
        }
        return array;
    }

    //三数取中法
    public static void midOfThree(int[] array,int left,int right) {
        int mid = (left + right) / 2 ;
        if (array[left] >= array[right]) {
        swap(array,left,right);
        }
        if (array[left] <= array[mid]) {
        swap(array,left,mid);
        }
        if (array[mid] >= array[right]) {
        swap(array,left,mid);
        }

    }
    private static  void swap(int[] array,int left,int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }



    private static int partition(int[] array, int left, int right) {
        int temp = array[left];  //以左边为基准
        while(left < right) { // 不相遇
            while (left < right && array[right] >= temp)  {right--;}
            array[left] = array[right];

            while(left < right && array[left] <= temp) {left++;}
            array[right] = array[left];

        }
        array[left] = temp;
        return left;
    }
}
