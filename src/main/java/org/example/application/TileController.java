package org.example.application;

import javafx.scene.layout.Region;
import org.example.player.Player;
import org.example.player.Symbol;

import java.util.LinkedList;
import java.util.Queue;

public class TileController {

    private final TileModel tileModel;
    private final TileView tileView;

    private final Queue<Player> playerQueue;

    public TileController() {
        this.tileModel = new TileModel(3);
        this.tileView = new TileView(this);
        this.playerQueue = new LinkedList<>();
    }

    public Region getView() {
        return tileView;
    }

    public void initialize() {
        tileView.createTiles(tileModel.getBoardSize(), tileModel.getBoard());

        playerQueue.add(new Player(Symbol.CROSS));
        playerQueue.add(new Player(Symbol.ZERO));
    }

    public void placeMove(int row, int column) {

        Tile tile = tileModel.getTile(row, column);
        Player player = playerQueue.poll();

        if (tile.getSymbol() == Symbol.EMPTY) {

            tile.setSymbol(player.getSymbol());
            tileView.update(tile);
        }

        if (checkPattern(player)) {
            System.out.println("Winner");
        }
        else {
            playerQueue.add(player);
        }
    }


    private boolean checkPattern(Player player) {

        Tile[][] board = tileModel.getBoard();
        int boardSize = tileModel.getBoardSize();

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
