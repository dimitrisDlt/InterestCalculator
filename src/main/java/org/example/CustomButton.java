package org.example;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CustomButton extends Button {

    private CustomBackgrounds buttonBackgrounds = new CustomBackgrounds();
    private CustomColors buttonColors = new CustomColors();
    private CustomFonts buttonFonts = new CustomFonts();
    private CustomAnimations buttonAnimations = new CustomAnimations();

    private Clipboard clipboard = Clipboard.getSystemClipboard();
    private ClipboardContent content = new ClipboardContent();


    public CustomButton(String text) {

        this.setBackground(buttonBackgrounds.getTransparentBackground());
        this.setTextFill(buttonColors.getPrimaryColor());
        this.setFont(buttonFonts.getDefaultButtonFont());
        this.setStyle("-fx-background-color: transparent; -fx-text-fill: rgb(" + buttonColors.getPrimaryColor().getRed() * 255 + ", "
                + buttonColors.getPrimaryColor().getGreen() * 255 + ", " + buttonColors.getPrimaryColor().getBlue() * 255 + ");");
        this.setMinSize(170, 35);
        this.setMaxSize(170, 35);
        this.setText(text);
        //this.setEffect(new DropShadow(15, Color.BLACK));

        this.setOnMouseEntered(e -> {

            this.setStyle("-fx-background-radius: 0px; -fx-border-style: none; -fx-background-color: rgb(" + buttonColors.getPrimaryColor().getRed() * 255 + ", " + buttonColors.getPrimaryColor().getGreen() * 255 + ", "
                    + buttonColors.getPrimaryColor().getBlue() * 255 + "); -fx-text-fill: rgb(" + buttonColors.getFourthColor().getRed() * 255 + ", "
                    + buttonColors.getFourthColor().getGreen() * 255 + ", " + buttonColors.getFourthColor().getBlue() * 255 + ");");
        });

        this.setOnMouseExited(e -> {

            this.setStyle("-fx-background-color: transparent; -fx-text-fill: rgb(" + buttonColors.getPrimaryColor().getRed() * 255 + ", "
                    + buttonColors.getPrimaryColor().getGreen() * 255 + ", " + buttonColors.getPrimaryColor().getBlue() * 255 + ");");
        });

        this.setOnMousePressed(e -> {

            content.putString(this.getText());
            clipboard.setContent(content);
            this.setStyle("-fx-background-radius: 0px; -fx-border-style: none; -fx-background-color: rgb(" + buttonColors.getSecondaryColor().getRed() * 255 + ", "
                    + buttonColors.getSecondaryColor().getGreen() * 255 + ", " + buttonColors.getSecondaryColor().getBlue() * 255 + "); -fx-text-fill: rgb("
                    + buttonColors.getFourthColor().getRed() * 255 + ", " + buttonColors.getFourthColor().getGreen() * 255 + ", "
                    + buttonColors.getFourthColor().getBlue() * 255 + ");");
        });

        this.setOnMouseReleased(e -> {

            if (this.isHover()) {

                this.setStyle("-fx-background-radius: 0px; -fx-border-style: none; -fx-background-color: rgb(" + buttonColors.getPrimaryColor().getRed() * 255 + ", " + buttonColors.getPrimaryColor().getGreen() * 255 + ", "
                        + buttonColors.getPrimaryColor().getBlue() * 255 + "); -fx-text-fill: rgb(" + buttonColors.getFourthColor().getRed() * 255 + ", "
                        + buttonColors.getFourthColor().getGreen() * 255 + ", " + buttonColors.getFourthColor().getBlue() * 255 + ");");
            }
            else {

                this.setStyle("-fx-background-color: transparent; -fx-text-fill: rgb(" + buttonColors.getPrimaryColor().getRed() * 255 + ", "
                        + buttonColors.getPrimaryColor().getGreen() * 255 + ", " + buttonColors.getPrimaryColor().getBlue() * 255 + ");");
            }
        });


    };
}
