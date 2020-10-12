public class leapYear {
    public static void main(String[] arga) {
        for (int i = 1000;i <=2000;i++){
            if (i%4 == 0 && i%100 !=0 || i%400 ==0){
                System.out.println(i);
            }
        }
    }
}
