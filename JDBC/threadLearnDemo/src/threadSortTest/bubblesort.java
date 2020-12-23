package threadSortTest;

import java.util.Random;

public class bubblesort {
    public static void bubblesort(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[i] > array[j]) {
                    long temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static long[] createRandomArray(int n) {
        final Random random = new Random(20201223);
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(2 * n);
        }
        return array;
    }

    public static void sigleThreadSort(){
        long[] a1 = createRandomArray(50_000);
        long[] a2 = createRandomArray(50_000);
        long[] a3 = createRandomArray(50_000);
        long[] a4 = createRandomArray(50_000);
        long[] a5 = createRandomArray(50_000);

        long s = System.currentTimeMillis();
        bubblesort(a1);
        bubblesort(a2);
        bubblesort(a3);
        bubblesort(a4);
        bubblesort(a5);
        long e = System.currentTimeMillis();

        double second = (e - s) / 1000.0;

        System.out.println("花费" + second);
    }

    public static void multiThreadSort() throws InterruptedException {
        long[] a1 = createRandomArray(50_000);
        long[] a2 = createRandomArray(50_000);
        long[] a3 = createRandomArray(50_000);
        long[] a4 = createRandomArray(50_000);
        long[] a5 = createRandomArray(50_000);


        long s = System.currentTimeMillis();
        Thread t1 = new sortThread(a1);
        Thread t2 = new sortThread(a2);
        Thread t3 = new sortThread(a3);
        Thread t4 = new sortThread(a4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        bubblesort(a5);

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long e = System.currentTimeMillis();

        double second = (e - s) / 1000.0;

        System.out.println("花费" + second);
    }

    private static class sortThread extends Thread {
        long[] array;
        public sortThread(long[] a) {
            this.array = a;
        }

        @Override
        public void run() {
            bubblesort(array);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        sigleThreadSort();
//        multiThreadSort();
    }
}
