package gui;
import  javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bane;
import model.Booking;
import model.Spiller;
import storage.Storage;

public class Grænseflade extends Application {

    private static ListView<Bane> baneListView;
    private static ListView<Spiller> spillerListView;
    private static TextArea spillerensBookinger;
    private static ListView<Booking> bookingListView;

    private static TextArea bookingerPåBanen;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Kantinens vagtplanlægning");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label label1 = new Label("Baner");
        pane.add(label1, 0, 0);

        Label label2 = new Label("Spillere");
        pane.add(label2, 1, 0);

        Label label3 = new Label("Spillerens bookinger");
        pane.add(label3, 2, 0);

        Label label4 = new Label("Antal bookinger på banen");
        pane.add(label4,0,1);

        baneListView = new ListView<>();
        baneListView.getItems().addAll(Storage.getBaner());
        pane.add(baneListView, 0, 1);

        if (!baneListView.getItems().isEmpty()) {
            baneListView.getSelectionModel().selectFirst();
        }

        spillerListView = new ListView<>();
        spillerListView.getItems().addAll(Storage.getSpillere());
        pane.add(spillerListView, 1, 1);

        if (!spillerListView.getItems().isEmpty()) {
            spillerListView.getSelectionModel().selectFirst();
        }



        spillerensBookinger = new TextArea();
        spillerensBookinger.setEditable(false);
        spillerensBookinger.setPrefWidth(100);
        spillerensBookinger.setPrefHeight(100);
        pane.add(spillerensBookinger, 2, 1);

        bookingerPåBanen = new TextArea();
        bookingerPåBanen.setEditable(false);
        bookingerPåBanen.setPrefWidth(100);
        bookingerPåBanen.setPrefHeight(100);
        pane.add(bookingerPåBanen, 0, 1);


//        bookingListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, selectedBooking) -> {
//            if (selectedSpiller != null) {
//                spillerensBookinger.setText("Navn: " + selectedBooking.() + "\n"
//                        + "Fra: " + selectedBooking.getNavn() + "\n"
//                        + "Til: " + selectedBooking.getNummer() + "\n"
//                        + "Status: " + selectedBooking.getDato() + "\n"
//
//
//
//            }
//        });
    }
}
