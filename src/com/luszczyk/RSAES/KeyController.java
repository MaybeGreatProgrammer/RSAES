package com.luszczyk.RSAES;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import javax.crypto.KeyGenerator;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;

public class KeyController extends RSAESController{
    public Label privLabel;
    public TextArea rsaPrivText;
    public TextArea rsaPubText;
    public Label pubLabel;
    public TextArea aesText;

    public void initialize() {
        super.initialize();
        privLabel.getStyleClass().add("small-label");
        pubLabel.getStyleClass().add("small-label");
    }

    public void generateRSA() {
        KeyPair originalKeyPair = MSGEncrypt.generateKeyPair();
        appState.setPrivateKey(originalKeyPair.getPrivate());
        rsaPrivText.setText(MSGEncrypt.keyToString(originalKeyPair.getPrivate()));
    }

    public void generatePub() {
        try {
            RSAPrivateCrtKey privk = (RSAPrivateCrtKey) appState.getPrivateKey();
            RSAPublicKeySpec publicKeySpec = new java.security.spec.RSAPublicKeySpec(privk.getModulus(), privk.getPublicExponent());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey myPublicKey = keyFactory.generatePublic(publicKeySpec);
            appState.setPublicKey(myPublicKey);
            rsaPubText.setText(MSGEncrypt.keyToString(myPublicKey));
        } catch (Exception e) {
            rsaPubText.setText("ERROR: Unable to generate public key from private key.");
        }
    }

    public void generateAES() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128); // The AES key size in number of bits
        appState.setSecretKey(generator.generateKey());
        aesText.setText(MSGEncrypt.keyToString(appState.getSecretKey()));
    }

    public void loadAES() {
        try {
            appState.setSecretKey(MSGEncrypt.loadSecretKey(aesText.getText()));
        } catch (Exception e) {
            aesText.setText("ERROR: Invalid AES key");
        }
    }

    public void loadRSA() {
        try {
            appState.setPrivateKey(MSGEncrypt.loadPrivateKey(rsaPrivText.getText()));
        } catch (Exception e){
            rsaPrivText.setText("ERROR: Invalid RSA private key");
        }
    }

    public void loadPub() {
        try {
            appState.setPublicKey(MSGEncrypt.loadPublicKey(rsaPubText.getText()));
        } catch (Exception e) {
            rsaPubText.setText("ERROR: Invalid RSA public key");
        }
    }
}
