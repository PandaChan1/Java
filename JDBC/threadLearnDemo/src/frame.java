public class frame {
    public static void a(){}
    public static void b(){a();}
    public static void c(){b();}

    public static void main(String[] args) {
        c();
    }
}
