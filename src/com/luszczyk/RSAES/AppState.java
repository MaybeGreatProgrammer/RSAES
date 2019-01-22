package com.luszczyk.RSAES;

import javafx.scene.Scene;

import javax.crypto.SecretKey;
import java.security.PrivateKey;
import java.security.PublicKey;

class AppState {
    private static final AppState appState = new AppState();

    private PrivateKey privateKey;
    private PublicKey publicKey;
    private SecretKey secretKey;
    private Scene keyScene;
    private Scene rsaScene;
    private Scene aesScene;
    private Scene signScene;
    private Scene verifyScene;
    private KeyController keyController;
    private RSAController rsaController;
    private AESController aesController;
    private SignatureController signatureController;
    private VerifyController verifyController;

    private AppState() {
    }

    static AppState getAppState() {
        return appState;
    }

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

    void setKeyController(KeyController keyController) {
        this.keyController = keyController;
    }

    void setRsaController(RSAController rsaController) {
        this.rsaController = rsaController;
    }

    void setAesController(AESController aesController) {
        this.aesController = aesController;
    }

    void setSignatureController(SignatureController signatureController) {
        this.signatureController = signatureController;
    }

    void setVerifyController(VerifyController verifyController) {
        this.verifyController = verifyController;
    }

    AESController getAesController() {
        return aesController;
    }

    KeyController getKeyController() {
        return keyController;
    }

    RSAController getRsaController() {
        return rsaController;
    }

    SignatureController getSignatureController() {
        return signatureController;
    }

    VerifyController getVerifyController() {
        return verifyController;
    }
}
