package org.example.application;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import org.example.game.Tile;

public class TileView extends GridPane {

    private final GameController gameController;

    private Tile[][] board;

    public TileView(GameController gameController) {
        this.gameController = gameController;

        setPadding(new Insets(20, 20, 0, 20));
    }

    public void createTiles(int boardSize, Tile[][] board) {

        this.board = board;

        for(int row = 0 ; row < boardSize ; row++) {
            for (int column = 0; column < boardSize; column++) {

                final Tile tile = board[row][column];

                tile.setOnMouseClicked(_ -> gameController.placeMove(tile.getRow(), tile.getColumn()));

                add(board[row][column], row, column);
            }
        }
    }

    public void update(Tile tile) {
        tile.setText(tile.getSymbol().getTextSymbol());
    }
}
