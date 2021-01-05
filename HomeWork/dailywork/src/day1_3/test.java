package day1_3;

import java.util.Arrays;
import java.util.Comparator;

class Student1 {
    public int age;
    public String name;
    public Student1(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + age ;
    }
}

public class test {
    public static void main1(String[] args) {
        String str = "";
        System.out.println(str.length());
        System.out.println("abc".contains("ab"));
    }
    //Comparator在类外定义比较器，对类的侵入性弱
    static class stuComparator implements Comparator<Student1> {
        @Override
        public int compare (Student1 o1, Student1 o2) {
            return o2.age - o1.age;
        }
    }
    public static void main(String[] args) {
        Student1[] stus = new Student1[]{new Student1(15,"王"),new Student1(22,"李"),new Student1(18,"赵")};
        //Arrays.sort() 默认使用类提供的comparable接口中的compareTo()方法比较
        //但是也可以传入自定义的比较器，如果用户传入自定义的比较器就会优先使用自定义的比较器来比较
        //即,如果一个类要使用Arrays.sort()方法，要么该类实现comparable接口，要么给该类传入自定义的比较器
        Arrays.sort(stus,new stuComparator());  //使用自己的比较器
        System.out.println(Arrays.toString(stus));
    }
}
