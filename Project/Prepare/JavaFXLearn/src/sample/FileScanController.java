package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;

import java.io.File;

public class FileScanController {
    @FXML
    public GridPane rootPane;
    @FXML
    public TableView<FileMeta> tableView;

    @FXML
    public void selectFile(MouseEvent mouseEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        Window window = rootPane.getScene().getWindow();
        File file = directoryChooser.showDialog(window);

        if (file == null) {
            return;
        }
        Thread thread = new Thread(() -> DeepTravl(file));

        thread.setDaemon(true);
        thread.start();
    }

    //深度优先遍历--递归--栈
    private void DeepTravl(File file) {
Platform.runLater(() ->{
    FileMeta fileMeta = new FileMeta(file);
    tableView.getItems().add(fileMeta);
});
if (!file.isDirectory()) {
    return;
}
        File[] files = file.listFiles();
if (files == null) {
    return;
}
        for (File f :
                files) {
            DeepTravl(f);
        }
    }
}
