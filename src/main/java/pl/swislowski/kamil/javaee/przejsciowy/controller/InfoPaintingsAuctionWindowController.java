package pl.swislowski.kamil.javaee.przejsciowy.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoPaintingsAuctionWindowController {

    private Stage primaryStage;

    @FXML
    public TextArea infoTextArea;

    @FXML
    public void nextButtonAction() {
        FXMLLoader loader = new FXMLLoader(InfoPaintingsAuctionWindowController.class.getResource("../view/ListPaintingsAuctionWindowView.fxml"));

        try {

            Stage stage = PaintingsAuctionUtilsWindowController.createStage(loader, primaryStage, "Lista Przejsciowy");

            ListPaintingsAuctionWindowController controller = loader.getController();
            controller.setPrimaryStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void cancelAction() {
        primaryStage.close();
    }
}
