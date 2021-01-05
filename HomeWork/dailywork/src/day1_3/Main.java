package day1_3;

import java.util.*;
class Student{
    public String name;
    public int score;
    public Student(String name,int score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString() {
        return name + " " + score ;
    }
}
class stuCompatorDesc implements Comparator<Student> {
    @Override
    public int compare (Student o1,Student o2) {
        return o2.score - o1.score;
    }
}
class stuCompatorASC implements Comparator<Student> {
    @Override
    public int compare (Student o1,Student o2) {
        return o1.score - o2.score;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int method = sc.nextInt();
        Student[] stus = new Student[nums];
        String[] strs = new String[nums];
        String r = sc.nextLine();
        for (int i = 0; i < nums; i++) {
                strs[i] = sc.nextLine();
        }
        for (int i = 0; i < strs.length; i++) {
            String[] split = strs[i].split(" ");
            stus[i] = new Student(split[0], Integer.parseInt(split[1]));
        }

        sc.close();

        if(method == 0) {
            Arrays.sort(stus,new stuCompatorDesc());
        }else{
            Arrays.sort(stus,new stuCompatorASC());
        }

        for(Student s : stus) {
            System.out.println(s.toString());
        }
    }
}