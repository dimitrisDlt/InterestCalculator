package org.example;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;

public class ButtonStack extends StackPane {

    private Button mainButton = new Button();
    private Button backgroundButton = new Button();
    private FadeTransition hoverEnterAnimation = new FadeTransition(Duration.millis(350));
    private FadeTransition hoverExitAnimation = new FadeTransition(Duration.millis(350));


    private CustomColors colors = new CustomColors();
    private CustomBackgrounds backgrounds = new CustomBackgrounds();
    private CustomFonts fonts = new CustomFonts();

    public ButtonStack(String text) {

        mainButton.setText(text);
        mainButton.getStyleClass().add("main-button");

        backgroundButton.setText(text);
        backgroundButton.getStyleClass().add("background-button");

        backgroundButton.setEffect(new DropShadow(10, Color.BLACK));

        this.getChildren().add(backgroundButton);
        this.getChildren().add(mainButton);
        this.setBackground(backgrounds.getTransparentBackground());

        hoverEnterAnimation.setNode(mainButton);
        hoverEnterAnimation.setFromValue(1);
        hoverEnterAnimation.setToValue(0);
        hoverExitAnimation.setNode(mainButton);
        hoverExitAnimation.setFromValue(0);
        hoverExitAnimation.setToValue(1);

        mainButton.setOnMouseEntered(e -> {

            hoverExitAnimation.stop();
            hoverEnterAnimation.play();
        });

        mainButton.setOnMouseExited(e -> {

            hoverEnterAnimation.stop();
            hoverExitAnimation.play();
        });
    }

    public Button getButton() {
        return mainButton;
    }

    public void setSize(int width, int height) {

        this.setMinSize(width, height);
        this.setMaxSize(width, height);
        mainButton.setMinSize(width, height);
        mainButton.setMaxSize(width, height);
        backgroundButton.setMinSize(width, height);
        backgroundButton.setMaxSize(width, height);
    }

    public void setImage(String svgData) {

        SVGPath frontImage = new SVGPath();
        SVGPath backImage = new SVGPath();

        frontImage.setContent(svgData);
        frontImage.setStroke(colors.getFourthColor());
        frontImage.setStrokeWidth(1);
        frontImage.setFillRule(FillRule.EVEN_ODD);
        frontImage.setFill(Color.WHITE);

        backImage.setContent(svgData);
        backImage.setStroke(colors.getFourthColor());
        backImage.setStrokeWidth(1);
        backImage.setFillRule(FillRule.EVEN_ODD);
        backImage.setFill(Color.WHITE);

        mainButton.setGraphic(frontImage);
        mainButton.setGraphicTextGap(8);
        backgroundButton.setGraphic(backImage);
        backgroundButton.setGraphicTextGap(8);
    }
}
