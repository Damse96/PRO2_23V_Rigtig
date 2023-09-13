package opgave3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectMedlemmer {
	
	public static void main(String[] args) {

		try {
			Connection minConnection;
			minConnection = DriverManager
					.getConnection("jdbc:sqlserver://localhost;databaseName=tidsregistrering;user=sa;password=someThingComplicated1234");

			Statement stmt = minConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet res = stmt.executeQuery("select * from Medarbejder");
			while (res.next()) {
				System.out.println(res.getString(2) + "\t" + res.getString(4) );
			}

			if (res != null)
				res.close();
			if (stmt != null)
				stmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}
}
