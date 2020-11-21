package ReflectDemo;
class Student{
    private String name = "小汤姆";
    public int age = 12;
    public Student() {
        System.out.println("无参构造方法");
    }
    private Student(String name) {
        this.name = name;
    }
    public Student(int age) {
        this.age = age;
    }

    private Student(String name,int age) {
        this.name = name;
        this.age = age;
    }
    private void eat(String  name) {
        System.out.println(name + "eating");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Class<?> aClass = null;
        //Class.forName()
        try {
            aClass = Class.forName("ReflectDemo.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //.class
        Class<Student> studentClass = Student.class;
        //getClass()
        Student student = new Student();
        Class<? extends Student> studentClass1 = student.getClass();

        //三种方式获得的都是同一个Student对象
        System.out.println(studentClass == studentClass1);  //true
        System.out.println(aClass == studentClass);  //true
        System.out.println(aClass == studentClass1); //true
    }

}
