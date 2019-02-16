package pl.swislowski.kamil.javaee.przejsciowy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.swislowski.kamil.projekt.przejsciowy.controller.InfoPaintingsAuctionWindowController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/InfoPaintingsAuctionWindowView.fxml"));
        Parent root = loader.load();
        InfoPaintingsAuctionWindowController controller = loader.getController();
        controller.setStage(primaryStage);

        primaryStage.setTitle("Projekt przejściowy");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
