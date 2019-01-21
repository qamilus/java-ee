package pl.swislowski.kamil.javaee.javaFX.pracaDomowaNr3.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        mainWindow();
    }

    private void mainWindow() throws IOException {

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/MainWindowView.fxml"));

        AnchorPane pane = loader.load();
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(500);

        Scene scene = new Scene(pane);

        MainWindowController mainWindowController = loader.getController();
        mainWindowController.setMain(this);
        mainWindowController.setPrimaryStage(primaryStage);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
