package inner;

/**
 *@ClassName: InnerClass
 *@Description 内部类
 *@Author PandaChan1
 *@Date 2020/11/16
 *@Time 10:52
 */

/**
 * 内部类：
 * 1、实例内部类
 * 2、静态内部类
 * 3、匿名内部类
 * 4、本地内部类
 */

class outerClass{
    public  int data1 = 99;
    public  int data2 = 100;
    public static int data3;

    /**
     *    1、拿到实例内部类的方式
     *     outerClass.innerclass innerclass = outer.new innerclass();
     *    2、不能在实例内部类中定义静态成员变量 ---- 实例内部类相当于外部类的一个实例成员，需要外部类对象的引用来使用，而静态成员变量不依赖于对象。
     *    3、面试：实例内部类是否有额外的开销  有
     *    outerClass.this
     *    4、this --> 是静态的
     *    5、内部类产生的字节码文件  外部类命$内部类名.class
     */
    //实例内部类
    class innerclass{
//        public static  int a = 5;  //错误
        public int data1 = 100;
        public int data2 = 200;
        public int data4 = 4;
        public void test() {
            System.out.println(data4);
//            System.out.println(data1);  //100
//            System.out.println(data2);  //200
            //怎么拿到99 和100呢
            System.out.println(outerClass.this.data1);
            System.out.println(outerClass.this.data2);
        }
    }

    /**
     * 1、
     */
    //静态内部类
    static class innerclass1 {
        public int data1 = 100;
        public int data2 = 200;
        public int data4 = 4;

        public void test() {
            System.out.println(data4);
            System.out.println(data1);
            System.out.println(data2);
        }

    }
}

public class InnerClass {
    public static void main(String[] args) {
        outerClass outer = new outerClass();
        //拿到实例内部类的方式
        outerClass.innerclass innerclass = outer.new innerclass();
    }


}
