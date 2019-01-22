package com.luszczyk.RSAES;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class RSAController extends RSAESController{
    public Label encryptLabel;
    public Label decryptLabel;
    public TextArea decryptedText;
    public TextArea encryptedText;

    public void initialize() {
        super.initialize();
        encryptLabel.getStyleClass().add("small-label");
        decryptLabel.getStyleClass().add("small-label");
    }

    public void encrypt() {
        if(appState.getPublicKey()==null) {
            encryptedText.setText("ERROR: No public key provided");
            return;
        }
        try {
            String eText = MSGEncrypt.encrypt(decryptedText.getText(), appState.getPublicKey());
            encryptedText.setText(eText);
        } catch (Exception e) {
            encryptedText.setText("ERROR: Unable to encrypt text with public key");
        }
    }

    public void decrypt() {
        if(appState.getPrivateKey()==null) {
            decryptedText.setText("ERROR: No private key provided");
            return;
        }
        try {
            String dText = MSGEncrypt.decrypt(encryptedText.getText(), appState.getPrivateKey());
            decryptedText.setText(dText);
        } catch (Exception e) {
            decryptedText.setText("ERROR: Unable to decrypt text with private key");
        }
    }
}
