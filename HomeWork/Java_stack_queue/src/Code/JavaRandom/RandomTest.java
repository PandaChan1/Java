package Code.JavaRandom;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
//        Random r = new Random(20);    //括号中写定值，每次运行程序产生的随机数都是一样的
        Random r = new Random();  //括号中不写定值，每次运行程序产生的数都是随机的
        for (int i = 0; i < 5; i++) {
            int ran = r.nextInt(100);  //随机数<100
            System.out.println(ran);
        }
        System.out.println("======================");
        randomNum();
        randomN();
    }

    private static void randomNum(){
        //Math.random()返回值是double，精度高，要获取int随机数需要强转
        int ran = (int) (Math.random()*(100 - 1) + 1);
        //Math.random()*max  表示生成[0,max)之间的随机数，每次都随机,左闭右开
        //Math.random()*(max - min) + min  表示生成[min,max]之间的数,每次都随机,闭区间
        System.out.println(ran);
    }

    private static void randomN(){
        long randomNum = System.currentTimeMillis();  //获取从1970-1-1 00:00:00到现在的一个long型毫秒数，取模后可得到所需范围的随机数
        int ran = (int)(randomNum%(100 - 1) + 1);
        System.out.println(ran);
    }
}
