package org.example.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("TicTacToe");

        TileController tileController = new TileController();
        tileController.initialize();


        Scene scene = new Scene(tileController.getView());




        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
