package org.example.application;

import org.example.player.Symbol;

public class TileModel {

    private int boardSize;
    private char[][] board;

    public TileModel(int boardSize) {
        this.boardSize = boardSize;
        this.board = new char[boardSize][boardSize];

        for(int row = 0 ; row <boardSize ; ++row){
            for(int column = 0 ; column < boardSize ; ++column){

                board[row][column] = Symbol.EMPTY.getSymbol();
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public int getBoardSize() {
        return boardSize;
    }




}
