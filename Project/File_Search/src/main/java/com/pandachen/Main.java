package com.pandachen;

import com.pandachen.Service.DBService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        URL url = Main.class.getClassLoader().getResource("ui.fxml");
if (url == null) {
throw new RuntimeException("ui.xml没有找到");
}
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        primaryStage.setTitle("本地文件搜索");
primaryStage.setWidth(1000);
primaryStage.setHeight(800);
primaryStage.setScene(scene);

primaryStage.show();

    }

    public static void main(String[] args) {
        DBService service = new DBService();
        service.init();

        launch(args);
    }
}
