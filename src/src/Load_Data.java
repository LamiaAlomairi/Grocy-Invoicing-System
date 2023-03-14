package src;
import java.sql.*;
import java.util.*;

public class Load_Data extends Menu_Item implements Repeat{
	Scanner scan = new Scanner(System.in);
	
	static String url = "jdbc:sqlserver://localhost:1433;" + "databaseName = myDB;" + "encrypt = true;" + "trustServerCertificate = true";
	static String user = "sa";
	static String pass = "root";
	static Connection con = null;
	
	static ArrayList<Item> itemsList = new ArrayList<>();
	static ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
	static ArrayList<Invoice_Item> invoiceItemList = new ArrayList<Invoice_Item>();
	boolean item_loop = true;
	boolean invoice_loop = true;
	boolean invoice_item_loop = true;
	float total =0;
	static int a = 1;
	static int no_of_item = 0;
	static float totalSales = 0;
	
//  Constructor    ********************************************************************************************		
	Load_Data(){
        this.item_name="Load Data ";
    }
//  Action Method   *******************************************************************************************	
	void item_action() {
		
        while(item_loop) {
        	try {
        		// Get item details from user
            	System.out.println(" _____________________");
            	System.out.println("|     Item Detail     |");
            	System.out.println("|_____________________|");
            	
            	System.out.print("Enter Item Name: ");
            	String itemName = scan.next();
            	
            	System.out.print("Enter Unit Price: ");
            	float unitPrice = scan.nextFloat();
    //  With JDBC     *******************************************************************************************  
            	 try {

                     Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                     DriverManager.registerDriver(driver);
                     con = DriverManager.getConnection(url, user, pass);
                     Statement st = con.createStatement();
                     
                     String sql_insert_into_item = "INSERT INTO Item VALUES ('" + itemName + 
                     		"', " + unitPrice + ")";

                     Integer m = st.executeUpdate(sql_insert_into_item);
                     if (m >= 1) {
                         System.out.println("inserted successfully : " + sql_insert_into_item);
                     } else {
                         System.out.println("insertion failed");
                     }
                    
                 } catch (Exception ex) {
                     System.err.println(ex);
                 }
            	repeat();
    //  Without JDBC     *******************************************************************************************  	
            	// Create item object and add to the list
            	Item item = new Item( itemName, unitPrice);
            	itemsList.add(item);
        	}
        	catch(Exception e) {
        		System.out.println("Some error o_o");
        	}
        }
        
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
                invoiceList.add(invoice);
                a++;
                totalSales = totalSales + total;
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
	                    no_of_item = no_of_item + quan;
	                    float price = currentItem.getUnitPrice();
	                    float quantityAmount = price * quan;

	                    // With JDBC *******************************************************************************************
	                    try {
	                        Statement sta = con.createStatement();

	                        String sql_insert_into_invoice_item = "INSERT INTO Invoice_Item (invoice_id, item_id,  quantity, quantityAmount) VALUES ('" 
	                            + a + "', " + selectedId + ", " + quan + ", " + quantityAmount +")";
	                        sta.executeUpdate(sql_insert_into_invoice_item);
	                    } catch (Exception ex) {
	                        System.err.println(ex);
	                    }
	                    // Without JDBC *******************************************************************************************
	                    Invoice_Item invoice_item = new Invoice_Item(a, selectedId, quan, quantityAmount);
	                    invoiceItemList.add(invoice_item);
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

	

//  ***********************************************************************************************************
	@Override
	public void repeat() {
		while(true){
            System.out.print("Do you want to add more Data?(Y/y-N/n)  ");
            String select=scan.next();
            if(select.equals("N") || select.equals("n")){
            	item_loop = false;
            	invoice_loop = false;
            	invoice_item_loop = false;
                break;
            }
            else if(select.equals("y")||select.equals("Y")){
            	item_loop = true;
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

import java.sql.*;
import java.util.*;

public class Load_Data extends Menu_Item implements Repeat{
	Scanner scan = new Scanner(System.in);
	
	static ArrayList<Item> itemsList = new ArrayList<>();
	static ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
	boolean item_loop = true;
	boolean invoice_loop = true;
	
//  Constructor    ********************************************************************************************		
	Load_Data(){
        this.item_name="Load Data ";
    }
//  Action Method   *******************************************************************************************	
	void item_action() {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName = myDB;" +
                "encrypt = true;" + "trustServerCertificate = true";

        String user = "sa";
        String pass = "root";
        Connection con = null;
        while(item_loop) {
        	// Get item details from user
        	
        	
        	System.out.print("Enter Item Name: ");
        	String itemName = scan.next();
        	
        	System.out.print("Enter Unit Price: ");
        	float unitPrice = scan.nextFloat();
        	
        	System.out.print("Enter Quantity: ");
        	int quantity = scan.nextInt();
        	
        	float quantityAmount = unitPrice * quantity;
//  With JDBC     *******************************************************************************************  
        	 try {

                 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                 DriverManager.registerDriver(driver);
                 con = DriverManager.getConnection(url, user, pass);
                 Statement st = con.createStatement();
                 
                 String sql_insert_into_item = "INSERT INTO Item VALUES ('" + itemName + 
                 		"', " + unitPrice + ", " + quantity + ", " + quantityAmount + ")";

                 Integer m = st.executeUpdate(sql_insert_into_item);
                 if (m >= 1) {
                     System.out.println("inserted successfully : " + sql_insert_into_item);
                 } else {
                     System.out.println("insertion failed");
                 }
                
             } catch (Exception ex) {
                 System.err.println(ex);
             }
        	repeat();
//  Without JDBC     *******************************************************************************************  	
        	// Create item object and add to the list
        	Item item = new Item( itemName, unitPrice, quantity, quantityAmount);
        	itemsList.add(item);
        }
        
        
         invoice_loop = true;
        while (invoice_loop) {
            System.out.print("Enter Customer First Name: ");
            String firstName = scan.next();

            System.out.print("Enter Customer Last Name: ");
            String lastName = scan.next();

            System.out.print("Enter Customer Phone Number: ");
            int phoneNumber = scan.nextInt();

            System.out.print("Enter Number Of Item: ");
            int numberOfItems = scan.nextInt();

            System.out.print("Enter Total Amount: ");
            double totalAmount = scan.nextDouble();

            System.out.print("Enter Paid Amount: ");
            double paidAmount = scan.nextDouble();

            double balance = totalAmount - paidAmount;
           
//  With JDBC     *******************************************************************************************  		
            String name = firstName + " " + lastName;
            try {
                Statement sta = con.createStatement();
                
                String sql_insert_into_invoice = "INSERT INTO Invoice (customer_name, phone_number, no_of_items, total_amount, paid_amount, balance) VALUES ('" 
                + name + "', " + phoneNumber + ", " + numberOfItems + ", " + totalAmount + ", " + paidAmount 
                + ", " + balance +")";
                Integer n = sta.executeUpdate(sql_insert_into_invoice);
                if (n >= 1) {
                    System.out.println("inserted successfully ");
                } else {
                    System.out.println("insertion failed");
                }
            } catch (Exception ex) {
                System.err.println(ex);
            }
        	repeat();
//  Without JDBC     *******************************************************************************************              
            Invoice invoice = new Invoice(firstName, lastName, phoneNumber, numberOfItems, totalAmount, paidAmount, balance);
            invoiceList.add(invoice);
        }
        
	}

//  ***********************************************************************************************************
	@Override
	public void repeat() {
		while(true){
            System.out.print("Do you want to add more Data?(Y/y-N/n)  ");
            String select=scan.next();
            if(select.equals("N") || select.equals("n")){
            	item_loop = false;
            	invoice_loop = false;
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