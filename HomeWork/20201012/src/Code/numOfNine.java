package Code;

public class numOfNine {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1;i <= 100;i++) {
          if (i/10 == 9){
              count+=1;
          }
          if (i%10 == 9){
              count+=1;
          }
        }
        System.out.println("1-100中9的个数为 "+count);
    }
}
