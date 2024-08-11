package com.johnlexter.player;

public class Player {

    private final Symbol moveSymbol;

    public Player(Symbol symbol) {
        this.moveSymbol = symbol;
    }

    public Symbol getSymbol() {
        return this.moveSymbol;
    }
}
