package Code;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[] array = new int[]{12,2,3,6,7,58,92,55,45,21,36};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));


        int[] sortedArr = new int[]{1,2,6,7,8,9,12,21,33,36,45,54,66};
        boolean isSorted = isSorted(sortedArr);
        System.out.println(isSorted);

        System.out.println(binarySearch(array, 21));


        int[] src = new int[]{12,2,3,6,7,58,92,55,45,21,36};
        int[] dest = new int[src.length];
        System.out.println(Arrays.toString(copyOf(src,dest)));

        System.out.println(toString(src));
    }
//判断数组是否有序
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //冒泡排序
    private static void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0;i < array.length - 1;i++) { //趟数
            boolean flag = true; //标记
            for (int j = 0;j < array.length - 1 - i;j++ ) {
                if (array[j] > array[j + 1]) {
                    flag = false; //发生交换则false
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            //每趟结束后判断该躺是否发生交换，没发生交换说明已经有序
            if (flag) {
                return;
            }
        }
    }

    //二分查找
    private static int binarySearch(int[] array,int target){
        int left = 0;
        int right = array.length -1;
        int mid = (left + right / 2);
        while(left <= right) {
            if (array[mid] > target) {
                right = mid - 1;
            }else if (array[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    private static int[] copyOf(int[] src,int[] dest) {
        //方法一,深拷贝
//        for (int i = 0; i < src.length; i++) {
//            dest[i] = src[i];
//        }

        //方法二，深拷贝
        dest = Arrays.copyOf(src, src.length);

        //方法三，深拷贝
//        System.arraycopy(src,0,dest,0,src.length);

        //方法四，浅拷贝
//        dest = src.clone();
        return dest;
    }

    private static String toString(int[] array) {
        String res = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length -1) {
                res = res + array[i] + "]";
            }else {
                res = res + array[i] + ", ";
            }
        }
        return res;
    }
}
