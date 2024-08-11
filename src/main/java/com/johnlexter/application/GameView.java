package com.johnlexter.application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import com.johnlexter.player.Player;
import com.johnlexter.game.Tile;

public class GameView extends BorderPane {

    private final GameController gameController;

    private final GridPane tileGrid;
    private final Label notifyLabel;

    public GameView(GameController gameController) {
        this.gameController = gameController;
        this.tileGrid = new GridPane();
        this.notifyLabel = new Label();

        tileGrid.setPadding(new Insets(20, 20, 0, 20));
        notifyLabel.setPadding(new Insets(20, 20, 20, 20));

        setCenter(tileGrid);
        setBottom(notifyLabel);
    }

    public void createTiles(Tile[][] board, int boardSize) {

        for(int row = 0 ; row < boardSize ; row++) {
            for (int column = 0; column < boardSize; column++) {

                final Tile tile = board[row][column];

                tile.setOnMouseClicked(_ -> gameController.placeMove(tile.getRow(), tile.getColumn()));

                tileGrid.add(board[row][column], row, column);
            }
        }
    }

    public void updateTile(Tile tile) {
        tile.setText(tile.getSymbol().getTextSymbol());
    }

    public void notifyTurn(Player player) {
        notifyLabel.setText("Your turn, Player " + player.getSymbol().getTextSymbol());
    }

    public void notifyWin(Player player) {
        notifyLabel.setText("Player " + player.getSymbol().getTextSymbol() + " won the game.");
    }

    public void notifyTie() {
        notifyLabel.setText("There are no winners.");
    }
}
