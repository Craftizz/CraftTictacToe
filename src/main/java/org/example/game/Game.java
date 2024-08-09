package org.example.game;

import org.example.player.Player;
import org.example.player.Symbol;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

    private final Board board;



//    private final Scanner input;
    private final Queue<Player> playerQueue;


    public Game(int boardSize) {
        this.board = new Board(boardSize);
//        this.input = new Scanner(System.in);
        this.playerQueue = new LinkedList<>();

        playerQueue.add(new Player(Symbol.CROSS));
        playerQueue.add(new Player(Symbol.ZERO));
    }

    public void run() {

        while (board.canMove()) {

            board.display();
//            requestMove();
        }
    }

    private void visualize() {

    }











//    public void requestMove() {
//
//        final Player player = playerQueue.poll();
//
//        System.out.println("Player " + player.getMoveSymbol() + ", make a move.");
//
//        int move = input.nextInt();
//
//        while (!board.isValidMove(move)) {
//
//            System.out.println("Please make a valid move! Input again.");
//            move = input.nextInt();
//        }
//
//        board.placeMove(player, move);
//
//        if (board.hasWinner(player)) {
//
//            System.out.println("Player " + player.getMoveSymbol() + " has won the game!");
//
//            board.display();
//            board.endGame();
//        }
//        else {
//            playerQueue.add(player);
//        }
//    }
}
