package SortAlg;

import java.util.Arrays;

public class MergeSort {
    public static int[] Mergesort(int[] array){
        if(array.length<2) return array;
        int mid=array.length/2;
        int[] left= Arrays.copyOfRange(array,0,mid);
        int[] right= Arrays.copyOfRange(array,mid,array.length);
        return Merge(Mergesort(left),Mergesort(right));
    }

    private static int[] Merge(int[] left, int[] right) {
        int[] result=new int[left.length+right.length];
        for(int index=0,i=0,j=0;index<result.length;index++){
            if (i>=left.length){
                result[index]=right[j++];
                //i初始为0，i永远不会大于left.length，只有i=0&&left.length=0时满足条件
                //此时，左边为空，那么合并后就只剩右边，且right已经有序
                //该方法将右边有序的数组放入result
            }else if(j>=right.length){
                result[index]=left[i++];
                //同理，j永远不会大于right.length，只有相等的时候满足条件
                //此时，右边为空，则将左边有序的数组放入result；
            }else if(left[i]>right[j]){
                result[index] =right[j++];
                //当前两个条件都不满足，即left和right都不为空时
                //判断left和right的大小，将其排序添加到result数组中
            }else{
                result[index]=left[i++];
            }
        }
        return result;
    }
}
