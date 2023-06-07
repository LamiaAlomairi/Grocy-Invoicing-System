package src;

import java.sql.*;
import java.util.*;

public class NewInvoice extends MenuItem implements Repeat{
	
	static String url = "jdbc:sqlserver://localhost:1433;" + "databaseName = myDB;" + "encrypt = true;" + "trustServerCertificate = true";
	static String user = "sa";
	static String pass = "root";
	static Connection con = null;
	Scanner scan = new Scanner(System.in);
	
	boolean invoiceLoop = true;
	boolean invoiceItemLoop = true;
	float total =0;
	static int b = LoadData.a+1;
//  Constructor    ********************************************************************************************		
	NewInvoice(){
        this.itemName="Create New Invoice ";
        try {
            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
//  Action Method   *******************************************************************************************			
	void itemAction() {
        invoiceLoop = true;
        while (invoiceLoop) {
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
                invoiceItemLoop = true;
                SelectItem();
                

                System.out.print("Enter Paid Amount: ");
                float paidAmount = scan.nextFloat();

                float balance = paidAmount - total;
               
    //  With JDBC     *******************************************************************************************  		
                String name = firstName + " " + lastName;
                try {
                     Statement sta = con.createStatement();
                    
                    String sqlInsertIntoInvoice = "INSERT INTO Invoice (customer_name, phone_number, total, paid_amount, balance) VALUES ('" 
                    + name + "', " + phoneNumber + ", " + total + ", " + paidAmount + ", " + balance +")";
                    Integer n = sta.executeUpdate(sqlInsertIntoInvoice);
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
                LoadData.invoiceList.add(invoice);
                LoadData.a = b+1;
                b++;
                LoadData.totalSales = LoadData.totalSales + total;
                total = 0;
            	repeat();
    
            }
            catch(Exception e) {
            	System.out.println("Some error o_o");
            }
        }
        invoiceLoop = true;
        invoiceItemLoop = true;
        
	}
	
	
	public void SelectItem() {
	    while (invoiceItemLoop) {
	        System.out.printf("%10s %10s", "Item Id", "Item Name");
	        System.out.println();
	        for (int i = 0; i < LoadData.itemsList.size(); i++) {
	            Item currentItem = LoadData.itemsList.get(i);
	            System.out.printf("%10s %10s", currentItem.getItemId(), currentItem.getItemName());
	            System.out.println();
	        }
	        try {
	            System.out.print("Enter item id: ");
	            int selectedId = scan.nextInt();
	            boolean invoiceItemFound = false;

	            for (int i = 0; i < LoadData.itemsList.size(); i++) {
	                Item currentItem = LoadData.itemsList.get(i);

	                if (currentItem.getItemId() == selectedId) {
	                    invoiceItemFound = true;
	                    System.out.print("Enter quantity: ");
	                    int quan = scan.nextInt();
	                    LoadData.noOfItem = LoadData.noOfItem + quan;
	                    float price = currentItem.getUnitPrice();
	                    float quantityAmount = price * quan;

	                    // With JDBC *******************************************************************************************
	                    try {
	                        Statement sta = con.createStatement();

	                        String sqlInsertIntoInvoiceItem = "INSERT INTO Invoice_Item (invoice_id, item_id,  quantity, quantityAmount) VALUES ('" 
	                            + b + "', " + selectedId + ", " + quan + ", " + quantityAmount +")";
	                        sta.executeUpdate(sqlInsertIntoInvoiceItem);
	                    } catch (Exception ex) {
	                        System.err.println(ex);
	                    }
	                    // Without JDBC *******************************************************************************************
	                    InvoiceItem invoiceItem = new InvoiceItem(b, selectedId, quan, quantityAmount);
	                    LoadData.invoiceItemList.add(invoiceItem);
	                    total = total + quantityAmount;
	                    break;
	                }
	            }

	            if (!invoiceItemFound) {
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
            	invoiceLoop = false;
            	invoiceItemLoop = false;
                break;
            }
            else if(select.equals("y")||select.equals("Y")){
            	invoiceLoop = true;
            	invoiceItemLoop = true;
                break;
            }
            else{
                System.out.println("Invalid letter  ");
            }
        }
		
	}
}
