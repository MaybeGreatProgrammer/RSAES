package com.luszczyk.RSAES;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SignatureController extends RSAESController {

    public Label textLabel;
    public TextArea plainText;
    public Label signLabel;
    public TextArea signatureText;

    public void initialize() {
        super.initialize();
        textLabel.getStyleClass().add("small-label");
        signLabel.getStyleClass().add("small-label");
    }

    public void sign() {
        if(appState.getPrivateKey()==null){
            signatureText.setText("ERROR: No private key provided");
            return;
        }
        try {
            String signature = MSGEncrypt.sign(plainText.getText(), appState.getPrivateKey());
            signatureText.setText(signature);
        } catch (Exception e) {
            signatureText.setText("ERROR: Unable to sign text with private key");
        }
    }
}
