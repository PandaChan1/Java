package com.pandachen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

@SpringBootApplication
    public class Main extends Application {
        private ConfigurableApplicationContext run;
        @Override
        public void init() throws Exception {
            String[] args =  getParameters().getRaw().toArray(new String[0]);
            run = new SpringApplicationBuilder().sources(Main.class).run(args);
        }

        @Override
        public void stop() throws Exception {
            run.close();
        }

        public void start(Stage primaryStage) throws Exception {
            URL url = com.pandachen.Main.class.getClassLoader().getResource("ui.fxml");
            if (url == null) {
                throw new RuntimeException("ui.xml没有找到");
            }
//            Parent root = FXMLLoader.load(url);
            //Controller对象的创建由Spring管理创建
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(url);
            fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
                @Override
                public Object call(Class<?> param) {
                    return run.getBean(param);
                }
            });
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("本地文件搜索");
            primaryStage.setWidth(1000);
            primaryStage.setHeight(800);
            primaryStage.setScene(scene);

            primaryStage.show();

        }

        public static void main(String[] args) {
            launch(args);
        }

        @Bean
    public DataSource dataSource() throws Exception {
            SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
            String classesPath = Main.class.getProtectionDomain()
                    .getCodeSource().getLocation().getFile();
            File classesDir = new File(URLDecoder.decode(classesPath, "UTF-8"));
            String path = classesDir.getParent() + File.separator + "searcher.db";
            String url = "jdbc:sqlite://" + path;
            sqLiteDataSource.setUrl(url);

            return sqLiteDataSource;
        }
    }

