package opgave;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class opgaveB {
    public static void main(String[] args) {
        try {
            Connection forbindelse;
            forbindelse = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;SQLExpress;databaseName=projektDAOS;user=sa;password=someThingComplicated1234;");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Indtast afholdelse_id: ");
            String afholdelse_id = scanner.nextLine();

            System.out.println("Indtast termin: ");
            String termin = scanner.nextLine();

            System.out.println("Indtast startDato: ");
            String startDato = scanner.nextLine();

            System.out.println("Indtast slutDato: ");
            String slutDato = scanner.nextLine();

            System.out.println("Indtast EksamensID: ");
            String EksamensID = scanner.nextLine();



            String sql = "INSERT INTO afholdelse (afholdelse_id, termin, startDato, slutDato, EksamensID) VALUES (?, ?, ?, ?)";

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
            e.printStackTrace();
        }

    }
}


