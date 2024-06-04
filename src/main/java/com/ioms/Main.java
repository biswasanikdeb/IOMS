package com.ioms;

import com.gui.*;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("bullshit");
        Scene scene = new Scene(label , 400, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("bullshit!!!!");
        primaryStage.show();
        
        
    }
    public static void main(String[] args) {
       
        launch(args);
        // LoginPage obj1 = new LoginPage();
        
        // obj1.setVisible(true);
    }
}