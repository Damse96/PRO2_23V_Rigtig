package Sql;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EksPreparedStatement {

    public static void main(String[] args) {

        try {
            System.out.println("Opret Hold ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Indtast medlemsID: ");
            String medId = inLine.readLine();
            System.out.println("Intast navn: ");
            String navn = inLine.readLine();
            System.out.println("Indtast alder: ");
            String alder = inLine.readLine();

            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=klubEksempel;user=sa;password=someThingComplicated1234");

            String sql = "insert into Medlem values(?,?,?) ";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setInt(1, Integer.parseInt(medId.trim()));
            prestmt.setString(2, navn);
            prestmt.setInt(3, Integer.parseInt(alder.trim()));

            prestmt.executeUpdate();
            System.out.println("Medlem indsat");

            if (prestmt != null)
                prestmt.close();
            if (minConnection != null)
                minConnection.close();
        } catch (SQLException e) {
            System.out.println("fejl: " + e.getMessage());
            System.out.println("fejl: " + e.getErrorCode());
            if (e.getErrorCode() == 8152) {
                System.out.println("Dit navn er for langt");
            }

        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }

}
