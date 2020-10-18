package Code;

/**
 *@ClassName: Student
 *@Description 定义类的构造方法,使用构造方法创建对象
 *@Author PandaChan1
 *@Date 2020/10/18
 *@Time 18:56
 */


class Student {
    int age;
    String sex;
    String name;
    public Student() {

    }
    public Student(int age) {
        this.age = age;
    }
    public Student(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }
    public Student(int age, String sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Constructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student(18);
        Student s3 = new Student(18,"male");
        Student s4 = new Student(18,"male","chen");

        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
        System.out.println(s4.toString());
    }

}
