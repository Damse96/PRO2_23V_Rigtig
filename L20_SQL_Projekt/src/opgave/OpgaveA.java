package opgave;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class OpgaveA {
    public static void main(String[] args) {
        try {
            Connection forbindelse;
            forbindelse = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;SQLExpress;databaseName=projektDAOS;user=sa;password=someThingComplicated1234;");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Indtast eksamen_id: ");
            String eksamenId = scanner.nextLine();

            System.out.println("Indtast student_id: ");
            int studentId = scanner.nextInt();

            System.out.println("Indtast karakter: ");
            int karakter = scanner.nextInt();

            System.out.println("Indtast administrativ bedømmelse (eller tryk Enter for at indtaste null): ");
            String adminBedoemmelse = scanner.nextLine();
            if (adminBedoemmelse.isEmpty()) {
                adminBedoemmelse = null;
            }

            String sql = "INSERT INTO forsoeg (admin_bedoemmelse, karakter, afholdelse_id, student_id) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = forbindelse.prepareStatement(sql);
            preparedStatement.setString(1, adminBedoemmelse);
            preparedStatement.setInt(2, karakter);
            preparedStatement.setString(3, eksamenId);
            preparedStatement.setInt(4, studentId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Eksamensforsøg oprettet med succes!");
            } else {
                System.out.println("Fejl ved oprettelse af eksamensforsøg.");
            }

            forbindelse.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
