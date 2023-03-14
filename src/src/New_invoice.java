package src;

import java.sql.*;
import java.util.*;

public class New_invoice extends Menu_Item implements Repeat{
	
	static String url = "jdbc:sqlserver://localhost:1433;" + "databaseName = myDB;" + "encrypt = true;" + "trustServerCertificate = true";
	static String user = "sa";
	static String pass = "root";
	static Connection con = null;
	Scanner scan = new Scanner(System.in);
	
	boolean invoice_loop = true;
	boolean invoice_item_loop = true;
	float total =0;
	static int b = Load_Data.a+1;
//  Constructor    ********************************************************************************************		
	New_invoice(){
        this.item_name="Create New Invoice ";
        try {
            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
//  Action Method   *******************************************************************************************			
	void item_action() {
        invoice_loop = true;
        while (invoice_loop) {
        	try {
        		System.out.println(" ________________________");
            	System.out.println("|     Invoice Detail     |");
            	System.out.println("|________________________|");
                System.out.print("Enter Customer First Name: ");
                String firstName = scan.next();

                System.out.print("Enter Customer Last Name: ");
                String lastName = scan.next();

                System.out.print("Enter Customer Phone Number: ");
                String phoneNumber = "";
                try {
                    phoneNumber = scan.next();
                    Integer.parseInt(phoneNumber);
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Invalid phone number format. Please enter a valid number.");
                    continue;
                }
                invoice_item_loop = true;
                SelectItem();
                

                System.out.print("Enter Paid Amount: ");
                float paidAmount = scan.nextFloat();

                float balance = paidAmount - total;
               
    //  With JDBC     *******************************************************************************************  		
                String name = firstName + " " + lastName;
                try {
                     Statement sta = con.createStatement();
                    
                    String sql_insert_into_invoice = "INSERT INTO Invoice (customer_name, phone_number, total, paid_amount, balance) VALUES ('" 
                    + name + "', " + phoneNumber + ", " + total + ", " + paidAmount + ", " + balance +")";
                    Integer n = sta.executeUpdate(sql_insert_into_invoice);
                    if (n >= 1) {
                        System.out.println("inserted successfully ");
                    } else {
                        System.out.println("insertion failed");
                    }
                } catch (Exception ex) {
                    System.err.println(ex);
                }
            //  Without JDBC     *******************************************************************************************              
                Invoice invoice = new Invoice(firstName, lastName, phoneNumber, total, paidAmount, balance);
                Load_Data.invoiceList.add(invoice);
                Load_Data.a = b+1;
                b++;
                Load_Data.totalSales = Load_Data.totalSales + total;
                total = 0;
            	repeat();
    
            }
            catch(Exception e) {
            	System.out.println("Some error o_o");
            }
        }
        invoice_loop = true;
        invoice_item_loop = true;
        
	}
	
	
	public void SelectItem() {
	    while (invoice_item_loop) {
	        System.out.printf("%10s %10s", "Item Id", "Item Name");
	        System.out.println();
	        for (int i = 0; i < Load_Data.itemsList.size(); i++) {
	            Item currentItem = Load_Data.itemsList.get(i);
	            System.out.printf("%10s %10s", currentItem.getItemId(), currentItem.getItemName());
	            System.out.println();
	        }
	        try {
	            System.out.print("Enter item id: ");
	            int selectedId = scan.nextInt();
	            boolean invoice_itemFound = false;

	            for (int i = 0; i < Load_Data.itemsList.size(); i++) {
	                Item currentItem = Load_Data.itemsList.get(i);

	                if (currentItem.getItemId() == selectedId) {
	                    invoice_itemFound = true;
	                    System.out.print("Enter quantity: ");
	                    int quan = scan.nextInt();
	                    Load_Data.no_of_item = Load_Data.no_of_item + quan;
	                    float price = currentItem.getUnitPrice();
	                    float quantityAmount = price * quan;

	                    // With JDBC *******************************************************************************************
	                    try {
	                        Statement sta = con.createStatement();

	                        String sql_insert_into_invoice_item = "INSERT INTO Invoice_Item (invoice_id, item_id,  quantity, quantityAmount) VALUES ('" 
	                            + b + "', " + selectedId + ", " + quan + ", " + quantityAmount +")";
	                        sta.executeUpdate(sql_insert_into_invoice_item);
	                    } catch (Exception ex) {
	                        System.err.println(ex);
	                    }
	                    // Without JDBC *******************************************************************************************
	                    Invoice_Item invoice_item = new Invoice_Item(b, selectedId, quan, quantityAmount);
	                    Load_Data.invoiceItemList.add(invoice_item);
	                    total = total + quantityAmount;
	                    break;
	                }
	            }

	            if (!invoice_itemFound) {
	                System.out.println("No Item With This id");
	            }
	            repeat();
	        } catch (InputMismatchException e) {
	            System.out.println("Please enter a valid input.");
	            scan.nextLine(); // clear input buffer
	        }
	    }
	}
	
	
//   ****************************************************************************************************
	@Override
	public void repeat() {
		while(true){
            System.out.print("Do you want to add more invoice?(Y/y-N/n)  ");
            String select=scan.next();
            if(select.equals("N") || select.equals("n")){
            	invoice_loop = false;
            	invoice_item_loop = false;
                break;
            }
            else if(select.equals("y")||select.equals("Y")){
            	invoice_loop = true;
            	invoice_item_loop = true;
                break;
            }
            else{
                System.out.println("Invalid letter  ");
            }
        }
		
	}
}

/*
 package src;

import java.io.*;
import java.sql.*;
import java.util.*;

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

 */
  
