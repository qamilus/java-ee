package pl.swislowski.kamil.javaee.przejsciowy.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pl.swislowski.kamil.projekt.przejsciowy.model.FieldAuthorComparator;
import pl.swislowski.kamil.projekt.przejsciowy.model.FieldPriceComparator;
import pl.swislowski.kamil.projekt.przejsciowy.model.FieldTitleComparator;
import pl.swislowski.kamil.projekt.przejsciowy.model.Painting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;

public class ListPaintingsAuctionWindowController {

    private static final String FILE_PATH = "/users/kamil/fileIO/";
    private static final String FILE_OUTPUT_TXT = "file-output.txt";

    private Stage primaryStage;

    private ObservableList<Painting> paintings = FXCollections.observableArrayList();

    @FXML
    private TableView<Painting> tableView;
    @FXML
    private TableColumn titleColumn;
    @FXML
    private TableColumn authorColumn;
    @FXML
    private TableColumn heightColumn;
    @FXML
    private TableColumn widthColumn;
    @FXML
    private TableColumn radiusColumn;
    @FXML
    private TableColumn nonCircleFieldColumn;
    @FXML
    private TableColumn circleFieldColumn;
    @FXML
    private TableColumn weightColumn;
    @FXML
    private TableColumn priceColumn;
    @FXML
    private TableColumn categoryColumn;
    @FXML
    private ToggleButton sortAZToggleButton;
    @FXML
    private ToggleButton sortPriceToggleButton;
    @FXML
    private ToggleButton sortAuthorToggleButton;
//
//    @FXML
//    private Button addButton;

    public void initialize() {          //automatycznie wywoywana po zainicjowaniu kontrolera

        titleColumn.setCellValueFactory(
                new PropertyValueFactory<Painting, String>("title"));
        authorColumn.setCellValueFactory(
                new PropertyValueFactory<Painting, String>("author"));
        heightColumn.setCellValueFactory(
                new PropertyValueFactory<Painting, String>("height"));
        widthColumn.setCellValueFactory(
                new PropertyValueFactory<Painting, String>("width"));
        radiusColumn.setCellValueFactory(
                new PropertyValueFactory<Painting, String>("radius"));
        nonCircleFieldColumn.setCellValueFactory(
                new PropertyValueFactory<Painting, String>("nonCircleField"));
        circleFieldColumn.setCellValueFactory(
                new PropertyValueFactory<Painting, String>("circleField"));
        weightColumn.setCellValueFactory(
                new PropertyValueFactory<Painting, String>("weight"));
        priceColumn.setCellValueFactory(
                new PropertyValueFactory<Painting, String>("price"));
        categoryColumn.setCellValueFactory(
                new PropertyValueFactory<Painting, String>("category"));

        setTable();
    }

    private void setTable() {
//        paintings.add(new PrzejsciowyBean("22", "Tomasz", "Majewski", "black"));
//        paintings.add(new PrzejsciowyBean("33", "Stefan", "Zakowski", "black"));
//        paintings.add(new PrzejsciowyBean("44", "Piotr", "Gajewski", "black"));
//        paintings.add(new PrzejsciowyBean("55", "Adrian", "Muchowski", "black"));

        tableView.setItems(paintings);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void addButtonAction(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(ListPaintingsAuctionWindowController.class.getResource("../view/CreatePaintingsAuctionWindowView.fxml"));

        try {
            Stage stage = PaintingsAuctionUtilsWindowController.createStage(loader, primaryStage, "Dodaj Przejsciowy");

            CreatePaintingsAuctionWindowController controller = loader.getController();
            controller.setPrimaryStage(stage);
            controller.setPrzejsciowyBeans(paintings);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancelButtonAction(ActionEvent actionEvent) {
        primaryStage.close();
    }

    public void deleteButtonAction(ActionEvent actionEvent) {
        Painting selectedItem = this.tableView.getSelectionModel().getSelectedItem();
        this.paintings.remove(selectedItem);
    }

    public void editButtonAction(ActionEvent actionEvent) {

        FXMLLoader loader = new FXMLLoader(ListPaintingsAuctionWindowController.class.getResource("../view/UpdatePaintingsAuctionView.fxml"));

        try {
            Stage stage = PaintingsAuctionUtilsWindowController.createStage(loader, primaryStage, "Edytuj Przejsciowy");

            UpdatePaintingsAuctionWindowController controller = loader.getController();
            controller.setPrimaryStage(stage);
            controller.setPrzejsciowyBeans(paintings);
            controller.setSelectedIndex(tableView.getSelectionModel().getSelectedIndex());
            controller.populateData();

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFileButtonAction(ActionEvent actionEvent) {

        tableView.getItems().clear();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Wybierz plik");

        File file = fileChooser.showOpenDialog(primaryStage);

        Painting bean;

        try (Scanner in = new Scanner(new FileInputStream(file))) {

            while (in.hasNext()) {
                bean = new Painting();

                bean.setTitle(in.next());
                bean.setAuthor(in.next());
                bean.setHeight(in.next());
                bean.setWidth(in.next());
                bean.setRadius(in.next());
                bean.setNonCircleField(in.next());
                bean.setCircleField(in.next());
                bean.setWeight(in.next());
                bean.setPrice(in.next());
                bean.setCategory(in.next());

                paintings.add(bean);

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
                } else {
                    double nonCircleField = heightD * widthD;
                    String text1 = String.valueOf(nonCircleField);
                    bean.setNonCircleField(text1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveFileButtonAction(ActionEvent actionEvent) {
//        Collections.sort(paintings, new FieldPriceComparator());
//        Collections.sort(paintings, new FieldTitleComparator());

        try (PrintWriter out = new PrintWriter(FILE_PATH + FILE_OUTPUT_TXT)) {

            if (sortAZToggleButton.isSelected()) {
                Collections.sort(paintings, new FieldTitleComparator());
            } else if (sortAuthorToggleButton.isSelected()) {
                Collections.sort(paintings, new FieldAuthorComparator());
            } else if (sortPriceToggleButton.isSelected()) {
                Collections.sort(paintings, new FieldPriceComparator());
            } else {
                Alert alertToggleGroup = new Alert(Alert.AlertType.WARNING, "Plik został zapisany bez użycia metody sortującej.", ButtonType.OK);
                alertToggleGroup.show();
            }


            for (int i = 0; i < paintings.size(); i++) {
                out.printf("%s %s %s %s %s %s %s %s %s %s %n",
                        paintings.get(i).getTitle(),
                        paintings.get(i).getAuthor(),
                        paintings.get(i).getHeight(),
                        paintings.get(i).getWidth(),
                        paintings.get(i).getRadius(),
                        paintings.get(i).getNonCircleField(),
                        paintings.get(i).getCircleField(),
                        paintings.get(i).getWeight(),
                        paintings.get(i).getPrice(),
                        paintings.get(i).getCategory()
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
