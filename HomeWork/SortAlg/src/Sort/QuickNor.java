package Sort;

import java.util.Arrays;
import java.util.Stack;

/**
 *@ClassName: QuickNor
 *@Description 快排非递归
 *@Author PandaChan1
 *@Date 2020/11/13
 *@Time 11:06
 */


public class QuickNor {
    //用栈
    public static void quickSortNor(int[] array,int low,int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(high);
        stack.push(low);
        while(!stack.isEmpty()) {
            int start = stack.pop();
            int end = stack.pop();
            if(start >= end) {
                continue;
            }
            int pov = partition(array,start,end);
            stack.push(end);
            stack.push(pov + 1);

            stack.push(pov - 1);
            stack.push(start);
        }
        System.out.println(Arrays.toString(array));
    }

    private static int partition(int[] array, int start, int end) {
        int temp = array[start];
        while(start < end) {
            while(start < end && array[end] >= temp) {end--;}
            array[start] = array[end];
            while(start < end && array[start] <= temp) {start++;}
            array[end] = array[start];
        }
        array[start] = temp;
        return start;
    }

}
