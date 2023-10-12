package gui;


import javafx.application.Application;
import controller.Controller;

public class App {
    public static void main(String[] args) {
        Controller.initStorage();
        Application.launch(Grænseflade.class);
    }
}



