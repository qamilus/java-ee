package pl.swislowski.kamil.javaee.javaFX.colorPicker;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ColorPickerApplication extends Application {

    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 600;

    private static final int IMAGE_WIDTH = 400;
    private static final int IMAGE_HEIGHT = 400;

    private static final int HBOX_ROOT_WIDTH = SCENE_WIDTH / 2;
    private static final int HBOX_ROOT_HEIGHT = SCENE_HEIGHT;

    private static final int IMAGE_SECTION_WIDTH = 41;
    private static final int IMAGE_SECTION_HEIGHT = 41;

    private static final int IMAGE_START_SECTION_WIDTH = IMAGE_SECTION_WIDTH / 2;
    private static final int IMAGE_START_SECTION_HEIGHT = IMAGE_SECTION_HEIGHT / 2;

    private static final int CROPPED_ELEMENTS_MAX = 25;

    private ObservableList<ImageCropColors> imageCropColorsObservableList = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        AtomicInteger croppedElementsCounter = new AtomicInteger(0);
        Map<Integer, ImageCropColors> imageCropColorsMap = new HashMap<>();
//        List<ImageCropColors> imageCropColorsList = new ArrayList<>();

        ObservableList<ImageCropColors> imageCropColorsList = FXCollections.observableArrayList();
//        Collections.sort(imageCropColorsMap);

//        StackPane root = new StackPane();

        Group root = new Group();
        HBox rootHBox = new HBox();

        final GridPane rootHBoxLeft = new GridPane();
        final StackPane rootHBoxRight = new StackPane();

        rootHBoxLeft.setMinWidth(HBOX_ROOT_WIDTH);
        rootHBoxRight.setMinWidth(HBOX_ROOT_WIDTH);

        rootHBox.getChildren().addAll(rootHBoxLeft, rootHBoxRight);


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Wybierz plik");

        ImageView[] imageViews = new ImageView[CROPPED_ELEMENTS_MAX];

        ObservableList<ImageView> imageViewsObservableList = FXCollections.observableArrayList();

        ImageView imageView = new ImageView();
        imageView.setFitHeight(IMAGE_HEIGHT);
        imageView.setFitWidth(IMAGE_WIDTH);
        imageView.setPreserveRatio(true);
        imageView.getStyleClass().add("image-view");

        imageView.setOnMouseClicked(event -> {
            double eventX = event.getX();
            double eventY = event.getY();

            double startX = eventX - IMAGE_START_SECTION_WIDTH;
            double startY = eventY - IMAGE_START_SECTION_HEIGHT;
            PixelReader pixelReader = imageView.getImage().getPixelReader();

            if (startX > 0 && startY > 0) {

                WritableImage writableImage = new WritableImage(pixelReader, (int) startX, (int) startY, IMAGE_SECTION_WIDTH, IMAGE_SECTION_HEIGHT);

                int counterValue = croppedElementsCounter.get();
                if (counterValue < CROPPED_ELEMENTS_MAX) {
//                    imageViews[counterValue].setImage(writableImage);
                    imageCropColorsList.get(counterValue).getImageView().setImage(writableImage);

//                    PixelReader colorPixelReader = imageViews[counterValue].getImage().getPixelReader();
                    PixelReader colorPixelReader = imageCropColorsList.get(counterValue).getImageView().getImage().getPixelReader();

                    double colorRedAvg = 0.0;
                    for (int x = 0; x < IMAGE_SECTION_WIDTH; x++) {
                        for (int y = 0; y < IMAGE_SECTION_HEIGHT; y++) {
                            Color color = colorPixelReader.getColor(x, y);
                            colorRedAvg += color.getRed();
                        }
                    }
                    colorRedAvg = IMAGE_SECTION_WIDTH * IMAGE_SECTION_HEIGHT / colorRedAvg;

                    System.out.println("colorRedAvg: " + colorRedAvg);

//                    imageCropColorsMap.get(counterValue).setRedColor(colorRedAvg);
                    imageCropColorsList.get(counterValue).setRedColor(colorRedAvg);
                    croppedElementsCounter.incrementAndGet();

                    Collections.sort(imageCropColorsList);
                    imageCropColorsList.sorted(new ImageCropColorsComparator());
                }

                System.out.println("imageCropColorsMap: " + imageCropColorsMap.size());
            }
        });

        Button loadButton = new Button("Wczytaj");
        loadButton.getStyleClass().add("button");
        loadButton.setOnAction(event -> {
            System.out.println("Loading...");
            File file = fileChooser.showOpenDialog(primaryStage);
            try {
                if (file != null) {
                    Image image = new Image(new FileInputStream(file), IMAGE_WIDTH, IMAGE_HEIGHT, false, false);
//                    Image image = new Image(new FileInputStream(file));
                    imageView.setImage(image);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        Button eraseButton = new Button("Czyść");
        eraseButton.getStyleClass().add("button");
        eraseButton.setOnAction(event ->
                System.out.println("Czyszczę okienka...")
        );

        VBox imageLeftVBox = new VBox();
        VBox pickedColorsRightVBox = new VBox();

        HBox pickedColorsGroupHBox = new HBox();

        imageLeftVBox.getChildren().add(imageView);
        pickedColorsRightVBox.getChildren().addAll(loadButton, eraseButton); // TODO: zrobić oddzielnego hboxa i dodać same przyciski.
        pickedColorsRightVBox.setSpacing(10);

        int imageViewsLength = imageViews.length;

        TableView<ImageCropColors> imageCropColorsTableView = new TableView<>();

        ListView<ImageCropColors> imageCropColorsListView = new ListView<>();

        for (int i = 0; i < imageViewsLength + 1; i++) {

            if (i % 5 == 0) {
                System.out.println("pickedColorsRightVBox");
                pickedColorsRightVBox.getChildren().add(pickedColorsGroupHBox);

                pickedColorsGroupHBox = new HBox();
                pickedColorsGroupHBox.setPadding(new Insets(15, 15, 15, 15));
                pickedColorsGroupHBox.setSpacing(10);
            }

            if (i < imageViewsLength) {

                imageViews[i] = new ImageView();

//                BorderPane imageViewWrapper = new BorderPane(imageViews[i]);
//                imageViewWrapper.getStyleClass().add("image-view-wrapper");

                imageViews[i].setFitHeight(IMAGE_SECTION_HEIGHT);
                imageViews[i].setFitWidth(IMAGE_SECTION_WIDTH);
                imageViews[i].setPreserveRatio(true);

                ImageCropColors imageCropColors = new ImageCropColors();
                imageCropColors.setImageView(imageViews[i]);
                imageCropColors.setId(i);
                imageCropColorsMap.put(i, imageCropColors);

                imageCropColorsList.add(imageCropColors);
                imageCropColorsObservableList.add(imageCropColors);
                imageViewsObservableList.add(imageView);

                pickedColorsGroupHBox.getChildren().add(imageCropColors.getImageView());
//                pickedColorsGroupHBox.getChildren().add(imageViewWrapper);
//                pickedColorsGroupHBox.getChildren().add(imageViews[i]);
                imageCropColorsListView.setItems(imageCropColorsList);
            }

        }

        pickedColorsRightVBox.getChildren().add(imageCropColorsListView);

        rootHBoxLeft.getChildren().add(imageLeftVBox);
        rootHBoxRight.getChildren().add(pickedColorsRightVBox);

        root.getChildren().add(rootHBox);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.setTitle("ColorPicker");
//        scene.getStylesheets().add(ColorPickerApplication.class.getResource("pl/swislowski/kamil/javaee/javaFX/colorPicker/application.css").toExternalForm());
        primaryStage.show();

    }

    private static void fillPickedColorsElements(
//            int croppedElementsSize, HBox colorsGroup,
//                                                 VBox colors
    ) {


    }
}
