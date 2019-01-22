package com.luszczyk.RSAES;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent keyScene = FXMLLoader.load(getClass().getResource("window.fxml"));
        primaryStage.setTitle("RSAES");
        primaryStage.setResizable(false);
        Scene scene = new Scene(keyScene, 572, 650);
        AppState.getAppState().setKeyScene(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
