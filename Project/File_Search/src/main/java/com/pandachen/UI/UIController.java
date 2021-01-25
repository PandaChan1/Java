package com.pandachen.UI;

import com.pandachen.Model.FileMeta;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;




public class UIController {
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

    @FXML
    public void choose(MouseEvent mouseEvent) {

    }
}
