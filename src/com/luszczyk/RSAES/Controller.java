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

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;

public class Controller {
    public TextArea rsaPrivText;
    public TextArea rsaPubText;
    public Button menuKeys;
    public Label privLabel;
    public Label pubLabel;
    public TextArea aesText;
    public HBox hBox;
    public GridPane gridPane;
    public Button menuRSA;
    public Button menuAES;
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private SecretKey secretKey;
    private Globals globals;

    public void initialize() {
        gridPane.setPadding(new Insets(10));
        menuKeys.getStyleClass().add("custom-menu-button");
        menuRSA.getStyleClass().add("custom-menu-button");
        menuAES.getStyleClass().add("custom-menu-button");
        privLabel.getStyleClass().add("small-label");
        pubLabel.getStyleClass().add("small-label");
        if(globals==null) globals = new Globals();
        if(globals.getKeyScene()==null) globals.setKeyScene(hBox.getScene());
        if(globals.getController()==null) globals.setController(this);
    }

    public void generateRSA() {
        KeyPair originalKeyPair = MSGEncrypt.generateKeyPair();
        privateKey = originalKeyPair.getPrivate();
        globals.setPrivateKey(privateKey);
        rsaPrivText.setText(MSGEncrypt.keyToString(originalKeyPair.getPrivate()));
    }

    public void generatePub() {
        try {
            RSAPrivateCrtKey privk = (RSAPrivateCrtKey) privateKey;
            RSAPublicKeySpec publicKeySpec = new java.security.spec.RSAPublicKeySpec(privk.getModulus(), privk.getPublicExponent());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey myPublicKey = keyFactory.generatePublic(publicKeySpec);
            publicKey = myPublicKey;
            globals.setPublicKey(publicKey);
            rsaPubText.setText(MSGEncrypt.keyToString(myPublicKey));
        } catch (Exception e) {
            rsaPubText.setText("ERROR: Unable to generate public key from private key.");
        }
    }

    public void generateAES() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128); // The AES key size in number of bits
        secretKey = generator.generateKey();
        globals.setSecretKey(secretKey);
        aesText.setText(MSGEncrypt.keyToString(secretKey));
    }

    public void loadAES() {
        try {
            secretKey = MSGEncrypt.loadSecretKey(aesText.getText());
            globals.setSecretKey(secretKey);
        } catch (Exception e) {
            aesText.setText("ERROR: Invalid AES key");
        }
    }

    public void loadRSA() {
        try {
            privateKey = MSGEncrypt.loadPrivateKey(rsaPrivText.getText());
            globals.setPrivateKey(privateKey);
        } catch (Exception e){
            rsaPrivText.setText("ERROR: Invalid RSA private key");
        }
    }

    public void loadPub() {
        try {
            publicKey = MSGEncrypt.loadPublicKey(rsaPubText.getText());
            globals.setPublicKey(publicKey);
        } catch (Exception e) {
            rsaPubText.setText("ERROR: Invalid RSA public key");
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

    void setData(Globals globals) {
        this.globals = globals;
        this.privateKey = globals.getPrivateKey();
        this.publicKey = globals.getPublicKey();
        this.secretKey = globals.getSecretKey();
        if(privateKey!=null)rsaPrivText.setText(MSGEncrypt.keyToString(privateKey));
        if(publicKey!=null)rsaPubText.setText(MSGEncrypt.keyToString(publicKey));
        if(secretKey!=null)aesText.setText(MSGEncrypt.keyToString(secretKey));
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
