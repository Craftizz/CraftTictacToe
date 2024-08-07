package org.example.player;

public enum Symbol {

    EMPTY('-'),
    ZERO('O'),
    CROSS('X');

    private char symbol;

    Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

}
