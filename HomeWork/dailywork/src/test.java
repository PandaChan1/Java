import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        int[] input = new int[]{1,3,5,7,44,2,9};
        Queue<Integer> priorityQueue = new PriorityQueue<Integer>(4,(o1,o2) -> {return o2 - o1;});
        for (int i = 0; i < input.length; i++) {
            if (priorityQueue.size() < 4) {
                priorityQueue.offer(input[i]);
            }else {
                if(priorityQueue.peek() > input[i]) {
                    priorityQueue.poll();
                    priorityQueue.offer(input[i]);
                }
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>(priorityQueue);
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1- o2;
            }
        });
        System.out.println(arrayList);
        }
    }
