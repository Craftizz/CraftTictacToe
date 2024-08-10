package org.example.application;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import org.example.game.GameState;
import org.example.game.Player;
import org.example.game.Symbol;
import org.example.game.Tile;

import java.util.LinkedList;
import java.util.Queue;

public class GameController {

    private final GameModel gameModel;
    private final TileView tileView;
    private final NotifyView notifyView;
    private final Queue<Player> playerQueue;

    private GameState gameState;

    public GameController() {
        this.gameModel = new GameModel(3);
        this.tileView = new TileView(this);
        this.notifyView = new NotifyView();
        this.playerQueue = new LinkedList<>();
    }

    public Region getView() {

        BorderPane layout = new BorderPane();
        layout.setCenter(tileView);
        layout.setBottom(notifyView);

        return layout;
    }

    public void initialize() {
        tileView.createTiles(gameModel.getBoardSize(), gameModel.getBoard());

        playerQueue.add(new Player(Symbol.CROSS));
        playerQueue.add(new Player(Symbol.ZERO));
        this.gameState = GameState.RUNNING;
    }

    public void placeMove(int row, int column) {

        Tile tile = gameModel.getTile(row, column);
        Player player = playerQueue.poll();

        if (gameState == GameState.END) {

            return;
        }

        if (tile.getSymbol() == Symbol.EMPTY) {

            tile.setSymbol(player.getSymbol());
            tileView.update(tile);
        }

        if (isWinner(player)) {

            notifyView.notifyWin(player);
            this.gameState = GameState.END;
        }
        else {
            playerQueue.add(player);
        }
    }


    private boolean isWinner(Player player) {

        Tile[][] board = gameModel.getBoard();
        int boardSize = gameModel.getBoardSize();

        /* Check Column */
        for (int row = 0; row < boardSize; row++) {

            int count = 0;

            for (int column = 0; column < boardSize; column++) {
                if (board[row][column].getSymbol() == player.getSymbol()) {

                    count++;
                }
            }

            if (count == boardSize) {
                return true;
            }
        }

        /* Check Rows */
        for(int row = 0 ; row < boardSize; row++){

            int count = 0;

            for(int column = 0 ; column < boardSize; column++){

                if (board[column][row].getSymbol() == player.getSymbol()) {

                    count++;
                }
            }

            if (count == boardSize) {
                return true;
            }
        }

        /* Check Diagonals */
        int count = 0;

        for(int row = 0 ; row < boardSize; row++){

            if (board[row][row].getSymbol() == player.getSymbol()) {

                count++;
            }

            if (count == boardSize) {
                return true;
            }
        }

        count = 0;

        for (int row = 0 ; row < boardSize; row++) {
            for (int  column = 0 ; column < boardSize; column++) {
                if(row + column == boardSize - 1){
                    if(board[row][column].getSymbol() == player.getSymbol()){
                        count++;
                    }
                }
            }
        }

        return count == boardSize;
    }
}
