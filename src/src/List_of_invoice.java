package src;

import java.sql.*;

public class List_of_invoice extends Menu_Item{
	List_of_invoice(){
        this.item_name="Report: All Invoices ";
    }
	
	void item_action() {
		try {
			if(Load_Data.invoiceList.isEmpty()) {
				try {
					String url = "jdbc:sqlserver://localhost:1433;" +
			                "databaseName = myDB;" +
			                "encrypt = true;" +
			                "trustServerCertificate = true";

			        String user = "sa";
			        String pass = "root";
			        Connection con = null;
	                Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	                DriverManager.registerDriver(driver);
	                con = DriverManager.getConnection(url, user, pass);
	                Statement st = con.createStatement();
	                String sql1 = "Select * from Invoice";
	                ResultSet resultSet = st.executeQuery(sql1);

	                while (resultSet.next()) {
	                	System.out.println("-------------- ");
	                	System.out.print("Invoice Id: ");
	                	System.out.println(resultSet.getString("id"));
	                	System.out.print("Invoice Date: ");
	                    System.out.println(resultSet.getString("invoice_date"));
	                	System.out.print("Customer Name: ");
	                    System.out.println(resultSet.getString("customer_name"));
	                    System.out.print("Number Of Items: ");
	                    System.out.println(resultSet.getString("no_of_items"));
	                    System.out.print("Total Amount: ");
	                    System.out.println(resultSet.getString("total_amount"));
	                    System.out.print("Balance: ");
	                    System.out.println(resultSet.getString("balance"));
	                }
	            } catch (Exception ex) {
	                System.err.println(ex);
	            }
			}
			else {
				for (int i = 0; i < Load_Data.invoiceList.size(); i++) {
		            Invoice currentInvoice = Load_Data.invoiceList.get(i);
		            int b = i+1;
		            System.out.println("Invoice No:      " + b);
		            System.out.println("Invoice Date:    " + currentInvoice.getInvoiceDate()); 
		            System.out.println("Customer Name:   " + currentInvoice.getFirstName() + " " + currentInvoice.getLastName());
		            System.out.println("Number Of Items: " + currentInvoice.getNumberOfItems());
		            System.out.println("Total Amount:    " + currentInvoice.getTotalAmount());
		            System.out.println("Balance:         " + currentInvoice.getBalance());
		        }
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
