package Code.Work;

class A<T> {
    T value;
    public A(T value) {
        this.value = value;
    }
    public T getValue() {
        return this.value;
    }
}
public class GenericClass {
    public static void main(String[] args) {
        A<String> a = new A("hello");
        System.out.println(a.getValue());
    }
}
