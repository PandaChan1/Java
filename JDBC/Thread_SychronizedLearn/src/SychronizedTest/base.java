package SychronizedTest;

public class base {

    //同步方法
   synchronized int add() {
       return 0;
   }
   synchronized static void test() {

   }

   //同步代码块
     static  void method() {
       Object object = new Object();
       synchronized (object) {
           
       }
     }

}
