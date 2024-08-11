package com.johnlexter.game;

import com.johnlexter.player.Player;
import com.johnlexter.player.PlayerBot;
import com.johnlexter.player.Symbol;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

    private Tile[][] board;

    private int boardSize;
    private int remainingMoves;

    private GameState gameState;

    private final Queue<Player> playerQueue;

    public Game(int boardSize) {
        this.boardSize = boardSize;
        this.playerQueue = new LinkedList<>();

        generateTiles();
    }

    public void setGameToPlayerVersusComputer() {
        playerQueue.add(new Player(Symbol.CROSS));
        playerQueue.add(new PlayerBot(Symbol.ZERO));

        gameState = GameState.RUNNING;
    }

    public void setGameToPlayerVersusPlayer() {
        playerQueue.add(new Player(Symbol.CROSS));
        playerQueue.add(new PlayerBot(Symbol.ZERO));

        gameState = GameState.RUNNING;
    }

    public boolean isWinner(Player player) {

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

    public boolean isValidMove(int row,
                               int column) {
        return board[row][column].getSymbol() == Symbol.EMPTY;
    }

    public boolean hasNoRemainingMoves() {
        return remainingMoves == 0;
    }

    public Tile registerMove(Player player,
                             int row,
                             int column) {

        final Tile tile = board[row][column];

        tile.setSymbol(player.getSymbol());
        remainingMoves--;

        playerQueue.add(player);

        return tile;
    }

    public Player getCurrentPlayer() {
        return playerQueue.poll();
    }

    public Player getNextPlayer() {
        return playerQueue.peek();
    }

    public boolean isRunning() {
        return gameState == GameState.RUNNING;
    }

    public boolean hasEnded() {
        return gameState == GameState.END;
    }

    public void endGame() {
        this.gameState = GameState.END;
    }

    private void generateTiles() {
        this.board = new Tile[boardSize][boardSize];

        for(int row = 0 ; row <boardSize ; ++row){
            for(int column = 0 ; column < boardSize ; ++column){

                Tile tile = new Tile(row, column);
                tile.setPrefSize(100, 100);

                board[row][column] = tile;
                remainingMoves++;
            }
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Tile[][] getBoard() {
        return board;
    }

    private enum GameState {
        RUNNING,
        WAITING,
        END;
    }
}
