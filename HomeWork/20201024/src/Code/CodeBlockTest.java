package Code;

class Student {
    private int age;

    private String name;

    public static int count = 100;
    public Student(){
        count = 123;
        System.out.println("count:"+count);
    }
    {
        this.age = 22;
        this.name = "chen";
    }

    static {
        System.out.println(count);
        count = 99;
        System.out.println("count："+count);
    }

}

public class CodeBlockTest {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(Student.count);
        {
            int x = 100;
            System.out.println("x:" + x);
        }
        int y = 99;
        System.out.println("y:" + y);
    }
}
