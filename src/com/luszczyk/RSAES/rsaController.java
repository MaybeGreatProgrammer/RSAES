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

import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class rsaController {
    public GridPane gridPane;
    public Button menuKeys;
    public Label encryptLabel;
    public Label decryptLabel;
    public Button menuRSA;
    public HBox hBox;
    public TextArea decryptedText;
    public TextArea encryptedText;
    public Button menuAES;

    private Globals globals;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public void initialize() {
        gridPane.setPadding(new Insets(10));
        menuKeys.getStyleClass().add("custom-menu-button");
        menuRSA.getStyleClass().add("custom-menu-button");
        menuAES.getStyleClass().add("custom-menu-button");
        encryptLabel.getStyleClass().add("small-label");
        decryptLabel.getStyleClass().add("small-label");
        if(globals==null) globals = new Globals();
        if(globals.getRsaScene()==null) globals.setRsaScene(hBox.getScene());
        if(globals.getRsaController()==null) globals.setRsaController(this);
    }

    void setData(Globals globals) {
        this.globals = globals;
        this.privateKey = globals.getPrivateKey();
        this.publicKey = globals.getPublicKey();
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

    public void encrypt() {
        if(publicKey==null) {
            encryptedText.setText("ERROR: No public key provided");
            return;
        }
        try {
            String eText = MSGEncrypt.encrypt(decryptedText.getText(), publicKey);
            encryptedText.setText(eText);
        } catch (Exception e) {
            encryptedText.setText("ERROR: Unable to encrypt text with public key");
        }
    }

    public void decrypt() {
        if(privateKey==null) {
            decryptedText.setText("ERROR: No private key provided");
            return;
        }
        try {
            String dText = MSGEncrypt.decrypt(encryptedText.getText(), privateKey);
            decryptedText.setText(dText);
        } catch (Exception e) {
            decryptedText.setText("ERROR: Unable to decrypt text with private key");
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
