package org.example.application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import org.example.game.Player;

public class NotifyView extends Label {

    public NotifyView() {
        setPadding(new Insets(20, 0, 5, 20));
    }

    public void notifyTurn(Player player) {
        setText("Your turn, Player " + player.getSymbol().getTextSymbol());
    }

    public void notifyWin(Player player) {
        setText("Player " + player.getSymbol().getTextSymbol() + " won the game.");
    }


}
