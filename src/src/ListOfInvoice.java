package src;

import java.sql.*;
import java.util.*;

public class ListOfInvoice extends MenuItem{
//  Constructor    ********************************************************************************************	
	ListOfInvoice(){
        this.itemName="Report: All Invoices ";
    }
//  Action Method   *******************************************************************************************		
	void itemAction() {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName = myDB;" +
                "encrypt = true;" +"trustServerCertificate = true";
        String user = "sa";
        String pass = "root";
        Connection con = null;
        try {
            // Group the invoices by customer
            Map<String, List<Invoice>> invoicesByCustomer = new HashMap<>();
            for (Invoice invoice : LoadData.invoiceList) {
                String customerName = invoice.getFirstName() + " " + invoice.getLastName();
                if (!invoicesByCustomer.containsKey(customerName)) {
                    invoicesByCustomer.put(customerName, new ArrayList<>());
                }
                invoicesByCustomer.get(customerName).add(invoice);
            }

            if (invoicesByCustomer.isEmpty()) {
                System.out.println("No Invoice In The List.");
            } else {
                if (InvoiceHeader.telephone == 0) {
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
                            for (int j=0; j< LoadData.invoiceItemList.size(); j++) {
                                InvoiceItem items = LoadData.invoiceItemList.get(j);
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
	                        System.out.printf("%5s %10s %5s %10s","Telphone: ",InvoiceHeader.telephone,"   Email:   ",InvoiceHeader.email);
	                        System.out.println();
	                        System.out.printf("%5s %10s %5s %10s","Fax:      ",InvoiceHeader.fax,     "   Website: ",InvoiceHeader.website);
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
	                            for (int j=0; j< LoadData.invoiceItemList.size(); j++) {
	                                InvoiceItem items = LoadData.invoiceItemList.get(j);
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