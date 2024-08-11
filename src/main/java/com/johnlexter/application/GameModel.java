package com.johnlexter.application;

import com.johnlexter.game.Game;
import com.johnlexter.game.Tile;

public class GameModel {

    private Game game;

    public Game createGame(int boardSize) {
        return this.game = new Game(boardSize);
    }

    public Game getGame() {
        return game;
    }
}
