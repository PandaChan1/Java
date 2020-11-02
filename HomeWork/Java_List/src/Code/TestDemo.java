package Code;

import java.util.*;

class Student {
    protected  String name;
    protected  String grade;
    protected  double score;
    public Student(){}
    public Student(String stu_name,String stu_grade,double stu_score){
        this.name = stu_name;
        this.grade = stu_grade;
        this.score = stu_score;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("小王","大二",65.5));
        list.add(new Student("小李","大三",98.0));
        list.add(new Student("小马","大一",88));


        for (Student s :
                list) {
            System.out.println(s.name + " " + s.grade + " " + s.score);
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(33);
        list1.add(21);
        list1.add(10);
        list1.add(78);
        list1.add(1);
        Collections.sort(list1);
        System.out.println(list1);

        change("welcome to bit", "come");
    }

    private static void change(String str1,String str2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (!str2.contains(c + "")) {
                list.add(c);
            }
        }

        for (char c :
                list) {
            System.out.print(c);
        }
    }
}
