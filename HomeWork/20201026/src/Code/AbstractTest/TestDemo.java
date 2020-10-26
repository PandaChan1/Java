package Code.AbstractTest;

abstract class Shape{
    public abstract void draw();
}

class Cycle extends  Shape {

    @Override
    public void draw() {
        System.out.println("Cycle");
    }
}

class Flower extends  Shape{

    @Override
    public void draw() {
        System.out.println("Flower");
    }
}

public class TestDemo {
    public static void  drawMap(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {
        drawMap(new Cycle());
        drawMap(new Flower());
    }
}
