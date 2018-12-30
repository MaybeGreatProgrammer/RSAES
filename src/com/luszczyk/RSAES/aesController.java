package com.luszczyk.RSAES;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import javax.crypto.SecretKey;

public class aesController extends RSAESController{
    public Label encryptLabel;
    public TextArea decryptedText;
    public Label decryptLabel;
    public TextArea encryptedText;

    private SecretKey secretKey;

    public void initialize() {
        super.initialize();
        encryptLabel.getStyleClass().add("small-label");
        decryptLabel.getStyleClass().add("small-label");
        if(globals.getAesScene()==null) globals.setAesScene(hBox.getScene());
        if(globals.getAesScene()==null) globals.setAesController(this);
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
