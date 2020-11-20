package Old_JDBC_Project.MavenCycle_test;

import java.util.HashMap;
import java.util.Map;

public class HashTest {
    public static String TEST_STR = "hello";
    public static final int TIMES = 200000;
    public static void StringTest() {
        String str = new String(TEST_STR);
        long start = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            str = str + "world!";
        }
        long end = System.currentTimeMillis();
        System.out.println("String字符串拼接耗时：" + (end - start)  );
    }

    public static void StringBufferTest() {
        StringBuffer sb = new StringBuffer(TEST_STR);
        long start = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            sb.append("world!");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer字符串拼接耗时:" + (end - start));

    }

    public static  void StringBuilderTest() {
        StringBuilder sb = new StringBuilder(TEST_STR);
        long satrt = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            sb.append("world!");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder字符串拼接耗时：" + (end - satrt));
    }

   /* String字符串拼接耗时：63334
    StringBuffer字符串拼接耗时:5
    StringBuilder字符串拼接耗时：5*/
    public static void main(String[] args) {
        StringTest();
        StringBufferTest();
        StringBuilderTest();
        System.out.println("dadadada");
    }


    public static void main1(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put(null,"dada");
        map.put("huhu","da2");
        map.put("dahdja","dw31");
    }
}
