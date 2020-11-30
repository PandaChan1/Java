package day11_30;

import java.util.*;

public class topK {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
             return o2 - o1;
            }
        });
        int[] array = new int[] {3,9,6,8,-10,7,-11,19,30,12,23};
        for (int i :
                array) {
            if (queue.size() < 5) {
                queue.offer(i);
            }else if (queue.peek() > i) {
                queue.poll();
                queue.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        Integer[] integers = queue.toArray(new Integer[5]);
        Arrays.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
