package pl.swislowski.kamil.javaee.projekt.przejsciowy.controller;

import javafx.stage.Stage;

public abstract class PaintingsAuctionWindowController {

    private Stage primaryStage;

    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
