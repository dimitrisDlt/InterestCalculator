package org.example;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class CustomAnimations {

    private CustomColors colors = new CustomColors();
    private CustomBackgrounds backgrounds = new CustomBackgrounds();

    public CustomAnimations() {};

    public void buttonHoverEnterAnimate(Button btn) {

        Animation buttonHoverAnimation = new Transition() {

            {
                setCycleDuration(Duration.millis(500));
                setInterpolator(Interpolator.LINEAR);
            }

            @Override
            protected void interpolate(double frac) {

                int newRedColor =
                        (int) (255 * (colors.getTertiaryColor().getRed() + ((colors.getSecondaryColor().getRed() - colors.getTertiaryColor().getRed()) * frac)));
                int newGreenColor =
                        (int) (255 * (colors.getTertiaryColor().getGreen() + ((colors.getSecondaryColor().getGreen() - colors.getTertiaryColor().getGreen()) * frac)));
                int newBlueColor =
                        (int) (255 * (colors.getTertiaryColor().getBlue() + ((colors.getSecondaryColor().getBlue() - colors.getTertiaryColor().getBlue()) * frac)));

                btn.setBackground(new Background(new BackgroundFill(Color.rgb(newRedColor, newGreenColor, newBlueColor), backgrounds.getRadius(), Insets.EMPTY)));
            }
        };

        buttonHoverAnimation.play();
    }

    public void buttonHoverExitAnimate(Button btn) {

        Animation buttonHoverAnimation = new Transition() {

            {
                setCycleDuration(Duration.millis(500));
                setInterpolator(Interpolator.LINEAR);
            }

            @Override
            protected void interpolate(double frac) {

                int newRedColor =
                        (int) (255 * (colors.getSecondaryColor().getRed() + ((colors.getPrimaryColor().getRed() - colors.getSecondaryColor().getRed()) * frac)));
                int newGreenColor =
                        (int) (255 * (colors.getSecondaryColor().getGreen() + ((colors.getPrimaryColor().getGreen() - colors.getSecondaryColor().getGreen()) * frac)));
                int newBlueColor =
                        (int) (255 * (colors.getSecondaryColor().getBlue() + ((colors.getPrimaryColor().getBlue() - colors.getSecondaryColor().getBlue()) * frac)));

                btn.setBackground(new Background(new BackgroundFill(Color.rgb(newRedColor, newGreenColor, newBlueColor), backgrounds.getRadius(), Insets.EMPTY)));
            }
        };

        buttonHoverAnimation.play();
    }

    public void inputHoverEnterAnimate(TextField input) {

        Animation buttonHoverAnimation = new Transition() {

            {
                setCycleDuration(Duration.millis(500));
                setInterpolator(Interpolator.LINEAR);
            }

            @Override
            protected void interpolate(double frac) {

                int newRedColor =
                        (int) (255 * (colors.getPrimaryColor().getRed() + ((colors.getTertiaryColor().getRed() - colors.getPrimaryColor().getRed()) * frac)));
                int newGreenColor =
                        (int) (255 * (colors.getPrimaryColor().getGreen() + ((colors.getTertiaryColor().getGreen() - colors.getPrimaryColor().getGreen()) * frac)));
                int newBlueColor =
                        (int) (255 * (colors.getPrimaryColor().getBlue() + ((colors.getTertiaryColor().getBlue() - colors.getPrimaryColor().getBlue()) * frac)));

                input.setBorder(new Border(new BorderStroke(Color.rgb(newRedColor, newGreenColor, newBlueColor), BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY, new BorderWidths(0, 0, 4, 0))));
            }
        };

        buttonHoverAnimation.play();
    }

    public void inputHoverExitAnimate(TextField input) {

        Animation buttonHoverAnimation = new Transition() {

            {
                setCycleDuration(Duration.millis(500));
                setInterpolator(Interpolator.LINEAR);
            }

            @Override
            protected void interpolate(double frac) {

                int newRedColor =
                        (int) (255 * (colors.getTertiaryColor().getRed() + ((colors.getPrimaryColor().getRed() - colors.getTertiaryColor().getRed()) * frac)));
                int newGreenColor =
                        (int) (255 * (colors.getTertiaryColor().getGreen() + ((colors.getPrimaryColor().getGreen() - colors.getTertiaryColor().getGreen()) * frac)));
                int newBlueColor =
                        (int) (255 * (colors.getTertiaryColor().getBlue() + ((colors.getPrimaryColor().getBlue() - colors.getTertiaryColor().getBlue()) * frac)));

                input.setBorder(new Border(new BorderStroke(Color.rgb(newRedColor, newGreenColor, newBlueColor), BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY, new BorderWidths(0, 0, 4, 0))));
            }
        };

        buttonHoverAnimation.play();
    }
}
