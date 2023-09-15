package Sql;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class NytHold {

    public static void main(String[] args) {

        try {

            System.out.println("Opret Hold: ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Intast Holdid: ");
            String holdid = inLine.readLine();
            System.out.println("Indtast Holdnavn: ");
            String holdnavn = inLine.readLine();
            System.out.println("Indtast antal: ");
            String antal = inLine.readLine();
            System.out.println("Indtast KlubId: ");
            String klubid = inLine.readLine();


            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=klubEksempel;user=sa;password=someThingComplicated1234;");

            String sql = "insert into Hold values(?,?,?,?) ";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setInt(1, Integer.parseInt(holdid.trim()));
            prestmt.setString(2, holdnavn);
            prestmt.setInt(3, Integer.parseInt(antal.trim()));
            prestmt.setString(4, klubid);


            prestmt.executeUpdate();
            Statement stmt = minConnection.createStatement();

            prestmt.executeUpdate();
            System.out.println("Nyt hold oprettet indsat");

            if (prestmt != null)
                prestmt.close();
            if (minConnection != null)
                minConnection.close();
        } catch (SQLException e) {
            //System.out.println("fejl: " + e.getMessage());
            //System.out.println("fejl: " + e.getErrorCode());
            if (e.getErrorCode() == 51000) {
                if (e.getMessage().contains("checkConst")) {
                    System.out.println("Antal skal være under 15");
                }
                if (e.getMessage().contains("klubForeign")) {
                    System.out.println("klubid er ugyldigt");
                }
            }

        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}


