package com.luszczyk.RSAES;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class RSAESController {
    public HBox hBox;
    public GridPane gridPane;
    public Button menuKeys;
    public Button menuRSA;
    public Button menuAES;
    Globals globals;

    void initialize() {
        gridPane.setPadding(new Insets(10));
        menuKeys.getStyleClass().add("custom-menu-button");
        menuRSA.getStyleClass().add("custom-menu-button");
        menuAES.getStyleClass().add("custom-menu-button");
        if(globals==null) globals = new Globals();
    }

    public void keyScene() throws IOException {
        Stage stage = (Stage) hBox.getScene().getWindow();
        if(globals.getKeyScene()!=null){
            globals.getKeyController().setData(globals);
            stage.setScene(globals.getKeyScene());
        } else {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("window.fxml").openStream());
            keyController keyController = loader.getController();
            Scene keyScene = new Scene(root, 572, 650);
            globals.setKeyScene(keyScene);
            globals.setKeyController(keyController);
            keyController.setData(globals);
            stage.setScene(keyScene);
        }
    }

    public void rsaScene() throws IOException {
        Stage stage = (Stage) hBox.getScene().getWindow();
        if(globals.getRsaScene()!=null){
            globals.getRsaController().setData(globals);
            stage.setScene(globals.getRsaScene());
        } else {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("rsaWindow.fxml").openStream());
            rsaController rsaController = loader.getController();
            Scene rsaScene = new Scene(root, 572, 450);
            globals.setRsaScene(rsaScene);
            globals.setRsaController(rsaController);
            rsaController.setData(globals);
            stage.setScene(rsaScene);
        }
    }

    public void aesScene() throws IOException {
        Stage stage = (Stage) hBox.getScene().getWindow();
        if(globals.getAesScene()!=null){
            globals.getAesController().setData(globals);
            stage.setScene(globals.getAesScene());
        } else {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("aesWindow.fxml").openStream());
            aesController aesController = loader.getController();
            Scene aesScene = new Scene(root, 572, 450);
            globals.setAesScene(aesScene);
            globals.setAesController(aesController);
            aesController.setData(globals);
            stage.setScene(aesScene);
        }
    }
}
