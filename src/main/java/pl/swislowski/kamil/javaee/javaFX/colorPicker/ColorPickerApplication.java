package pl.swislowski.kamil.javaee.javaFX.colorPicker;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class ColorPickerApplication extends Application {

    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 600;

    private static final int IMAGE_WIDTH = 400;
    private static final int IMAGE_HEIGHT = 400;

    private static final int HBOX_ROOT_WIDTH = SCENE_WIDTH / 2;

    private static final int IMAGE_SECTION_WIDTH = 41;
    private static final int IMAGE_SECTION_HEIGHT = 41;

    private static final int IMAGE_START_SECTION_WIDTH = IMAGE_SECTION_WIDTH / 2;
    private static final int IMAGE_START_SECTION_HEIGHT = IMAGE_SECTION_HEIGHT / 2;

    private static final int CROPPED_ELEMENTS_MIN = 0;
    private static final int CROPPED_ELEMENTS_MAX = 25;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AtomicInteger croppedElementsCounter = new AtomicInteger(0); // W lambdzie nie mogliśmy zastosować zwykłej zmiennej, bo do ciała
        // lambdy musimy przekazywać zmienne, które są finalne czyli ich wartość ustawiana jest na początku działania programu, a ja potrzebowałem
        // zmiennej, która będzie zmieniana w trakcie działania programu i umieszczona w lambdzie.
        ObservableList<ImageCropColors> imageCropColorsObservableList = FXCollections.observableArrayList();

        Group root = new Group();
        HBox rootHBox = new HBox();

        final GridPane rootHBoxLeft = new GridPane();
        final StackPane rootHBoxRight = new StackPane();

        rootHBoxLeft.setMinWidth(HBOX_ROOT_WIDTH);
        rootHBoxRight.setMinWidth(HBOX_ROOT_WIDTH);

        rootHBox.getChildren().addAll(rootHBoxLeft, rootHBoxRight);

        FileChooser fileChooser = new FileChooser(); // Daje nam możliwość wyboru obrazka za pomocą okienka systemowego z przeglądaniem
        // folderów i plików.
        fileChooser.setTitle("Wybierz plik");

        ImageView imageView = new ImageView();
        imageView.setFitHeight(IMAGE_HEIGHT);
        imageView.setFitWidth(IMAGE_WIDTH);
        imageView.setPreserveRatio(true);

        imageView.setOnMouseClicked(event -> {
            double eventX = event.getX();
            double eventY = event.getY();

            // W linijcie 90 dopoiero użyłem castowania żeby nie stracić w tym miejscu precyzji. Castuje się na sam koniec przy użyciu zmiennej.
            double startX = eventX - IMAGE_START_SECTION_WIDTH;
            double startY = eventY - IMAGE_START_SECTION_HEIGHT;

            PixelReader pixelReader = imageView.getImage().getPixelReader(); // Potrzebny jest żeby później writerem wyciąć wczytany obszar.

            if (startX > 0 && startY > 0
                    && startX < IMAGE_WIDTH - IMAGE_SECTION_WIDTH
                    && startY < IMAGE_HEIGHT - IMAGE_SECTION_HEIGHT) {   //Zabezpieczenie przed wyjściem poza obszar obrazka.

                // Umożliwia wycięcie zadanego obszaru z głównego obrazka.
                WritableImage writableImage = new WritableImage(pixelReader, (int) startX, (int) startY, IMAGE_SECTION_WIDTH, IMAGE_SECTION_HEIGHT);

                // Używam metody get z Atomic Integer aby pobrać wartość.
                int counterValue = croppedElementsCounter.get();

                if (counterValue < CROPPED_ELEMENTS_MAX) { // Zabezpieczenie przed wstawieniem większej ilości obrazków niż 25.
                    // Wstawianie wyciętego obrazka w konkretne okienka.
                    ImageCropColors imageCropColors = imageCropColorsObservableList.get(counterValue);
                    imageCropColors.getImageView().setImage(writableImage);

                    // Używam tego do pobrania ilości koloru czerwonego dla konkretnego wycinka.
                    PixelReader colorPixelReader = imageCropColors.getImageView().getImage().getPixelReader();

                    //Obliczanie średniej wartości koloru czerwonego.
                    double colorRedAvg = 0.0;
                    //Pobieranie koloru czerwonego piksel po pikselu.
                    for (int x = 0; x < IMAGE_SECTION_WIDTH; x++) {
                        for (int y = 0; y < IMAGE_SECTION_HEIGHT; y++) {
                            Color color = colorPixelReader.getColor(x, y);
                            colorRedAvg += color.getRed();
                        }
                    }
                    // średnia z koloru czerwonego
                    colorRedAvg = IMAGE_SECTION_WIDTH * IMAGE_SECTION_HEIGHT / colorRedAvg;

                    //Ustawienie średniej wartości koloru czerwonego w klasie pomocniczej przechowującej informacje o wycinku.
                    imageCropColors.setRedColor(colorRedAvg);
                    //AtomicInteger zamiast ++ wywołujemy metodę.
                    croppedElementsCounter.incrementAndGet();

                    //Sortowanie po czerwonym kolorze.
                    Collections.sort(imageCropColorsObservableList, new ImageCropColorsRedColorComparator());
                }
            }
        });

        Button loadButton = new Button("Wczytaj");
        loadButton.getStyleClass().add("button");
        loadButton.setOnAction(event -> {
            System.out.println("Loading...");
            File file = fileChooser.showOpenDialog(primaryStage);
            try {
                if (file != null) {
                    // Wczytanie obrazka, tak aby cała zawartość mieściała się w zadanym obszarze.
                    Image image = new Image(new FileInputStream(file), IMAGE_WIDTH, IMAGE_HEIGHT, false, false);
                    imageView.setImage(image);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        VBox imageLeftVBox = new VBox();
        VBox pickedColorsRightVBox = new VBox();
        HBox pickedColorsGroupHBox = new HBox();

        Button eraseButton = new Button("Czyść");
        eraseButton.getStyleClass().add("button");
        eraseButton.setOnAction(event -> {
                    System.out.println("Czyszczę okienka...");

                    Iterator<ImageCropColors> iterator = imageCropColorsObservableList.iterator();
                    while (iterator.hasNext()) {
                        ImageCropColors imageCropColors = iterator.next();
                        imageCropColors.getImageView().setImage(null);
                        imageCropColors.setRedColor(0.0);
                    }

                    // Ponowne sortowanie listy żeby wstawiać obrazki pod właściwymi identyfikatorami.
                    Collections.sort(imageCropColorsObservableList, new ImageCropColorsIdComparator());
                    // Resetowanie licznika(AtomicInteger).
                    croppedElementsCounter.set(CROPPED_ELEMENTS_MIN);
                }
        );

        imageLeftVBox.getChildren().add(imageView);
        pickedColorsRightVBox.getChildren().addAll(loadButton, eraseButton); // TODO: zrobić oddzielnego hboxa i dodać same przyciski.
        pickedColorsRightVBox.setSpacing(10);

        ListView<ImageCropColors> imageCropColorsListView = new ListView<>();

        // Pętla inicjalizująca widok z wycinkami.
        for (int i = 0; i < CROPPED_ELEMENTS_MAX + 1; i++) {

            if (i % 5 == 0) {

                pickedColorsGroupHBox = new HBox();
                pickedColorsGroupHBox.setPadding(new Insets(15, 15, 15, 15));
                pickedColorsGroupHBox.setSpacing(10);

                pickedColorsRightVBox.getChildren().add(pickedColorsGroupHBox);
            }

            if (i < CROPPED_ELEMENTS_MAX) {
                ImageView croppedImageView = new ImageView();

                BorderPane imageViewWrapper = new BorderPane(croppedImageView);
                imageViewWrapper.getStyleClass().add("image-view-wrapper");

                croppedImageView.setFitHeight(IMAGE_SECTION_HEIGHT);
                croppedImageView.setFitWidth(IMAGE_SECTION_WIDTH);
                croppedImageView.setPreserveRatio(true);

                //Użycie klasy pomocniczej.
                ImageCropColors imageCropColors = new ImageCropColors();
                imageCropColors.setImageView(croppedImageView);
                imageCropColors.setId(i);

                imageCropColorsObservableList.add(imageCropColors);

                pickedColorsGroupHBox.getChildren().add(imageViewWrapper);
                //Na liście testowej dodajemy elementy, które będziemy później sortować.
                imageCropColorsListView.setItems(imageCropColorsObservableList);
            }
        }

        pickedColorsRightVBox.getChildren().add(imageCropColorsListView);

        rootHBoxLeft.getChildren().add(imageLeftVBox);
        rootHBoxRight.getChildren().add(pickedColorsRightVBox);

        root.getChildren().add(rootHBox);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.setTitle("ColorPicker");
        scene.getStylesheets().add(ColorPickerApplication.class.getResource("application.css").toExternalForm());
        primaryStage.show();
    }
}
