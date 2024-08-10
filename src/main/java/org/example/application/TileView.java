package org.example.application;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import org.example.player.Symbol;

public class TileView extends GridPane {

    private final TileController tileController;

    private Tile[][] board;

    public TileView(TileController tileController) {
        this.tileController = tileController;
    }

    public void createTiles(int boardSize, Tile[][] board) {

        this.board = board;

        for(int row = 0 ; row < boardSize ; row++) {
            for (int column = 0; column < boardSize; column++) {

                final Tile tile = board[row][column];

                tile.setOnMouseClicked(_ -> tileController.placeMove(tile.getRow(), tile.getColumn()));

                add(board[row][column], row, column);
            }
        }
    }

    public void update(Tile tile) {
        tile.setText(tile.getSymbol().getSymbol());
    }
}
