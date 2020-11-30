package day11_30;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class deleteNum {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();


        for(int i = 0; i < n; i++) {
            queue.offer(i);
        }

        while(queue.size() != 1 && !queue.isEmpty()) {
            int a = queue.poll();
            queue.offer(a);
            int b = queue.poll();
            queue.offer(b);
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
