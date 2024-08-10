package org.example.application;

import javafx.scene.layout.Region;
import org.example.player.Player;
import org.example.player.Symbol;

import java.util.LinkedList;
import java.util.Queue;

public class TileController {

    private final TileModel tileModel;
    private final TileView tileView;

    private final Queue<Player> playerQueue;

    public TileController() {
        this.tileModel = new TileModel(3);
        this.tileView = new TileView(this);
        this.playerQueue = new LinkedList<>();
    }

    public Region getView() {
        return tileView;
    }

    public void initialize() {
        tileView.createTiles(tileModel.getBoardSize(), tileModel.getBoard());

        playerQueue.add(new Player(Symbol.CROSS));
        playerQueue.add(new Player(Symbol.ZERO));
    }

    public void placeMove(int row, int column) {

        final Tile tile = tileModel.getTile(row, column);
        final Player player = playerQueue.poll();

        if (tile.getSymbol() == Symbol.EMPTY) {

            tile.setSymbol(player.getSymbol());
            tileView.update(tile);
        }

        playerQueue.add(player);
    }

}
