package Code.InterfaceTest;

/**
 *@ClassName: Shape
 *@Description 接口
 *@Author PandaChan1
 *@Date 2020/10/26
 *@Time 9:52
 */

/**
 * 1、接口中的方法,一定是不能够具体实现的
 * 2、接口当中default中修饰的方法才能够有具体实现的
 * 3、接口当中的成员变量，都是public static final
 * 4、接口中的方法，都是public abstract
 * 5、如果不写默认都是
 * 6、接口不能实例化，只能实现  implemes
 * 7、接口也可以向上上转型和动态绑定
 */
interface Shape{
    void draw();
/*    default public void func(){

    }
    default  public void  func2() {

    }*/
}
class Cycle implements  Shape{

    @Override
    public void draw() {
        System.out.println("⭕");
    }
}
class Flower implements  Shape{

    @Override
    public void draw() {
        System.out.println("❀");
    }
}
public class TestDemo {
    public static void drawMap(Shape shape) {
    shape.draw();
    }

    public static void main(String[] args) {
        Shape shape1 = new Cycle();
        shape1.draw();
        drawMap(shape1);
        Shape shape2 = new Flower();
        shape2.draw();
        drawMap(shape2);
    }
}
