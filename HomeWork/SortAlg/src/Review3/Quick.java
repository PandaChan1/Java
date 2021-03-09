package Review3;

public class Quick {
    public static void quick(int[] array,int left,int right) {
        if (left < right) {
            int pov = pattern(array,left,right);
            quick(array,left,pov - 1);
            quick(array,pov + 1,right);
        }
    }

    private static int pattern(int[] array, int left, int right) {
        int key = array[left];
        while(left < right) {
            if (left < right && array[right] >= key) {right--;}
            array[left] = array[right];
            if (left < right && array[left] <= key) {left++;}
            array[right] = array[left];
        }
        array[left] = key;
        return left;
    }

}
