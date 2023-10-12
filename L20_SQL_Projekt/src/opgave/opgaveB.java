package opgave;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class opgaveB {
    public static void main(String[] args) {
        try {
            Connection forbindelse;
            forbindelse = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=projektDAOS;user=sa;password=someThingComplicated1234;");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Indtast afholdelse_id (fx A5): ");
            String afholdelse_id = scanner.nextLine();

            System.out.println("Indtast termin (fx V2023): ");
            String termin = scanner.nextLine();

            System.out.println("Indtast startDato (yyyy-mm-dd): ");
            String startDato = scanner.nextLine();

            System.out.println("Indtast slutDato (yyyy-mm-dd) skal vaere samme dato eller dage efter start dato: ");
            String slutDato = scanner.nextLine();

            System.out.println("Indtast EksamensID (fx EX2): ");
            String EksamensID = scanner.nextLine();


            String sql = "INSERT INTO afholdelse (afholdelse_id, termin, start_dato, slut_dato, eksamen_id) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = forbindelse.prepareStatement(sql);
            preparedStatement.setString(1, afholdelse_id);
            preparedStatement.setString(2, termin);
            preparedStatement.setString(3, startDato);
            preparedStatement.setString(4, slutDato);
            preparedStatement.setString(5, EksamensID);


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Eksamensafvikling oprettet med succes!");
            } else {
                System.out.println("Fejl ved oprettelse af eksamensafvikling.");
            }

            forbindelse.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            if (e.getErrorCode() == 2627) {
                if (e.getMessage().contains("afholdelse_id"))
                    System.out.println("afholdelse_id findes allerede");
            }
            if (e.getErrorCode() == 2628) {
                if (e.getMessage().contains("termin")) {

                    System.out.println("termin er for lang");
                }
                if (e.getErrorCode() == 241) {
                    if (e.getMessage().contains("start_dato")) {
                        System.out.println("start_dato er formateret forkert");
                    }
                }
                if (e.getErrorCode() == 241) {
                    if (e.getMessage().contains("slut_dato")) {
                        System.out.println("slut_dato er formateret forkert");
                    }
                }
                if (e.getErrorCode() == 547) {
                    if (e.getMessage().contains("eks_id")) {
                        System.out.println("eksamen_id findes ikke");
                    }
                }
            }
        }
    }
}
