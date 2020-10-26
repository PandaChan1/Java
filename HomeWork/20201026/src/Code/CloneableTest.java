package Code;
/**
 *@ClassName: CloneableTest
 *@Description Cloneable接口使用
 *@Author PandaChan1
 *@Date 2020/10/26
 *@Time 11:29
 */

class Person implements Cloneable{
    protected String name;
    protected  int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class CloneableTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        person1.name = "chen";
        person1.age = 22;
        Person person2 = (Person) person1.clone();
        System.out.println(person1.name);
        System.out.println(person2.name);
        System.out.println("==============================");
        person2.name = "wang";
        System.out.println(person1.name);
        System.out.println(person2.name);
    }
}
