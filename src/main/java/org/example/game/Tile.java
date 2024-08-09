package org.example.game;

import javafx.scene.control.Button;
import org.example.player.Symbol;

public class Tile extends Button {

    private Symbol symbol;

    public Tile() {
//        this.setPrefSize(100, 100);
        this.symbol = Symbol.EMPTY;
    }

    public boolean canClick() {
        return symbol == Symbol.EMPTY;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
