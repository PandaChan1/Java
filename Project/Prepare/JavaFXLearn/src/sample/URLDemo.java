package sample;

import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        URL r1 = URLDemo.class.getResource("sample.fxml");   //clz.getResouce(URL) 从clz所在文件目录下读取
        URL r2 = URLDemo.class.getClassLoader().getResource("root.fxml");   //clz.getClassLoader().getResource(URL),从根路径读取
        System.out.println(r1);
        System.out.println(r2);
    }
}
