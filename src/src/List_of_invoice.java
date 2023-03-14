package src;

import java.sql.*;
import java.util.*;

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
            // Group the invoices by customer
            Map<String, List<Invoice>> invoicesByCustomer = new HashMap<>();
            for (Invoice invoice : Load_Data.invoiceList) {
                String customerName = invoice.getFirstName() + " " + invoice.getLastName();
                if (!invoicesByCustomer.containsKey(customerName)) {
                    invoicesByCustomer.put(customerName, new ArrayList<>());
                }
                invoicesByCustomer.get(customerName).add(invoice);
            }

            if (invoicesByCustomer.isEmpty()) {
                System.out.println("No Invoice In The List.");
            } else {
                if (Invoice_header.telephone == 0) {
                    // Iterate over each customer's invoices
                    for (String customerName : invoicesByCustomer.keySet()) {
                        System.out.println("__________________________________________________________ ");
                        System.out.printf("%5s %10s %5s %10s","Telphone: ", 77889911,"   Email:   ","Shop@gmail.com");
                        System.out.println();
                        System.out.printf("%5s %10s %5s %10s","Fax:      ",336,     "   Website: ","https://shop.home.com");
                        System.out.println();
                        System.out.println("---------------------------------------------------------- ");
                        System.out.printf("%5s %s\n", "Customer Name: ", customerName);
                        System.out.println("---------------------------------------------------------- ");

                        List<Invoice> invoices = invoicesByCustomer.get(customerName);
                        for (Invoice invoice : invoices) {
                            System.out.printf("%5s %1s %5s %5s %10s", "Invoice Id: ", invoice.getInvoiceId()," ","Invoice Date: ",invoice.getInvoiceDate());
                            System.out.println();
                            System.out.println("---------------------------------------------------------- ");
                            System.out.printf("%10s %10s %10s ","Item Id ","Quantity","   Price   ");
                            System.out.println();
                            // Iterate over each invoice item and match the invoice ID
                            for (int j=0; j< Load_Data.invoiceItemList.size(); j++) {
                                Invoice_Item items = Load_Data.invoiceItemList.get(j);
                                if (items.getInvoiceId() == invoice.getInvoiceId()) {
                                    System.out.printf("%10s %10s %10s ", items.getItemId(), items.getQuantity(),items.getQuantityAmount());
                                    System.out.println();
                                }
                            }
                            System.out.println("---------------------------------------------------------- ");
                            System.out.println("Total Price:    " + invoice.getTotal());
                            System.out.println("Paid Amount:    " + invoice.getPaidAmount());
                            System.out.println("Balance:        " + invoice.getBalance());
                            System.out.println("__________________________________________________________ ");
                        }
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
		                
		                
		                for (String customerName : invoicesByCustomer.keySet()) {
	                        System.out.println("__________________________________________________________ ");
	                        System.out.printf("%5s %10s %5s %10s","Telphone: ",Invoice_header.telephone,"   Email:   ",Invoice_header.email);
	                        System.out.println();
	                        System.out.printf("%5s %10s %5s %10s","Fax:      ",Invoice_header.fax,     "   Website: ",Invoice_header.website);
	                        System.out.println();
	                        System.out.println("---------------------------------------------------------- ");
	                        System.out.printf("%5s %s\n", "Customer Name: ", customerName);
	                        System.out.println("---------------------------------------------------------- ");

	                        List<Invoice> invoices = invoicesByCustomer.get(customerName);
	                        for (Invoice invoice : invoices) {
	                            System.out.printf("%5s %1s %5s %5s %10s", "Invoice Id: ", invoice.getInvoiceId()," ","Invoice Date: ",invoice.getInvoiceDate());
	                            System.out.println();
	                            System.out.println("---------------------------------------------------------- ");
	                            System.out.printf("%10s %10s %10s ","Item Id ","Quantity","   Price   ");
	                            System.out.println();
	                            // Iterate over each invoice item and match the invoice ID
	                            for (int j=0; j< Load_Data.invoiceItemList.size(); j++) {
	                                Invoice_Item items = Load_Data.invoiceItemList.get(j);
	                                if (items.getInvoiceId() == invoice.getInvoiceId()) {
	                                    System.out.printf("%10s %10s %10s ", items.getItemId(), items.getQuantity(),items.getQuantityAmount());
	                                    System.out.println();
	                                }
	                            }
	                            System.out.println("---------------------------------------------------------- ");
	                            System.out.println("Total Price:    " + invoice.getTotal());
	                            System.out.println("Paid Amount:    " + invoice.getPaidAmount());
	                            System.out.println("Balance:        " + invoice.getBalance());
	                            System.out.println("__________________________________________________________ ");
	                        }
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



/*
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
*/