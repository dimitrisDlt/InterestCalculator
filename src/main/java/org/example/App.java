package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;


public class App extends Application {

    @Override
    public void start(Stage stage) {

        Locale.setDefault(new Locale("el", "GR"));
        System.setProperty("user.language", "el");
        System.setProperty("user.country", "GR");
        System.out.println(Locale.getDefault());

        var scene = new Scene(new MainView(), 1024, 720);
        scene.getStylesheets().add(this.getClass().getClassLoader().getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}