package com.logicCorp.controller;

import com.logicCorp.Cropper;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
 
public class MainFormController implements Initializable {

    @FXML
    AnchorPane canvasContainer;
    @FXML
    ScrollPane sPane;
    @FXML
    Canvas imageCanvas;
    Cropper sheet;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void showLoadImageDlg(ActionEvent e) {
        sheet = new Cropper(canvasContainer, imageCanvas);
        loadImage();
    }

    @FXML
    private void saveToImages(ActionEvent e) {
        File f = (new DirectoryChooser()).showDialog(null);
        if (f != null) {
            sheet.takeSnapshot(f.getPath());
        }
    }

    private void loadImage() {
        URI file = selectFile();
        if (file != null) {
            Image img = new Image("file:" + file.getPath());
            adjustControlersToFitImageSize(img);
            drawBackgroundImage(img);
        }
    }

    private void adjustControlersToFitImageSize(Image img) {
        canvasContainer.setPrefSize(img.getWidth(), img.getHeight());
        imageCanvas.setWidth(img.getWidth());
        imageCanvas.setHeight(img.getHeight());
    }

    private void drawBackgroundImage(Image img) {
        GraphicsContext gc = imageCanvas.getGraphicsContext2D();
        gc.drawImage(img, 0, 0);
    }

    private URI selectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("choose an image");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Images", "*.png", "*.jpg", "*.gif"));
        File f = fileChooser.showOpenDialog(null);
        return ((f != null) ? f.toURI() : null);
    }
    
}
