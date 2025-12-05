package org.example;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CustomInput extends TextField {

    private CustomBackgrounds inputBackgrounds = new CustomBackgrounds();
    private CustomColors inputColors = new CustomColors();
    private CustomFonts inputFonts = new CustomFonts();
    private CustomBorders inputBorders = new CustomBorders();

    public CustomInput() {

        this.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setBorder(inputBorders.getPrimaryBorder());
        this.setFont(inputFonts.getStandardBoldFont());
        this.setStyle("-fx-background: transparent; -fx-background-color: transparent; -fx-text-fill: rgb(" + inputColors.getPrimaryColor().getRed() * 255 + ", " + inputColors.getPrimaryColor().getGreen() * 255 + ", " + inputColors.getPrimaryColor().getBlue() * 255 + ");");


        this.setOnMouseEntered(e -> {

            this.setBorder(inputBorders.getSecondaryBorder());

            this.setStyle("-fx-background: transparent; -fx-background-color: transparent; -fx-text-fill: rgb(" + inputColors.getSecondaryColor().getRed() * 255 + ", " + inputColors.getSecondaryColor().getGreen() * 255 + ", " + inputColors.getSecondaryColor().getBlue() * 255 + ");");
        });

        this.setOnMouseExited(e -> {

            this.setBorder(inputBorders.getPrimaryBorder());
            this.setStyle("-fx-background: transparent; -fx-background-color: transparent; -fx-text-fill: rgb(" + inputColors.getPrimaryColor().getRed() * 255 + ", " + inputColors.getPrimaryColor().getGreen() * 255 + ", " + inputColors.getPrimaryColor().getBlue() * 255 + ");");
        });
    }
}
