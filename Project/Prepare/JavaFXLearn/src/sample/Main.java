package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("scan.fxml"));
//        Parent root = build();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }

    private Parent build() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        TextField textField = new TextField();
        gridPane.add(textField,0,0);

        Button button = new Button();
        button.setText("click me");
        gridPane.add(button,0,1);

        Label label = new Label();
        label.setPrefWidth(200);
        label.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 5");
        gridPane.add(label,0,2);

        Controller controller = new Controller();
        controller.text = textField;
        controller.show = label;

        //lambda表达式
        button.setOnMouseClicked(event -> controller.onClick(event));


        //匿名类
   /*     button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new Controller().onClick(event);
            }
        });*/



        //---------
        // 表结构实现 用代码实现
        TableView<Student> tableView = new TableView<>();
        gridPane.add(tableView,0,3);


        //表中列的实现
        TableColumn<Student,String> id = new TableColumn<>();

        //将对象的属性与表的列对应关联起来，才会显示
        //相当于每行的对象都会执行这个代码，进行表的内容设置
        id.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                Student stu = param.getValue();
                String idStr = String.valueOf(stu.id);  //拿到当前对象的id,即此处显示的是该对象的id
                return new SimpleStringProperty(idStr);
            }
        });

        id.setText("id");
        tableView.getColumns().add(id);


        TableColumn<Student,String> name = new TableColumn<>();
        //在Student中写方法获取并封装数据,这里只需要使用lambda表达式简写
        name.setCellValueFactory(param -> param.getValue().getNameValue());
        name.setText("名字");
        tableView.getColumns().add(name);


        TableColumn<Student,String> age = new TableColumn<>();
        //不在Student中获取数据，每列都要写庞大的代码
        age.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                Student stu = param.getValue();
                String ageStr = String.valueOf(stu.age);
                return new SimpleStringProperty(ageStr);
            }
        });
        age.setText("年龄");
        tableView.getColumns().add(age);


        TableColumn<Student,String> gender = new TableColumn<>();
        gender.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                Student stu = param.getValue();
                String genderStr = stu.gender;
                return new SimpleStringProperty(genderStr);
            }
        });
        gender.setText("性别");
        tableView.getColumns().add(gender);

      controller.tableView = tableView;
        //--------

        return gridPane;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
