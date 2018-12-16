package com.luszczyk.RSAES;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.crypto.SecretKey;
import java.io.IOException;

public class aesController {
    public HBox hBox;
    public Button menuKeys;
    public Button menuRSA;
    public Button menuAES;
    public GridPane gridPane;
    public Label encryptLabel;
    public TextArea decryptedText;
    public Label decryptLabel;
    public TextArea encryptedText;

    private Globals globals;
    private SecretKey secretKey;

    public void initialize() {
        gridPane.setPadding(new Insets(10));
        menuKeys.getStyleClass().add("custom-menu-button");
        menuRSA.getStyleClass().add("custom-menu-button");
        menuAES.getStyleClass().add("custom-menu-button");
        encryptLabel.getStyleClass().add("small-label");
        decryptLabel.getStyleClass().add("small-label");
        if(globals==null) globals = new Globals();
        if(globals.getAesScene()==null) globals.setAesScene(hBox.getScene());
        if(globals.getAesScene()==null) globals.setAesController(this);
    }

    public void keyScene() throws IOException {
        Stage stage = (Stage) hBox.getScene().getWindow();
        if(globals.getKeyScene()!=null){
            globals.getController().setData(globals);
            stage.setScene(globals.getKeyScene());
        } else {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("window.fxml").openStream());
            Controller controller = loader.getController();
            Scene keyScene = new Scene(root, 572, 650);
            globals.setKeyScene(keyScene);
            globals.setController(controller);
            controller.setData(globals);
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

    public void encrypt() {
        if(secretKey==null) {
            encryptedText.setText("ERROR: No AES key provided");
            return;
        }
        try {
            String eText = MSGEncrypt.AESEncrypt(decryptedText.getText(), secretKey);
            encryptedText.setText(eText);
        } catch (Exception e) {
            encryptedText.setText("ERROR: Unable to encrypt text with AES key");
        }
    }

    public void decrypt() {
        if(secretKey==null) {
            decryptedText.setText("ERROR: No AES key provided");
            return;
        }
        try {
            String dText = MSGEncrypt.AESDecrypt(encryptedText.getText(), secretKey);
            decryptedText.setText(dText);
        } catch (Exception e) {
            decryptedText.setText("ERROR: Unable to decrypt text with AES key");
        }
    }

    void setData(Globals globals) {
        this.globals = globals;
        this.secretKey = globals.getSecretKey();
    }
}
