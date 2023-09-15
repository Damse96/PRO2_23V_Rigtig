package opgave5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Opgave5 {
	public static void main(String[] args) {

		try {

			System.out.println("Opret Tidsregistrering: ");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Intast StartTid: ");
			String startTid = inLine.readLine();
			System.out.println("Indtast SlutTid: ");
			String slutTid = inLine.readLine();
			System.out.println("Indtast Bekskrivelse: ");
			String Beskrivelse = inLine.readLine();
			System.out.println("Indtast Dato: ");
			String Dato = inLine.readLine();
			System.out.println("Indtast MedbejderNr: ");
			String medarbejderID = inLine.readLine();
			System.out.print("Indtast OpgaveNr : ");
			String OpgaveNr= inLine.readLine();




			Connection minConnection;
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost;databaseName=Tidsregistrering;user=sa;password=someThingComplicated1234;");

			String sql = "insert into tidsregistrering values(?,?,?,?,?,?) ";// preparedStatement
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			prestmt.setTime(1, Time.valueOf(startTid));
			prestmt.setTime(2, Time.valueOf(slutTid));
			prestmt.setString(3, Beskrivelse);
			prestmt.setDate(4, Date.valueOf(Dato));
			prestmt.setInt(5, Integer.parseInt(medarbejderID.trim()));
			prestmt.setInt(6, Integer.parseInt(OpgaveNr.trim()));


			prestmt.executeUpdate();
			Statement stmt = minConnection.createStatement();

			prestmt.executeUpdate();
			System.out.println("Tidsregistrering indsat");


			if (prestmt != null)
				prestmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}
}

