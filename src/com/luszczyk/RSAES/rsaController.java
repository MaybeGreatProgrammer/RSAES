package com.luszczyk.RSAES;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.security.PrivateKey;
import java.security.PublicKey;

public class rsaController extends RSAESController{
    public Label encryptLabel;
    public Label decryptLabel;
    public TextArea decryptedText;
    public TextArea encryptedText;

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public void initialize() {
        super.initialize();
        encryptLabel.getStyleClass().add("small-label");
        decryptLabel.getStyleClass().add("small-label");
        if(globals.getRsaScene()==null) globals.setRsaScene(hBox.getScene());
        if(globals.getRsaController()==null) globals.setRsaController(this);
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

    void setData(Globals globals) {
        this.globals = globals;
        this.privateKey = globals.getPrivateKey();
        this.publicKey = globals.getPublicKey();
    }
}
