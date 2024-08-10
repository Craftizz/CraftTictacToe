package org.example.game;

import javafx.scene.control.Button;

public class Tile extends Button  {

    private Symbol symbol;

    private final int row;
    private final int column;

    public Tile(int row, int column) {
        this.row = row;
        this.column = column;
        this.symbol = Symbol.EMPTY;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


}
