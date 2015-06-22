package com.logicCorp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hakim
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));        
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }      
}
