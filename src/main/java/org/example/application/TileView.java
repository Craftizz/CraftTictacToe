package org.example.application;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import org.example.game.Tile;

public class TileView extends GridPane {

    private Button[][] tileButtons;

    public TileView(TileModel model,
                    TileInteractor interactor) {

        int boardSize = model.getBoardSize();

        tileButtons = new Button[boardSize][boardSize];

        for(int row = 0 ; row < boardSize ; row++){
            for(int column = 0 ; column < boardSize; column++){

                final Button tile = new Button();

                // set actionHandler
                tile.setPrefSize(100, 100);

                int currentRow = row;
                int currentColumn = column;

                tile.setOnMouseClicked(mouseEvent -> interactor.placeMove(currentRow, currentColumn));

                add(tile, row, column);

                tileButtons[row][column] = tile;
            }
        }
    }

    public void update(int row, int column, String text) {
        tileButtons[row][column].setText(text);
    }
}
