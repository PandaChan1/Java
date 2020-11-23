package day11_22;

/**
 *@ClassName: searchTopK
 *@Description 寻找第k大，使用快速排序的思想
 *@Author PandaChan1
 *@Date 2020/11/23
 *@Time 16:05
 */


public class searchTopK {
    public static void main(String[] args) {
        System.out.println(findKth(new int[]{1,3,5,2,2},5,3));
    }
    public static int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a,0,n - 1);//排序
        return a[K - 1];
    }

    public static void quickSort(int[] array,int left,int right) {
        if(left < right) {
            int pov = partition(array,left,right);
            quickSort(array,left,pov - 1);
            quickSort(array,pov + 1,right);
        }else {
            return;
        }
    }

    public static int partition(int[] array,int left,int right) {
        int temp = array[left];
        while(left < right) {
            if(left < right && array[right] <= temp) {
                right--;
            }
            array[left] = array[right];
            if(left < right && array[left] >= temp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }
}
