import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;

public class JDBCExample
{
	public static void main(String[] args) 
	{

		//Postgres-JDBC Connectivity
		System.out.println("\n-------- PostgreSQL " + "JDBC Connection ------------");
		try 
		{
			Class.forName("org.postgresql.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return;
		}
		System.out.println("\nPostgreSQL JDBC Driver Registered!");
		Connection connection = null;
		try 
		{
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/HospitalBilling", "postgres", "postgres");
			if(connection != null) 
			{
				System.out.println("You made it, take control of your database now!\nDatabase Connected!");
			} 
			else 
			{
				System.out.println("Failed to make connection!");
			}
		} 
		catch(SQLException e) 
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		try
		{
			//Displaying data from table
			Statement statement = connection.createStatement();
			ResultSet rs;
			/*rs=statement.executeQuery("SELECT patient_id,patient_fname,patient_lname,health_rating,patient_acc_no FROM patient ORDER by patient_id");
			System.out.println("\nPATIENT TABLE:");
			while(rs.next())
			{
    			String outputString = String.format("(%s,%s, %s, %s,%s,%s,%s,%s,%s)",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				System.out.println(outputString);
			}*/

                              	    	rs=statement.executeQuery("SELECT * FROM patient_account order by account_no");
			System.out.println("\nPATIENT ACCOUNT TABLE:");
			while(rs.next())
			{
    			String outputString = String.format("(%s, %s, %s)",rs.getInt(1),rs.getInt(2),rs.getInt(3));
				System.out.println(outputString);
			}

			rs=statement.executeQuery("SELECT patient_id,patient_fname,patient_lname,health_rating,patient_acc_no FROM patient ORDER by patient_id");
			System.out.println("\nPATIENT TABLE:");
			while(rs.next())
			{
    			String outputString = String.format("(%s,%s, %s, %s,%s)",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				System.out.println(outputString);
			}

			rs=statement.executeQuery("SELECT * FROM patient_bill order by bill_no");
			System.out.println("\nPATIENT BILL TABLE:");
			while(rs.next())
			{
    			String outputString = String.format("(%s, %s, %s,%s)",rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
				System.out.println(outputString);
			}

			//Creating table
			/*statement.execute("CREATE TABLE Doctor(doctor_id INTEGER, name VARCHAR(50), dept_name VARCHAR(50), PRIMARY KEY(doctor_id));");
			System.out.println("\nDoctor Table Created.");*/

			//Inserting data into table

 			statement.execute("INSERT INTO patient_account VALUES (631,20000,45),(503,34000,80)");
			System.out.println("\nInsertion of data is completed.");
		 	rs=statement.executeQuery("SELECT * FROM patient_account order by account_no;");
			System.out.println("\nPATIENT  ACCOUNT TABLE:");
			while(rs.next())
			{
				String outputString = String.format("(%s, %s, %s)",rs.getInt(1),rs.getInt(2),rs.getInt(3));
				System.out.println(outputString);
			}

			/*statement.execute("INSERT INTO patient (patient_fname,patient_lname,birth_date,patient_acc_no,medical_history,drug _history,health_rating,phone_no) VALUES ('Sayali','Khot','11/08/1999',999,'Asthama','Salbutamol',7,2384398390),('Niyati','Merwana','12/01/1998',777,'Hypertension','Hexamethonium',8,8268372966)");
			System.out.println("\nInsertion of data is completed.");
		 	rs=statement.executeQuery("SELECT * FROM patient");
			System.out.println("\nPATIENT TABLE:");
			while(rs.next())
			{
				String outputString = String.format("(%s, %s, %s,%s,%s,%s,%s,%s)",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
				System.out.println(outputString);
			}*/
			
			//Updating data in table ist query
			/*System.out.println();
			System.out.println("PHYSICIAN TABLE BEFORE UPDATION");
			rs=statement.executeQuery("SELECT * FROM physician order by phys_id");
			while(rs.next())
			{
				String outputString = String.format("(%s, %s, %s,%s,%s)",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				System.out.println(outputString);
			}
			
			statement.execute("UPDATE physician SET salary=80000 WHERE pname='Dharmish Bhatt';");
			System.out.println("\nTable Value Updated.");
			rs=statement.executeQuery("SELECT * FROM physician order by phys_id");

			System.out.println("\nUPDATED PHYSICIAN TABLE:");
			while(rs.next())
			{
				String outputString = String.format("(%s, %s, %s,%s,%s)",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				System.out.println(outputString);
			}*/

                                                     //Update second query
			/*System.out.println("PATIENT TABLE BEFORE UPDATION");
			rs=statement.executeQuery("SELECT * FROM patient order by patient_id");
			while(rs.next())
			{
				String outputString = String.format("(%s,%s, %s, %s,%s,%s,%s,%s,%s)",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9));
				System.out.println(outputString);
			}
			

			 statement.execute("UPDATE patient SET health_rating=9 WHERE patient_fname='Sayali';");
			System.out.println("\nTable Value Updated.");
			rs=statement.executeQuery("SELECT * FROM patient order by patient_id");
			System.out.println("\nUPDATED PATIENT TABLE:");
			while(rs.next())
			{
				String outputString = String.format("(%s,%s, %s, %s,%s,%s,%s,%s,%s)",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9));
				System.out.println(outputString);
			}
			*/
 			
			//third update
			/*System.out.println();
			System.out.println("PATIENT BILL TABLE BEFORE UPDATION");
			rs=statement.executeQuery("SELECT * FROM patient_bill order by bill_no");
			while(rs.next())
			{
				String outputString = String.format("(%s, %s, %s,%s)",rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
				System.out.println(outputString);
			}
			
			statement.execute("UPDATE patient_bill  SET bill_amt=54000 WHERE room_no=34;");
			System.out.println("\nTable Value Updated.");
			rs=statement.executeQuery("SELECT * FROM patient_bill order by bill_no");

			System.out.println("\nUPDATED PATIENT BILL TABLE:");
			while(rs.next())
			{
				String outputString = String.format("(%s, %s, %s,%s)",rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
				System.out.println(outputString);
			}*/

			//Update 	Working query
			System.out.println();
			System.out.println("PATIENT ACCOUNT TABLE BEFORE UPDATION");
			rs=statement.executeQuery("SELECT * FROM patient_account order by account_no");
			while(rs.next())
			{
				String outputString = String.format("(%s, %s, %s)",rs.getInt(1),rs.getInt(2),rs.getInt(3));
				System.out.println(outputString);
			}
			
			statement.execute("UPDATE patient_account SET duration_of_treatment=10 WHERE account_balance=5000;");
			System.out.println("\nTable Value Updated.");
			rs=statement.executeQuery("SELECT * FROM patient_account order by account_no");

			System.out.println("\nUPDATED PATEINT ACCOUNT TABLE:");
			while(rs.next())
			{
				String outputString = String.format("(%s, %s, %s)",rs.getInt(1),rs.getInt(2),rs.getInt(3));
				System.out.println(outputString);
			}


			//Deleting data from table
			  statement.execute("delete from physician where phys_id=17");
			System.out.println("\nENTRY DELETED FROM PHYSICIAN TABLE.");
			rs=statement.executeQuery("SELECT * FROM physician order by phys_id");
			System.out.println("\nNEW PHYSICIAN TABLE:");
			while(rs.next())
			{
				String outputString = String.format("(%s, %s, %s,%s,%s)",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				System.out.println(outputString);
			}
			
			//Dropping table
			statement.execute("DROP TABLE receptionist");
			System.out.println("\nReceptionist table deleted.");
		}
		catch(SQLException e)
		{
			System.out.println("Encountered an error when executing given sql statement.");
		}
	}
}
