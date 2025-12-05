package org.example;

import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CustomColors {

    private Color primaryColor = Color.rgb(59, 2, 112);
    private Color secondaryColor = Color.rgb(111, 0, 255);
    private Color tertiaryColor = Color.rgb(233, 179, 251);
    private Color fourthColor = Color.rgb(255, 241, 241);

    public CustomColors() {

//        Properties props = new Properties();
//
//            try (InputStream in = App.class.getClassLoader().getResourceAsStream("config.properties")) {
//
//            props.load(in);
//            primaryColor = Color.valueOf(props.getProperty("primaryColor"));
//            secondaryColor = Color.valueOf(props.getProperty("secondaryColor"));
//            tertiaryColor = Color.valueOf(props.getProperty("tertiaryColor"));
//            fourthColor = Color.valueOf(props.getProperty("fourthColor"));
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

    };

    public String toRGBCode(Color color) {

        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public Color getTertiaryColor() {
        return tertiaryColor;
    }

    public Color getFourthColor() {
        return fourthColor;
    }
}
