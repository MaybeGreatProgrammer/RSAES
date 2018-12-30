package com.luszczyk.RSAES;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.*;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;

public class keyController extends RSAESController{
    public Label privLabel;
    public TextArea rsaPrivText;
    public TextArea rsaPubText;
    public Label pubLabel;
    public TextArea aesText;

    private PrivateKey privateKey;
    private PublicKey publicKey;
    private SecretKey secretKey;

    public void initialize() {
        super.initialize();
        privLabel.getStyleClass().add("small-label");
        pubLabel.getStyleClass().add("small-label");
        if(globals.getKeyScene()==null) globals.setKeyScene(hBox.getScene());
        if(globals.getKeyController()==null) globals.setKeyController(this);
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

    void setData(Globals globals) {
        this.globals = globals;
        this.privateKey = globals.getPrivateKey();
        this.publicKey = globals.getPublicKey();
        this.secretKey = globals.getSecretKey();
        if(privateKey!=null)rsaPrivText.setText(MSGEncrypt.keyToString(privateKey));
        if(publicKey!=null)rsaPubText.setText(MSGEncrypt.keyToString(publicKey));
        if(secretKey!=null)aesText.setText(MSGEncrypt.keyToString(secretKey));
    }
}
