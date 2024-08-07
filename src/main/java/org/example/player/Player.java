package org.example.player;

public class Player {

    private final Symbol moveSymbol;

    public Player(Symbol symbol) {
        this.moveSymbol = symbol;
    }

    public Symbol getMoveSymbol() {
        return this.moveSymbol;
    }
}
