package org.example.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("TicTacToe");

        GameController gameController = new GameController();
        gameController.initialize();

        Scene scene = new Scene(gameController.getView());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
