package com.luszczyk.RSAES;

import javafx.scene.Scene;

import javax.crypto.SecretKey;
import java.security.PrivateKey;
import java.security.PublicKey;

class Globals {
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private SecretKey secretKey;
    private Scene keyScene;
    private Scene rsaScene;
    private Scene aesScene;
    private keyController keyController;
    private rsaController rsaController;
    private aesController aesController;

    void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    PrivateKey getPrivateKey() {
        return privateKey;
    }

    PublicKey getPublicKey() {
        return publicKey;
    }

    SecretKey getSecretKey() {
        return secretKey;
    }

    void setKeyScene(Scene keyScene) {
        this.keyScene = keyScene;
    }

    void setRsaScene(Scene rsaScene) {
        this.rsaScene = rsaScene;
    }

    void setAesScene(Scene aesScene) {
        this.aesScene = aesScene;
    }

    Scene getKeyScene() {
        return keyScene;
    }

    Scene getRsaScene() {
        return rsaScene;
    }

    Scene getAesScene() {
        return aesScene;
    }

    void setKeyController(keyController keyController) {
        this.keyController = keyController;
    }

    void setRsaController(com.luszczyk.RSAES.rsaController rsaController) {
        this.rsaController = rsaController;
    }

    void setAesController(com.luszczyk.RSAES.aesController aesController) {
        this.aesController = aesController;
    }

    com.luszczyk.RSAES.aesController getAesController() {
        return aesController;
    }

    keyController getKeyController() {
        return keyController;
    }

    com.luszczyk.RSAES.rsaController getRsaController() {
        return rsaController;
    }
}
