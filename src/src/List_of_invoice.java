package src;

import java.sql.*;

public class List_of_invoice extends Menu_Item{
//  Constructor    ********************************************************************************************	
	List_of_invoice(){
        this.item_name="Report: All Invoices ";
    }
//  Action Method   *******************************************************************************************		
	void item_action() {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName = myDB;" +
                "encrypt = true;" +"trustServerCertificate = true";
        String user = "sa";
        String pass = "root";
        Connection con = null;
		try {
			if(Load_Data.invoiceList.isEmpty()) {
				System.out.println("No Invoice In The List.");
			}
			else {
				if(Invoice_header.telephone==0) {
					try {
		                Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		                DriverManager.registerDriver(driver);
		                con = DriverManager.getConnection(url, user, pass);
		                Statement st = con.createStatement();
		                String sql1 = "Select * from Invoice";
		                ResultSet resultSet = st.executeQuery(sql1);

		                while (resultSet.next()) {
		                	System.out.println("__________________________________________________________ ");
		                	System.out.printf("%5s %10s %5s %10s","Telphone: ",77889911,"   Email:   ","Shop@gmail.com");
		                	System.out.println();
		                	System.out.printf("%5s %10s %5s %10s","Fax:      ",336,     "   Website: ","https://shop.home.com");
		                	System.out.println();
		                	System.out.println("---------------------------------------------------------- ");
		                	System.out.printf("%5s %1s %5s %5s %10s","Invoice Id: ",resultSet.getString("id")," ","Invoice Date: ",resultSet.getString("invoice_date"));
		                	System.out.println();
		                	System.out.println("---------------------------------------------------------- ");
		                	System.out.print("Customer Name:     ");
		                    System.out.println(resultSet.getString("customer_name"));
		                    System.out.print("Number Of Items:   ");
		                    System.out.println(resultSet.getString("no_of_items"));
		                    System.out.print("Total Amount:      ");
		                    System.out.println(resultSet.getString("total_amount"));
		                    System.out.print("Balance:           ");
		                    System.out.println(resultSet.getString("balance"));
		                    System.out.println("_________________________________________________________ ");
		                }
		            } catch (Exception ex) {
		                System.err.println(ex);
		            }
				}
				else {
					try {
		                Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		                DriverManager.registerDriver(driver);
		                con = DriverManager.getConnection(url, user, pass);
		                Statement st = con.createStatement();
		                String sql1 = "Select * from Invoice";
		                ResultSet resultSet = st.executeQuery(sql1);

		                while (resultSet.next()) {
		                	System.out.println("_______________________________________________ ");
		                	System.out.printf("%5s %10s %5s %10s","Telphone: ",Invoice_header.telephone,"Email: ",Invoice_header.email);
		                	System.out.println();
		                	System.out.printf("%5s %10s %5s %10s","Fax:      ",Invoice_header.fax,"Website: ",Invoice_header.website);
		                	System.out.println();
		                	System.out.println("---------------------------------------------------------- ");
		                	System.out.printf("%5s %1s %5s %5s %10s","Invoice Id: ",resultSet.getString("id")," ","Invoice Date: ",resultSet.getString("invoice_date"));
		                	System.out.println();
		                	System.out.println("---------------------------------------------------------- ");
		                	System.out.print("Customer Name:     ");
		                    System.out.println(resultSet.getString("customer_name"));
		                    System.out.print("Number Of Items:   ");
		                    System.out.println(resultSet.getString("no_of_items"));
		                    System.out.print("Total Amount:      ");
		                    System.out.println(resultSet.getString("total_amount"));
		                    System.out.print("Balance:           ");
		                    System.out.println(resultSet.getString("balance"));
		                    System.out.println("_________________________________________________________ ");
		                }
		            } catch (Exception ex) {
		                System.err.println(ex);
		            }
				}
			}
			
		}	
		catch (Exception e) {
        	System.out.println("Some Erron is Happen 0_0 ");
		}
	}
}
