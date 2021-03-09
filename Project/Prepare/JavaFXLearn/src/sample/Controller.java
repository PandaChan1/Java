package sample;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import file_scan.Main;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;

import java.io.File;
import java.util.Date;
import java.util.Random;

public class Controller {
    @FXML
    public TextField text;
    @FXML
    public Label show;
    @FXML
    public GridPane rootPane;

    // thread 的所有读写操作其实都在主线程中，所以不需要考虑线程安全的问题
    private Thread thread = null;
    public TableView<Student> tableView;
    private final String[] GENDER = {"女","男"};
    private int id = 1;
    private void addStudent(String name) {

    int age = (int) (System.currentTimeMillis() % (100 - 1) + 1);  //产生[0,100]的随机数
    String gender = GENDER[(int) (System.currentTimeMillis() % (2))];  //产生[0,2)的随机数

    Student student = new Student(id++,name,age,gender);

        ObservableList<Student> items = tableView.getItems();
        items.add(student);
        //打印student验证
        System.out.println(student);
    }



    @FXML
    public void onClick(MouseEvent mouseEvent) {
        System.out.println(new Date()  + ":按钮被点击");
        String content = this.text.getText();

        addStudent(content);

        try{
            int i = Integer.parseInt(content.trim());
            // 主线程
            if (thread != null) {
                thread.interrupt();
            }

            thread = new Thread(() -> {
                long r = fib(i);    // <--- 目前在子线程中进行
                // <--- 在 UI 中，主线程的核心工作是响应事件
                // <--- 解决办法：不要把可能耗时比较久的操作，放到主线程中进行

                // 涉及 UI 修改的，最好回到主线程中进行
                // 如果多个线程同时操作 UI 界面，可能有线程安全问题
                System.out.printf("fib(%d) = %d\n", i, r);
                if (Thread.interrupted()) {
                    return;
                }

                Platform.runLater(() -> {
                    // 以事件方式通知主线程执行该操作
                    // 主线程中
                    show.setText(String.valueOf(r));
                    thread = null;
                });
            });
            thread.start();
        }catch (NumberFormatException e) {
            show.setText("请输入合法的数字");
        }
        System.out.println("用户输入了：" + content);

    }



    public long fib(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3;
        if (n == 0 || n == 1) {
            return 1;
        }

        for (int j = 2; j < n;j++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }


    private Thread file_scan;
    @FXML
    public void selectFile(MouseEvent mouseEvent) {
        DirectoryChooser dc = new DirectoryChooser();  //文件选择器
        //获取我们应用的窗口
        Window window = rootPane.getScene().getWindow();
        File file = dc.showDialog(window);//弹出文件选择框,并获取结果
        System.out.println(file);
        if (file == null) {
            return;
        }

        file_scan = new Thread(() -> Main.traverBread(file));
        //jvm退出条件，所有前台线程都退掉
        //前台界面关了，但是该线程还会运行，因为我们启动的是一个前台线程
      //  file_scan.setDaemon(true);  //将该线程设置为后台线程，当界面关闭之后，该线程也会停掉
        file_scan.start();
//        Main.traverBread(file);   运行时间是否有边界---可能运行时间过长
    }
}
