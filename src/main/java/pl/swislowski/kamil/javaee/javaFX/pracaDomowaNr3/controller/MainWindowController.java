package pl.swislowski.kamil.javaee.javaFX.pracaDomowaNr3.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pl.swislowski.kamil.javaee.javaFX.pracaDomowaNr3.model.Person;
import pl.swislowski.kamil.javaee.javaFX.pracaDomowaNr3.model.WorkTimeComparator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;

public class MainWindowController {

    Scanner in = null;
    PrintWriter out = null;

    private Person person = new Person();

    private Main main;
    private Stage primaryStage;

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @FXML
    private Button loadButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button addButton;
    @FXML
    private Button reportButton;
    @FXML
    private Button closeButton;
    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn firstNameColumn;
    @FXML
    private TableColumn lastNameColumn;
    @FXML
    private TableColumn roomNumberColumn;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField workStartHourTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField workEndHourTextField;
    @FXML
    private TextField roomNumberTextField;

    public void setMain(Main main) {
        this.main = main;
        setTable();
        tableView.setItems(personList);
    }

    @FXML
    private void loadFile() {

        tableView.getItems().clear();

        try {
            in = new Scanner(Paths.get("/users/kamil/fileIO/pracownicyInfile.txt"));

            while (in.hasNext()) {
                person.setFirstName(in.next());
                person.setLastName(in.next());
                person.setRoomNumber(in.next());
                person.setWorkStartHour(in.next());
                person.setWorkEndHour(in.next());

                personList.add(new Person(person.getFirstName(), person.getLastName(), person.getRoomNumber(),
                        person.getWorkStartHour(), person.getWorkEndHour()));

//                System.out.printf("Wczytano dane -> imię: %-12s, nazwisko: %-12s, numer pokoju:%03d, " +
//                                "godzina rozpoczęcia pracy:%03d, godzina zakończenia pracy:%03d\n", person.getFirstName(),
//                        person.getLastName(), person.getRoomNumber(), person.getWorkStartHour(), person.getWorkEndHour());


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) in.close();
        }

        firstNameColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));
        roomNumberColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("roomNumber"));


    }

    @FXML
    public void saveFile() {
        try {
            out = new PrintWriter("/users/kamil/fileIO/pracownicyInfile.txt");

            for (int i = 0; i < personList.size(); i++) {
                out.printf("%s %s %s %s %s" + "%n",
                        personList.get(i).getFirstName(),
                        personList.get(i).getLastName(),
                        personList.get(i).getRoomNumber(),
                        personList.get(i).getWorkStartHour(),
                        personList.get(i).getWorkEndHour()

                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) out.close();
        }

        System.out.println("Zapisuję plik...");
    }

    @FXML
    public void addPerson() {

        Person person = new Person();

        person.setFirstName(firstNameTextField.getText());
        person.setLastName(lastNameTextField.getText());
        person.setRoomNumber(roomNumberTextField.getText());
        person.setWorkStartHour(workStartHourTextField.getText());
        person.setWorkEndHour(workEndHourTextField.getText());

        personList.add(person);
    }

    @FXML
    public void report() {

        Collections.sort(personList, new WorkTimeComparator());

        try {
            out = new PrintWriter("/users/kamil/fileIO/pracownicyInfileRaport.txt");


            for (int i = 0; i < personList.size(); i++) {
                out.printf("%s %s %s %s %s" + "%n",
                        personList.get(i).getFirstName(),
                        personList.get(i).getLastName(),
                        personList.get(i).getRoomNumber(),
                        personList.get(i).getWorkStartHour(),
                        personList.get(i).getWorkEndHour()

                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) out.close();
        }

        System.out.println("Sporządzam raport i zapisuję plik...");
    }

    public void initialize() {
        tableView.getSelectionModel().selectedItemProperty().addListener(
                (ov, oldVal, newVal) ->
                {
                    if (newVal != null) {
                        firstNameTextField.setText(newVal.getFirstName());
                        workStartHourTextField.setText(newVal.getWorkStartHour());
                        lastNameTextField.setText(newVal.getLastName());
                        workEndHourTextField.setText(newVal.getWorkEndHour());
                        roomNumberTextField.setText(newVal.getRoomNumber());

                    }
                    System.out.println(
                            newVal.getFirstName() + " " +
                                    newVal.getLastName()
                    );
                }
        );
    }

    private void setTable() {
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    public void closeStage() {
        primaryStage.close();
    }


}
