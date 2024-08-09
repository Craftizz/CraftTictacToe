package org.example.application;

public class TileInteractor {

    private final TileModel tileModel;
    private TileView tileView;

    public TileInteractor(TileModel tileModel) {
        this.tileModel = tileModel;
    }

    public void registerView(TileView tileView) {
        this.tileView = tileView;
    }

    public boolean requestMove(int row, int column) {

        tileModel.getBoard()[row][column] = 'x';

        return true;
    }

    public void placeMove(int row, int column) {

        tileModel.getBoard()[row][column] = 'x';
        tileView.update(row, column, "x");
    }


}
