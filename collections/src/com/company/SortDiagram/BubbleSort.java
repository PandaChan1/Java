package com.company.SortDiagram;

public class BubbleSort {
    public int[] bubblesort(int[] arr){
        if (arr.length==0){
            return arr;
        }
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j+1]<arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        return arr;
    }
}
