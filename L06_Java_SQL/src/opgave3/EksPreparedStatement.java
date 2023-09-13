package opgave3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.SortedMap;

public class EksPreparedStatement {

	public static void main(String[] args) {

		try {
			System.out.println("indtast navn på medarbejder");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			String navn = inLine.readLine();

			Connection minConnection;
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost;databaseName=tidsregistrering;user=sa;password=someThingComplicated1234");


			String sql = "SELECT mobil FROM Medarbejder WHERE navn = ?";// preparedStatement
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.setString(1,navn);

			ResultSet result = prestmt.executeQuery();

			if (result.next()){
				String telefonnummer = result.getString("mobil");
				System.out.println("Telefonnummer for" + navn + " : " + telefonnummer);
			} else {
				System.out.println("Nej");
			}
			if (result !=null)
				result.close();
			if (prestmt != null)
				prestmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
