package com.luszczyk.RSAES;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class AESController extends RSAESController{
    public Label encryptLabel;
    public TextArea decryptedText;
    public Label decryptLabel;
    public TextArea encryptedText;

    public void initialize() {
        super.initialize();
        encryptLabel.getStyleClass().add("small-label");
        decryptLabel.getStyleClass().add("small-label");
    }

    public void encrypt() {
        if(appState.getSecretKey()==null) {
            encryptedText.setText("ERROR: No AES key provided");
            return;
        }
        try {
            String eText = MSGEncrypt.AESEncrypt(decryptedText.getText(), appState.getSecretKey());
            encryptedText.setText(eText);
        } catch (Exception e) {
            encryptedText.setText("ERROR: Unable to encrypt text with AES key");
        }
    }

    public void decrypt() {
        if(appState.getSecretKey()==null) {
            decryptedText.setText("ERROR: No AES key provided");
            return;
        }
        try {
            String dText = MSGEncrypt.AESDecrypt(encryptedText.getText(), appState.getSecretKey());
            decryptedText.setText(dText);
        } catch (Exception e) {
            decryptedText.setText("ERROR: Unable to decrypt text with AES key");
        }
    }
}
