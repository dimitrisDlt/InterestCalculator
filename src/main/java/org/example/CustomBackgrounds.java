package org.example;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class CustomBackgrounds {

    private CustomColors colors = new CustomColors();
    private CornerRadii radius = new CornerRadii(8);

    private BackgroundFill primaryBackgroundFill =
            new BackgroundFill(colors.getPrimaryColor(), CornerRadii.EMPTY, Insets.EMPTY);
    private BackgroundFill secondaryBackgroundFill =
            new BackgroundFill(colors.getSecondaryColor(), CornerRadii.EMPTY, Insets.EMPTY);
    private BackgroundFill tertiaryBackgroundFill =
            new BackgroundFill(colors.getTertiaryColor(), CornerRadii.EMPTY, Insets.EMPTY);
    private BackgroundFill fourthBackgroundFill =
            new BackgroundFill(colors.getFourthColor(), CornerRadii.EMPTY, Insets.EMPTY);
    private BackgroundFill transparentBackgroundFill =
            new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);

    private BackgroundFill buttonNormalBackgroundFill =
            new BackgroundFill(colors.getTertiaryColor(), CornerRadii.EMPTY, Insets.EMPTY);
    private BackgroundFill buttonHoveredBackgroundFill =
            new BackgroundFill(colors.getSecondaryColor(), CornerRadii.EMPTY, Insets.EMPTY);
    private BackgroundFill buttonPressedBackgroundFill =
            new BackgroundFill(colors.getFourthColor(), CornerRadii.EMPTY, Insets.EMPTY);

    private BackgroundFill buttonNormalBackgroundFillRounded =
            new BackgroundFill(colors.getPrimaryColor(), radius, Insets.EMPTY);
    private BackgroundFill buttonHoveredBackgroundFillRounded =
            new BackgroundFill(colors.getSecondaryColor(), radius, Insets.EMPTY);
    private BackgroundFill buttonPressedBackgroundFillRounded =
            new BackgroundFill(colors.getFourthColor(), radius, Insets.EMPTY);

    private Background primaryBackground = new Background(primaryBackgroundFill);
    private Background secondaryBackground = new Background(secondaryBackgroundFill);
    private Background tertiaryBackground = new Background(tertiaryBackgroundFill);
    private Background fourthBackground = new Background(fourthBackgroundFill);
    private Background transparentBackground = new Background(transparentBackgroundFill);


    private Background buttonNormalBackground = new Background(buttonNormalBackgroundFill);
    private Background buttonHoveredBackground = new Background(buttonHoveredBackgroundFill);
    private Background buttonPressedBackground = new Background(buttonPressedBackgroundFill);

    private Background buttonNormalBackgroundRounded = new Background(buttonNormalBackgroundFillRounded);
    private Background buttonHoveredBackgroundRounded = new Background(buttonHoveredBackgroundFillRounded);
    private Background buttonPressedBackgroundRounded = new Background(buttonPressedBackgroundFillRounded);

    public CustomBackgrounds() {};

    public CornerRadii getRadius() {
        return radius;
    }

    public Background getButtonNormalBackground() {
        return buttonNormalBackground;
    }

    public Background getButtonHoveredBackground() {
        return buttonHoveredBackground;
    }

    public Background getButtonPressedBackground() {
        return buttonPressedBackground;
    }

    public Background getButtonNormalBackgroundRounded() {
        return buttonNormalBackgroundRounded;
    }

    public Background getButtonHoveredBackgroundRounded() {
        return buttonHoveredBackgroundRounded;
    }

    public Background getButtonPressedBackgroundRounded() {
        return buttonPressedBackgroundRounded;
    }


    public Background getPrimaryBackground() {
        return primaryBackground;
    }

    public Background getSecondaryBackground() {
        return secondaryBackground;
    }

    public Background getTertiaryBackground() {
        return tertiaryBackground;
    }

    public Background getFourthBackground() {
        return fourthBackground;
    }

    public Background getTransparentBackground() {
        return transparentBackground;
    }
}
