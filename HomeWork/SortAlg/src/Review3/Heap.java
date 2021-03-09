package Review3;

public class Heap {
    public static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(array,i,array.length);
        }
    }

    public static void adjustDown(int[] array,int parent,int len) {

    }

    public static void heap(int[] array) {

    }
}
