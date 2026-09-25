package com.fivenightatscl.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class HomeController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Pane redGlow;

    @FXML
    public void initialize() {
        loadBackground();

        backgroundImage.fitWidthProperty()
                .bind(rootPane.widthProperty());

        backgroundImage.fitHeightProperty()
                .bind(rootPane.heightProperty());

        startRedLightEffect();
        startBackgroundMovement();
    }

    private void loadBackground() {
        Image image = new Image(
                getClass().getResourceAsStream(
                        "/com/fivenightatscl/images/home-background.jpg"));

        backgroundImage.setImage(image);
    }

    private void startRedLightEffect() {
        FadeTransition fade = new FadeTransition(
                Duration.seconds(2.5),
                redGlow);

        fade.setFromValue(0.15);
        fade.setToValue(0.7);

        fade.setAutoReverse(true);
        fade.setCycleCount(FadeTransition.INDEFINITE);

        fade.play();
    }

    private void startBackgroundMovement() {
        ScaleTransition scale = new ScaleTransition(
                Duration.seconds(20),
                backgroundImage);

        scale.setFromX(1.0);
        scale.setFromY(1.0);

        scale.setToX(1.06);
        scale.setToY(1.06);

        scale.setAutoReverse(true);
        scale.setCycleCount(ScaleTransition.INDEFINITE);

        scale.play();
    }

    @FXML
    private void handleNewGame() {
        System.out.println("NEW GAME");
    }

    @FXML
    private void handleContinue() {
        System.out.println("CONTINUE");
    }

    @FXML
    private void handleHowToPlay() {
        System.out.println("HOW TO PLAY");
    }

    @FXML
    private void handleExit() {
        Platform.exit();
    }
}