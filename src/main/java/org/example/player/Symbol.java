package org.example.player;

public enum Symbol {

    EMPTY(" "),
    ZERO("O"),
    CROSS("X");

    private String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
