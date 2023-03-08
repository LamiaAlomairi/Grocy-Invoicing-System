package src;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class New_invoice extends Menu_Item implements Repeat{
	private static final Invoice LocatDate = null;
	Scanner scan = new Scanner(System.in);
	static boolean newInvoice_loop = true;
//  Constructor    ********************************************************************************************		
	New_invoice(){
        this.item_name="Create New Invoice ";
    }
//  Action Method   *******************************************************************************************			
	void item_action() {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName = myDB;" +
                "encrypt = true;" + "trustServerCertificate = true";
        String user = "sa";
        String pass = "root";
        Connection con = null;
        
		try{
			while(newInvoice_loop) {
				
				System.out.print("Enter Customer First Name: ");
				String customer_FirstName = scan.next();
	    		
	    		System.out.print("Enter Customer Last Name: ");
	    		String customer_LastName = scan.next();
	            
	            System.out.print("Enter Customer Phone Number: ");
	            int phone_number = scan.nextInt();
	            
	            System.out.print("Enter Invoice Date: ");
	            String invoice_date = scan.next();
	            
	            System.out.print("Enter Number Of Item: ");
	            int number_of_item = scan.nextInt();
	            
	            System.out.print("Enter Total Amount: ");
	            float total_amount = scan.nextFloat();
	            
	            System.out.print("Enter Paid Amount: ");
	            float paid_amount = scan.nextFloat();
	            
	            float balance = total_amount - paid_amount;
	            String name = customer_FirstName + " " + customer_LastName;
//	With JDBC     *******************************************************************************************		 	            
	            try {
	            	Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	                DriverManager.registerDriver(driver);
	                con = DriverManager.getConnection(url, user, pass);
	                Statement sta = con.createStatement();
	                String sql_insert_into_invoice = "INSERT INTO Invoice (customer_name, phone_number, no_of_items, total_amount, paid_amount, balance) VALUES ('" 
	                		+ name + "', " + phone_number + ", " + number_of_item + ", " + total_amount +
	                		", " + paid_amount + ", " + balance +")";

	                Integer n = sta.executeUpdate(sql_insert_into_invoice);
	                if (n >= 1) {
	                    System.out.println("inserted successfully ");
	                } else {
	                    System.out.println("insertion failed");
	                }
	                //con.close();
	            } catch (Exception ex) {
	                System.err.println(ex);
	            }
	            repeat();
//	Without JDBC     *******************************************************************************************		 	            
	            Invoice invoice = new Invoice(customer_FirstName, customer_LastName, phone_number, number_of_item, total_amount, paid_amount, balance);
	            Load_Data.invoiceList.add(invoice);  
	            Load_Data.invoiceList.add(LocatDate); 
	          try{
		          	FileOutputStream fileout = new FileOutputStream("InvoiceSystem.txt",true);
		          	ObjectOutputStream out = new ObjectOutputStream(fileout);
		          	out.writeObject(customer_FirstName + "\n");
		          	out.writeObject(customer_LastName + "\n");
		          	out.writeObject(phone_number + "\n");
		          	out.writeObject(invoice_date + "\n");
		          	out.writeObject(number_of_item + "\n");
		          	out.writeObject(total_amount + "\n");
		          	out.writeObject(paid_amount + "\n");
		          	out.writeObject(balance + "\n");
			      
		          	out.close();
		          	fileout.close();
		          	System.out.println("serialized and saved");
		   
		      }
	        catch (Exception e){
		        	e.printStackTrace();
		      }
				
	    	}
		}
		catch (Exception e){
			System.out.println("Error -_- ");
      }
		
	}
//   ****************************************************************************************************
	@Override
	public void repeat() {
		while(true){
            System.out.print("Do you want to add more invoice?(Y/y-N/n)  ");
            String select=scan.next();
            if(select.equals("N") || select.equals("n")){
            	newInvoice_loop = false;
            	
                break;
            }
            else if(select.equals("y")||select.equals("Y")){
                break;
            }
            else{
                System.out.println("Invalid letter  ");
            }
        }
		
	}
}
