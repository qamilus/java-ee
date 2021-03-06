package pl.swislowski.kamil.javaee.projekt.przejsciowy.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PaintingsAuctionUtilsWindowController {

    public static Stage createStage(FXMLLoader loader, Stage primaryStage, String title) throws IOException {
        AnchorPane pane = loader.load();

        Stage stage = new Stage();
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage);

        Scene scene = new Scene(pane);
        stage.setScene(scene);

        return stage;
    }
}
