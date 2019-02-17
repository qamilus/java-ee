package pl.swislowski.kamil.javaee.projekt.przejsciowy.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class CloseApplicationPaintingsAuctionWindowController {

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void closeApplicationButtonAction(ActionEvent actionEvent) {
        primaryStage.close();
    }

    public void noCloseButtonApplication(ActionEvent actionEvent) {
    }
}
