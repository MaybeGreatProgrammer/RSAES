package com.luszczyk.RSAES;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class VerifyController extends RSAESController{

    public Label textLabel;
    public TextArea plainText;
    public Label signLabel;
    public TextArea signatureText;
    public Label verResult;

    public void initialize() {
        super.initialize();
        textLabel.getStyleClass().add("small-label");
        signLabel.getStyleClass().add("small-label");
        verResult.getStyleClass().add("small-label");
    }

    public void verify() {
        if(appState.getPublicKey()==null) {
            verResult.setText("ERROR: No public key provided");
            verResult.getStyleClass().clear();
            verResult.getStyleClass().add("verify-bad");
            return;
        }
        String pText = plainText.getText();
        String sigText = signatureText.getText();
        try {
            Boolean verified = MSGEncrypt.verify(pText, sigText, appState.getPublicKey());
            if(verified){
                verResult.setText("Signature Correct");
                verResult.getStyleClass().clear();
                verResult.getStyleClass().add("verify-ok");
            } else {
                verResult.setText("Signature Incorrect");
                verResult.getStyleClass().clear();
                verResult.getStyleClass().add("verify-bad");
            }
        } catch (Exception e) {
            verResult.setText("ERROR: Unable to verify signature");
            verResult.getStyleClass().clear();
            verResult.getStyleClass().add("verify-bad");
        }
    }
}
