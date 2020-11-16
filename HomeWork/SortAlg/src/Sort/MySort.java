package Sort;


import java.util.Arrays;

public class MySort {
    public static void anotherMergeSort(int[] array) {
        for(int i = 1;i < array.length;i *= 2) {
            merge(array,i);
        }
        System.out.println(Arrays.toString(array));
    }
    public static void merge(int[] array,int step) {
        int len = array.length;
        int s1 = 0;
        int e1 = s1 + step - 1;
        int s2 = e1 + 1;
        int e2 = s2 + step - 1 < len ? s2 + step - 1 : len - 1;
        int[] temp = new int[len];
        int k = 0;
        while(s2 < len) {
            while(s1 <= e1 && s2 <= e2) {
                if(array[s1] <= array[s2]) {
                    temp[k++] = array[s1++];
                }else {
                    temp[k++] = array[s2++];
                }
            }

            while(s1 <= e1) {
                temp[k++] = array[s1++];
            }

            while(s2 <= e2) {
                temp[k++] = array[s2++];
            }

            s1 = s2 + 1;
            e1 = s1 + step - 1;
            s2 = s1 + 1;
            e2 = s2 + step - 1 < len ? s2 + step - 1 : len - 1;
        }

        while(s1 < len - 1) {
            temp[k++] = array[s1++];
        }
            array = Arrays.copyOf(temp,temp.length);
    }
}
