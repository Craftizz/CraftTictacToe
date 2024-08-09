package org.example.application;

import javafx.scene.layout.Region;

public class TileController {

    private final Region view;

    public TileController() {
        TileModel tileModel = new TileModel(3);
        TileInteractor tileInteractor = new TileInteractor(tileModel);
        TileView tileView = new TileView(tileModel, tileInteractor);

        view = tileView;

        tileInteractor.registerView(tileView);
    }

    public Region getView() {
        return view;
    }

}
