package day12_12;

public class test {
    public String str = "6";

    public static void main(String[] args) {
        test t = new test();
        t.change(t.str);
        System.out.println(t.str);
    }

    public void change(String str) {
        str = "10";
    }
}
