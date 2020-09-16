package SortAlg;

public class QuickSort {
    public static int[] quickSort(int[] array,int start,int end){
        if (array.length<1 || start<0 || end>=array.length || start>end) return null;
        int smallIndex=partition(array,start,end);
        if (smallIndex>start){
            quickSort(array,start,smallIndex-1);
        }
        if (smallIndex<end){
            quickSort(array,smallIndex+1,end);
        }
        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot=(int)(start+Math.random()*(end-start+1));
        int smallIndex=start-1;
        swap(array,pivot,end);
        for (int i=start;i<=end;i++){
            if (array[i]<=array[end]){
                smallIndex++;
                if (i>smallIndex){
                    swap(array,i,smallIndex);
                }
            }

        }
        return smallIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }


    public static int[] quick(int[] array,int left,int right){
        int pivot=0;
        if (left<right){
            pivot=part(array,left,right);
            quick(array,left,pivot-1);
            quick(array,pivot+1,right);
        }
        return array;
    }
    public static int part(int[] array,int left,int right){
        int key=array[left];
        while(left<right){
            while(left<right && array[right]>=key){
                right--;
            }
            array[left]=array[right];
            while(left<right&&array[left]<=key){
                left++;
            }
            array[right]=array[left];
        }
        array[left]=key;
        return left;
    }
}
