package org.example.application;

import org.example.player.Symbol;

public class TileModel {

    private int boardSize;
    private Tile[][] board;

    public TileModel(int boardSize) {
        this.boardSize = boardSize;
        this.board = new Tile[boardSize][boardSize];

        for(int row = 0 ; row <boardSize ; ++row){
            for(int column = 0 ; column < boardSize ; ++column){

                Tile tile = new Tile(row, column);
                tile.setPrefSize(100, 100);

                board[row][column] = tile;
            }
        }
    }

    public Tile[][] getBoard() {
        return board;
    }

    public Tile getTile(int row, int column) {
        return board[row][column];
    }

    public int getBoardSize() {
        return boardSize;
    }



}
