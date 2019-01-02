package com.luszczyk.RSAES;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.security.PrivateKey;

public class signatureController extends RSAESController {

    public Label textLabel;
    public TextArea plainText;
    public Label signLabel;
    public TextArea signatureText;
    private PrivateKey privateKey;

    public void initialize() {
        super.initialize();
        textLabel.getStyleClass().add("small-label");
        signLabel.getStyleClass().add("small-label");
        if(globals.getSignScene()==null) globals.setSignScene(hBox.getScene());
        if(globals.getSignatureController()==null) globals.setSignatureController(this);
    }

    public void sign() {
        if(privateKey==null){
            signatureText.setText("ERROR: No private key provided");
            return;
        }
        try {
            String signature = MSGEncrypt.sign(plainText.getText(), privateKey);
            signatureText.setText(signature);
        } catch (Exception e) {
            signatureText.setText("ERROR: Unable to sign text with private key");
        }
    }

    void setData(Globals globals) {
        this.globals = globals;
        this.privateKey = globals.getPrivateKey();
    }
}
