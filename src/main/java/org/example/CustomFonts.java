package org.example;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CustomFonts {

    private int standardFontSize = 16;

    private Font defaultButtonFont = Font.font("System", FontWeight.BOLD, standardFontSize);

    private Font standardBoldFont = Font.font("System", FontWeight.BOLD, standardFontSize);


    public CustomFonts() {};

    public int getStandardFontSize() {
        return standardFontSize;
    }

    public Font getDefaultButtonFont() {
        return defaultButtonFont;
    }

    public Font getStandardBoldFont() {
        return standardBoldFont;
    }
}
