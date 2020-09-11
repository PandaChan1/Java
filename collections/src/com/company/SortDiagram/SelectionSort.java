package com.company.SortDiagram;

public class SelectionSort {
    public int[] selectionsort(int[] arr){
        if (arr.length==0){
            return arr;
        }
        for (int i=0;i<arr.length;i++){
            int minindex=0;
            for (int j=i;j<arr.length;j++){
                if (arr[j]<arr[minindex]){ //找到最小的数
                    minindex=j; //将最小数的索引记下
                }
            }
            int temp=arr[minindex]; //交换
            arr[minindex]=arr[i];
            arr[i]=temp;
        }

        return arr;
    }
}
