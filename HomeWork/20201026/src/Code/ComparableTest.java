package Code;

import java.util.Arrays;
/**
 *@ClassName: Student
 *@Description comparable接口使用
 *@Author PandaChan1
 *@Date 2020/10/26
 *@Time 11:30
 */


class Student implements Comparable<Student>{
    protected String name;
    protected int age;
    protected int score;
    public Student(String name,int age,int score){
        this.score =score;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    //compareTo返回值类型说明
    //如果当前对象应排在参数对象之前，返回小于0的数字
    //如果当前对象应排在参数对象之后，返回大于0的数字
    //如果当前对象和参数对象不分先后，返回0
    @Override
    public int compareTo(Student o) {
        if (this.score < o.score) {
            return -1;
        }else if(this.score > o.score) {
            return 1;
        }else {
            return 0;
        }
    }
}
public class ComparableTest {
    public static void main(String[] args) {
        Student student1 = new Student("chen",12,66);
        Student student2 = new Student("yang",22,95);
        Student student3 = new Student("wang",21,77);
        Student student4 = new Student("li",23,75);
        Student[] students = new Student[]{student1,student2,student3,student4};
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

}
