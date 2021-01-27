package com.pandachen.UI;

import com.pandachen.Model.FileMeta;
import com.pandachen.Service.FileService;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


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
    public void choose(MouseEvent mouseEvent) {
        DirectoryChooser chooser = new DirectoryChooser();
        File root = chooser.showDialog(rootPane.getScene().getWindow());

        if(root == null) {
            return;
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                fileService.scan(root);
            }
        });

        thread.start();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StringProperty stringProperty = search.textProperty();
        stringProperty.addListener((observable, oldValue, newValue) -> {
            List<FileMeta> query = fileService.query(newValue.trim());
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    fileLists.getItems().clear();
                    fileLists.getItems().addAll(query);
                }
            });
        });
    }
}