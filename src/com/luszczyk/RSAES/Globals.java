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
    private Scene signScene;
    private Scene verifyScene;
    private keyController keyController;
    private rsaController rsaController;
    private aesController aesController;
    private signatureController signatureController;
    private verifyController verifyController;

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

    void setSignScene(Scene signScene) {
        this.signScene = signScene;
    }

    void setVerifyScene(Scene verifyScene) {
        this.verifyScene = verifyScene;
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

    Scene getSignScene() {
        return signScene;
    }

    Scene getVerifyScene() {
        return verifyScene;
    }

    void setKeyController(keyController keyController) {
        this.keyController = keyController;
    }

    void setRsaController(rsaController rsaController) {
        this.rsaController = rsaController;
    }

    void setAesController(aesController aesController) {
        this.aesController = aesController;
    }

    void setSignatureController(signatureController signatureController) {
        this.signatureController = signatureController;
    }

    void setVerifyController(verifyController verifyController) {
        this.verifyController = verifyController;
    }

    aesController getAesController() {
        return aesController;
    }

    keyController getKeyController() {
        return keyController;
    }

    rsaController getRsaController() {
        return rsaController;
    }

    signatureController getSignatureController() {
        return signatureController;
    }

    verifyController getVerifyController() {
        return verifyController;
    }
}
