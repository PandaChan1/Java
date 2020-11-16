package GenericDemo;

import java.util.ArrayList;
import java.util.Objects;

class Bird<T> {
    private T name;
    private T address;
    private T[] elem;
    public Bird(T name,T address) {
        this.name = name;
        this.address = address;
        this.elem = (T[])new Objects[10];
    }

    public T getName() {
        return name;
    }

    public T getAddress() {
        return address;
    }

    public void setName(T name) {
        this.name = name;
    }

    public void setAddress(T address) {
        this.address = address;
    }

    public static<K> Bird<K> mesg(K name,K address){
        return new Bird<>(name,address);
    }
}

public class GenericTest {
    public static void main(String[] args) {
        ArrayList<Integer>  list = new ArrayList<>();
    }
}
