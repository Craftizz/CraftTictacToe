package com.johnlexter.player;

public enum Symbol {

    EMPTY(" "),
    ZERO("O"),
    CROSS("X");

    private String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTextSymbol() {
        return symbol;
    }

}
