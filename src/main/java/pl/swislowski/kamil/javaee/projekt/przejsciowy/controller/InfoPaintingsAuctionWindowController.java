package pl.swislowski.kamil.javaee.projekt.przejsciowy.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoPaintingsAuctionWindowController {

    private Stage primaryStage;

    @FXML
    public TextArea infoTextArea;
    @FXML
    private Button nextButton;
    @FXML
    private PasswordField passwordTextField;

    public void initialize() {
        nextButton.setDisable(true);
    }

    @FXML
    public void passwordTextFieldAction() {

        if (!passwordTextField.getText().equals("Porter2Tralala")) {

            Alert alertWrongPassword = new Alert(Alert.AlertType.WARNING, "Wprowadzono nieprawidłowe hasło!", ButtonType.OK);
            alertWrongPassword.show();
            nextButton.setDisable(true);

        } else {

            Alert alertCorrectPassword = new Alert(Alert.AlertType.WARNING, "Wprowadzono prawidłowe hasło.", ButtonType.OK);
            alertCorrectPassword.show();
            nextButton.setDisable(false);
            passwordTextField.setDisable(true);
        }
        passwordTextField.clear();
    }

    @FXML
    public void nextButtonAction() {

        FXMLLoader loader = new FXMLLoader(InfoPaintingsAuctionWindowController.class.getResource("../view/ListPaintingsAuctionWindowView.fxml"));

        try {

            Stage stage = PaintingsAuctionUtilsWindowController.createStage(loader, primaryStage, "Lista obrazów wystawionych na aukcję");

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

        FXMLLoader loader = new FXMLLoader(ListPaintingsAuctionWindowController.class.getResource("../view/CloseApplicationPaintingsAuctionWindowView.fxml"));

        try {
            Stage stage = PaintingsAuctionUtilsWindowController.createStage(loader, primaryStage, "Zamknąć aplikację ?");

            CloseApplicationPaintingsAuctionWindowController controller = loader.getController();
            controller.setPrimaryStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.close();
    }
}
