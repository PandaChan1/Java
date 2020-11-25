package day11_25;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Kitchen {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Set<String> set = new HashSet<>();

    while(sc.hasNext()) {
        set.add(sc.next());
    }
        System.out.println(set.size());
    }
}
