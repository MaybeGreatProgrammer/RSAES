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
    public Button menuSig;
    public Button menuVer;
    AppState appState = AppState.getAppState();

    void initialize() {
        gridPane.setPadding(new Insets(10));
        menuKeys.getStyleClass().add("custom-menu-button");
        menuRSA.getStyleClass().add("custom-menu-button");
        menuAES.getStyleClass().add("custom-menu-button");
        menuSig.getStyleClass().add("custom-menu-button");
        menuVer.getStyleClass().add("custom-menu-button");
    }

    public void keyScene() throws IOException {
        Stage stage = (Stage) hBox.getScene().getWindow();
        if(appState.getKeyScene()!=null){
            stage.setScene(appState.getKeyScene());
        } else {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("window.fxml").openStream());
            KeyController keyController = loader.getController();
            Scene keyScene = new Scene(root, 572, 650);
            appState.setKeyScene(keyScene);
            appState.setKeyController(keyController);
            stage.setScene(keyScene);
        }
    }

    public void rsaScene() throws IOException {
        Stage stage = (Stage) hBox.getScene().getWindow();
        if(appState.getRsaScene()!=null){
            stage.setScene(appState.getRsaScene());
        } else {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("rsaWindow.fxml").openStream());
            RSAController rsaController = loader.getController();
            Scene rsaScene = new Scene(root, 572, 450);
            appState.setRsaScene(rsaScene);
            appState.setRsaController(rsaController);
            stage.setScene(rsaScene);
        }
    }

    public void aesScene() throws IOException {
        Stage stage = (Stage) hBox.getScene().getWindow();
        if(appState.getAesScene()!=null){
            stage.setScene(appState.getAesScene());
        } else {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("aesWindow.fxml").openStream());
            AESController aesController = loader.getController();
            Scene aesScene = new Scene(root, 572, 450);
            appState.setAesScene(aesScene);
            appState.setAesController(aesController);
            stage.setScene(aesScene);
        }
    }

    public void signScene() throws IOException{
        Stage stage = (Stage) hBox.getScene().getWindow();
        if(appState.getSignScene()!=null){
            stage.setScene(appState.getSignScene());
        } else {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("signatureWindow.fxml").openStream());
            SignatureController signatureController = loader.getController();
            Scene signatureScene = new Scene(root, 572, 425);
            appState.setSignScene(signatureScene);
            appState.setSignatureController(signatureController);
            stage.setScene(signatureScene);
        }
    }

    public void verifyScene() throws IOException{
        Stage stage = (Stage) hBox.getScene().getWindow();
        if(appState.getVerifyScene()!=null){
            stage.setScene(appState.getVerifyScene());
        } else {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("verifyWindow.fxml").openStream());
            VerifyController verifyController = loader.getController();
            Scene verifyScene = new Scene(root, 572, 425);
            appState.setVerifyScene(verifyScene);
            appState.setVerifyController(verifyController);
            stage.setScene(verifyScene);
        }
    }
}
