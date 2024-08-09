package org.example.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class GameApplicationLegacy extends Application {

    private int boardSize;

    @Override
    public void init() {
        this.boardSize = 3;
    }

    @Override
    public void start(Stage window) {
        window.setTitle("TicTacToe");

        createLayout(window);

        window.show();
    }

    private void createLayout(Stage window) {

        BorderPane layout = new BorderPane();
        GridPane tilePane = createTiles();

        layout.setCenter(tilePane);


        Scene view = new Scene(layout);
        window.setScene(view);
    }

    private GridPane createTiles() {

        GridPane tilePane = new GridPane();

        for(int row = 0 ; row < boardSize ; row++){
            for(int column = 0 ; column < boardSize ; column++){
                tilePane.add(new Tile(), row, column);
            }
        }

        return tilePane;
    }



}
