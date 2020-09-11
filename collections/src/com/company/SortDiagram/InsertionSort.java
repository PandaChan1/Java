package com.company.SortDiagram;

public class InsertionSort {
    public int[] insertionsort(int[] arr){
        if (arr.length==0){
            return arr;
        }
        int current;
        for (int i=0;i<arr.length-1;i++){
            current=arr[i+1];
            int preindex=i;
            while(preindex>=0&&current<arr[preindex]){
                arr[preindex+1]=arr[preindex];
                preindex--;
            }
            arr[preindex+1]=current;
        }
        return arr;
    }
}
