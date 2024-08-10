package org.example.game;

import org.example.player.Player;
import org.example.player.Symbol;

public class Board {

//    private final int boardSize;
//
//    private char [][] board;
//    private int remainingMoves;
//
//    public Board(int boardSize) {
//        this.boardSize = boardSize;
//    }
//
//    public void initialize() {
//
//        this.board = new char[boardSize][boardSize];
//        this.remainingMoves = boardSize * boardSize;
//
//        for(int row = 0 ; row <boardSize ; ++row){
//            for(int column = 0 ; column < boardSize ; ++column){
//
////                board[row][column] = Symbol.EMPTY.getSymbol();
//            }
//        }
//    }
//
//    public void display() {
//        for(int row = 0 ; row <boardSize ; ++row){
//            for(int column = 0 ; column < boardSize ; ++column){
//
//                System.out.print(board[row][column] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public void endGame() {
//        this.remainingMoves = 0;
//    }
//
//    public void placeMove(Player player, int move) {
//
//        int row = move / boardSize;
//        int column = move % boardSize;
//
//        board[row][column] = player.getSymbol().getSymbol();
//        remainingMoves--;
//    }
//
//    public boolean isValidMove(int move) {
//
//        int row = move / boardSize;
//        int column = move % boardSize;
//
//        return move >= 0
//                && move < boardSize * boardSize
//                && board[row][column] == Symbol.EMPTY.getSymbol();
//    }
//
//    public boolean canMove() {
//
//        return remainingMoves != 0;
//    }
//
//    public boolean hasWinner(Player player) {
//
//        return checkRows(player)
//                || checkColumns(player)
//                || checkDiagonals(player);
//    }
//
//    private boolean checkRows(final Player player) {
//
//        for(int row = 0 ; row < boardSize; ++row){
//
//            int count = 0;
//
//            for(int column = 0 ; column < boardSize; ++column){
//
//                if (board[row][column] == player.getSymbol().getSymbol()) {
//
//                    count++;
//                }
//            }
//
//            if (count == boardSize) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean checkColumns(final Player player) {
//
//        for(int row = 0 ; row < boardSize; ++row){
//
//            int count = 0;
//
//            for(int column = 0 ; column < boardSize; ++column){
//
//                if (board[column][row] == player.getSymbol().getSymbol()) {
//
//                    count++;
//                }
//            }
//
//            if (count == boardSize) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean checkDiagonals(final Player player) {
//
//        int count = 0;
//
//        for(int row = 0 ; row < boardSize; ++row){
//
//            if (board[row][row] == player.getSymbol().getSymbol()) {
//
//                count++;
//            }
//
//            if (count == boardSize) {
//                return true;
//            }
//        }
//
//        count = 0;
//
//        for (int row = 0 ; row < boardSize; ++row) {
//            for (int  column = 0 ; column < boardSize; ++column) {
//                if(row + column == boardSize - 1){
//                    if(board[row][column] == player.getSymbol().getSymbol()){
//                        count++;
//                    }
//                }
//            }
//        }
//        return count == boardSize;
//    }
}
