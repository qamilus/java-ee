package pl.swislowski.kamil.javaee.projekt.przejsciowy.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.swislowski.kamil.projekt.przejsciowy.model.Painting;

public class UpdatePaintingsAuctionWindowController {

    private static final String CIRCLE_FIELD_0 = "0";
    private static final String NON_CIRCLE_FIELD_0 = "0";

    private Stage primaryStage;
    private ObservableList<Painting> przejsciowyBeans;
    private int selectedIndex;

    @FXML
    private TextField titleTextField;
    @FXML
    private TextField authorTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    private TextField widthTextField;
    @FXML
    private TextField radiusTextField;
    @FXML
    private TextField nonCircleFieldTextField;
    @FXML
    private TextField circleFieldTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField categoryTextField;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setPrzejsciowyBeans(ObservableList<Painting> przejsciowyBeans) {
        this.przejsciowyBeans = przejsciowyBeans;
    }

    public void initialize() {
        nonCircleFieldTextField.setDisable(true);
        circleFieldTextField.setDisable(true);
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public void populateData() {
        Painting bean = this.przejsciowyBeans.get(this.selectedIndex);
        titleTextField.setText(bean.getTitle());
        authorTextField.setText(bean.getAuthor());
        heightTextField.setText(bean.getHeight());
        widthTextField.setText(bean.getWidth());
        radiusTextField.setText(bean.getRadius());
        nonCircleFieldTextField.setText(bean.getNonCircleField());
        circleFieldTextField.setText(bean.getCircleField());
        weightTextField.setText(bean.getWeight());
        priceTextField.setText(bean.getPrice());
        categoryTextField.setText(bean.getCategory());
    }

    public void saveButtonAction(ActionEvent actionEvent) {
        Painting bean = new Painting();

        bean.setTitle(titleTextField.getText());
        bean.setAuthor(authorTextField.getText());
        bean.setHeight(heightTextField.getText());
        bean.setWidth(widthTextField.getText());
        bean.setRadius(radiusTextField.getText());
        bean.setWeight(weightTextField.getText());
        bean.setPrice(priceTextField.getText());
        bean.setCategory(categoryTextField.getText());

        String height = bean.getHeight();
        String width = bean.getWidth();
        String radius = bean.getRadius();

        double heightD = Double.parseDouble(height);
        double widthD = Double.parseDouble(width);
        double radiusD = Double.parseDouble(radius);

        if (bean.getCategory().equals("okrag")) {
            double circleField = Painting.getPI() * radiusD * radiusD;
            String text = String.valueOf(circleField);
            bean.setCircleField(text);
            bean.setNonCircleField(NON_CIRCLE_FIELD_0);
        } else {
            double nonCircleField = heightD * widthD;
            String text1 = String.valueOf(nonCircleField);
            bean.setNonCircleField(text1);
            bean.setCircleField(CIRCLE_FIELD_0);
        }

        this.przejsciowyBeans.remove(this.selectedIndex);
        this.przejsciowyBeans.add(bean);
    }

    public void cancelButtonAction(ActionEvent actionEvent) {
        this.primaryStage.close();
    }
}
