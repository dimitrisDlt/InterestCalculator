package org.example;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CustomBorders {

    private CustomColors borderColors = new CustomColors();

    private Border primaryBorder =
            new Border(new BorderStroke(borderColors.getPrimaryColor(), BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY, new BorderWidths(0, 0, 4, 0)));

    private Border secondaryBorder =
            new Border(new BorderStroke(borderColors.getSecondaryColor(), BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY, new BorderWidths(0, 0, 4, 0)));

    private Border tertiaryBorder =
            new Border(new BorderStroke(borderColors.getTertiaryColor(), BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY, new BorderWidths(0, 0, 4, 0)));

    private Border fourthBorder =
            new Border(new BorderStroke(borderColors.getFourthColor(), BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY, new BorderWidths(0, 0, 4, 0)));

    private Border transparentBorder =
            new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.NONE,
                    CornerRadii.EMPTY, new BorderWidths(0, 0, 0, 0)));

    public CustomBorders() {};

    public Border getPrimaryBorder() {
        return primaryBorder;
    }

    public Border getSecondaryBorder() {
        return secondaryBorder;
    }

    public Border getTertiaryBorder() {
        return tertiaryBorder;
    }

    public Border getFourthBorder() {
        return fourthBorder;
    }

    public Border getTransparentBorder() {
        return transparentBorder;
    }
}
