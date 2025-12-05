package org.example;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CustomLabel extends Label {

    private CustomFonts labelFonts = new CustomFonts();
    private CustomColors colors = new CustomColors();

    public CustomLabel(String text) {

        this.setText(text);
        this.setFont(labelFonts.getStandardBoldFont());
        this.setStyle("-fx-text-fill: rgb(" + colors.getPrimaryColor().getRed() * 255 + ", " + colors.getPrimaryColor().getGreen() * 255 + ", " + colors.getPrimaryColor().getBlue() * 255 + ");");
    };
}
