package com.johnlexter.application;

import com.johnlexter.game.Game;
import javafx.scene.layout.Region;
import com.johnlexter.player.Player;

public class GameController {

    private final GameModel gameModel;
    private final GameView gameView;

    public GameController() {
        this.gameModel = new GameModel();
        this.gameView = new GameView(this);
    }

    public void createGame(int boardSize) {

        final Game game = gameModel.createGame(boardSize);

        game.setGameToPlayerVersusPlayer();
        gameView.createTiles(game.getBoard(), game.getBoardSize());

        notifyFirstPlayer(game);
    }

    public void placeMove(int row, int column) {

        final Game game = gameModel.getGame();
        final Player currentPlayer = game.getCurrentPlayer();
        final Player nextPlayer = game.getNextPlayer();

        if (game.hasEnded()) {

            return;
        }

        if (game.isValidMove(row, column)) {

            gameView.updateTile(game.registerMove(currentPlayer, row, column));
        }

        if (game.isWinner(currentPlayer)) {

            gameView.notifyWin(currentPlayer);
            game.endGame();

            return;
        }

        if (game.hasNoRemainingMoves()) {

            gameView.notifyTie();
            game.endGame();

            return;
        }

        gameView.notifyTurn(nextPlayer);
    }

    private void notifyFirstPlayer(final Game game) {

        final Player nextPlayer = game.getNextPlayer();

        gameView.notifyTurn(nextPlayer);
    }

    public Region getView() {

        return gameView;
    }
}
