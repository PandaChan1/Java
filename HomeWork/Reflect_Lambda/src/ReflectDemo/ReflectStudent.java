package ReflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *@ClassName: ReflectStudent
 *@Description 通过反射获取Student类中的私有方法和属性
 *@Author PandaChan1
 *@Date 2020/11/21
 *@Time 15:01
 */


public class ReflectStudent {
    public static void  reflectNewInstance() {
        //通过反射创建Student实例
        Class<?> aClass = null;
        try {
            aClass = Class.forName("ReflectDemo.Student");
            Object o = aClass.newInstance();
            Student student = (Student) o;
            System.out.println("学生对象 ：" + student);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void reflectField(){
        Class<?> aClass = null;
        try {
            aClass = Class.forName("ReflectDemo.Student");
            Field field = aClass.getDeclaredField("name");   //访问私有属性，name

            field.setAccessible(true);   //更改权限，让我们可以修改该属性

            Object o = aClass.newInstance();  //创建实例   我们的实例默认name = 小汤姆 age = 12
            Student student = (Student) o;

            field.set(student,"小红果");  //设置name属性
            String name  = (String) field.get(student);
            System.out.println("反射私有属性，并修改为 ：" + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void refleftMethod() {
        try {
            Class<?> aClass = Class.forName("ReflectDemo.Student");
            Method method = aClass.getDeclaredMethod("eat", String.class); //访问私有方法
            System.out.println("私有方法： " + method.getName());

            method.setAccessible(true);  //更改权限

            Object o = aClass.newInstance();  //创建实例
            Student student = (Student) o;

            method.invoke(student,"反射私有方法，创建实例，调用私有方法，传递参数");  //invoke调用方法

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static  void reflectConstructor() {
        try {
            Class<?> aClass = Class.forName("ReflectDemo.Student");
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class,int.class);  //私有构造方法有两个参数
            declaredConstructor.setAccessible(true);  //修改权限

            Object o = declaredConstructor.newInstance("小花", 18);  //用构造方法创建实例

            Student student = (Student) o;
            System.out.println("获得私有构造函数并创建实例：" + student);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        reflectNewInstance();
        System.out.println("==============");
        reflectConstructor();
        System.out.println("==============");
        reflectField();
        System.out.println("==============");
        refleftMethod();
    }
}
