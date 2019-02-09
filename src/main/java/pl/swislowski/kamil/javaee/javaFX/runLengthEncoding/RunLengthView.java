package pl.swislowski.kamil.javaee.javaFX.runLengthEncoding;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RunLengthView extends Application {

    private static final String REGEX_INPUT = "(\\w\\d+|\\w\\d+,)+";

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));

        final ToggleGroup toggleGroup = new ToggleGroup();

        final Text actionTarget = new Text();
        actionTarget.setId("actiontarget");

        Text sceneTitle = new Text("Wprowadź dane :");
        sceneTitle.setId("sceneTitle");
        sceneTitle.setFont(Font.font("Arial", FontPosture.ITALIC, 25));

        Label zrodloLabel = new Label("Źródło : ");

        TextField zrodloTextField = new TextField();

        Label operacjaLabel = new Label("Operacja :");

        RadioButton kodowanieRadioButton = new RadioButton();
        kodowanieRadioButton.setToggleGroup(toggleGroup);
        kodowanieRadioButton.setSelected(true);

        Label kodowanieLabel = new Label("kodowanie");

        RadioButton dekodowanieRadioButton = new RadioButton();
        dekodowanieRadioButton.setToggleGroup(toggleGroup);

        Label dekodowanieLabel = new Label("dekodowanie");

        TextField wynikTextField = new TextField();

        Button kopiujButton = new Button("Kopiuj");
        kopiujButton.setAlignment(Pos.BASELINE_RIGHT);
        kopiujButton.setOnAction(event -> {
            zrodloTextField.setText(wynikTextField.getText());
            wynikTextField.setText(null);
        });

        Label wynikLabel = new Label("Wynik operacji :");

        Button wykonajButton = new Button("Wykonaj");
        wykonajButton.setOnAction(event -> {

            actionTarget.setFill(Color.DARKSLATEGRAY);
            actionTarget.setText("Operacja została wykonana");

            String text = zrodloTextField.getText();

            if (text != null && text.length() > 0) {

                boolean correctInput = text.matches(REGEX_INPUT);

                boolean selectedKodowanie = kodowanieRadioButton.isSelected();
                // Jeżeli wybrano kodowanie, to correctInput musi zwrócić false, czyli badany tekst nie zawiera par rozdzielonych przecinkami.
                if (selectedKodowanie) {

                    if (!correctInput) {
                        //Wywołanie metody algorytmu.
                        String encode = RunLength.encode(text);
                        wynikTextField.setText(encode);

                    } else {
                        Alert alertKodowanie = new Alert(Alert.AlertType.WARNING, "Nie można zakodować źródła!", ButtonType.OK);
                        alertKodowanie.show();
                    }
                }

                boolean selectedDekodowanie = dekodowanieRadioButton.isSelected();
                // Jeżeli wybrano dekodowanie, to correctInput musi zwrócić true, czyli badany tekst zawiera pary rozdzielone przecinkami.
                if (selectedDekodowanie) {

                    if (correctInput) {
                        //Wywołanie metody algorytmu.
                        String decode = RunLength.decode(text);
                        wynikTextField.setText(decode);

                    } else {
                        Alert alertDekodowanie = new Alert(Alert.AlertType.WARNING, "Nie można zdekodować źródła!", ButtonType.OK);
                        alertDekodowanie.show();
                    }
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Brak danych w źródle!", ButtonType.OK);
                alert.show();
            }
        });

        HBox hbButton = new HBox(10);
        hbButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbButton.getChildren().add(wykonajButton);

        pane.add(sceneTitle, 0, 0, 2, 1);
        pane.add(zrodloLabel, 0, 1);
        pane.add(zrodloTextField, 0, 2);
        pane.add(operacjaLabel, 2, 1);
        pane.add(kodowanieRadioButton, 2, 2);
        pane.add(kodowanieLabel, 3, 2);
        pane.add(dekodowanieRadioButton, 2, 3);
        pane.add(dekodowanieLabel, 3, 3);
        pane.add(kopiujButton, 0, 3);
        pane.add(wynikLabel, 0, 4);
        pane.add(wynikTextField, 0, 5);
        pane.add(actionTarget, 0, 9);
        pane.add(hbButton, 0, 8);

        Scene scene = new Scene(pane, 500, 400);

        primaryStage.setTitle("Run Length Encoding");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(RunLengthView.class.getResource("Application.css").toExternalForm());
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
