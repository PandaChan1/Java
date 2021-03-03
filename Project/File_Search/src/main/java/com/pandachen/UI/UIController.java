package com.pandachen.UI;

import com.pandachen.Model.FileMeta;
import com.pandachen.Service.FileService;
import com.pandachen.Task.ScanTask;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class UIController implements Initializable {
    @FXML
    public GridPane rootPane;
    @FXML
    public TextField search;
    @FXML
    public TableView<FileMeta> fileLists;
    @FXML
    public TableColumn<FileMeta,String> nameColumn;
    @FXML
    public TableColumn<FileMeta,String> pathColumn;
    @FXML
    public TableColumn<FileMeta,String> sizeColumn;
    @FXML
    public TableColumn<FileMeta,String> modifiedColumn;

    private final FileService fileService = new FileService();

    @FXML
    public void choose(MouseEvent mouseEvent) throws InterruptedException{
        DirectoryChooser chooser = new DirectoryChooser();
        //文件选择器
        //文件选择器需要传入一个window，这个window用rootPane来生成
        File root = chooser.showDialog(rootPane.getScene().getWindow());
        //如果选择了文件,返回类型是一个File;如果直接关闭跳出的窗口root就为null
        if(root == null) {
            return;
        }

        ExecutorService threadPool = new ThreadPoolExecutor(10,
                10,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        AtomicInteger counter = new AtomicInteger(0);
        CountDownLatch doneSignal = new CountDownLatch(1);

        ScanTask task = new ScanTask(root,threadPool,counter,doneSignal);

        counter.incrementAndGet();
        threadPool.execute(task);

        doneSignal.await();
        threadPool.shutdown();


//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                fileService.scan(root);
//            }
//        });
//
//        thread.start();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StringProperty stringProperty = search.textProperty();
        //StringProperty  可以绑定一些东西事件
        stringProperty.addListener((observable, oldValue, newValue) -> {
            List<FileMeta> query = fileService.query(newValue.trim());
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    fileLists.getItems().clear();
                    fileLists.getItems().addAll(query);
                    fileLists.setRowFactory(tv->{
                        TableRow<FileMeta> item = new TableRow<FileMeta>();
                        item.setOnMouseClicked(event -> {
                            if (event.getClickCount() == 2 && (!item.isEmpty())) {
                                FileMeta meta = item.getItem();
//                                System.out.println(meta);
                                //扫描结果，双击打开系统资源管理器
                                try {
                                    Desktop.getDesktop().open(new File(meta.getPath() + "\\" + meta.getName()));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    return item;
                    });
                }
            });
        });
    }
}
