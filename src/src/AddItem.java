package src;
import java.io.*;
import java.sql.*;
import java.util.*;

public class AddItem extends MenuItem implements Repeat{
	Scanner scan = new Scanner(System.in);
	static boolean addItemLoop = true;
	
//  Constructor    *******************************************************************************************	
    AddItem(){
        this.itemName = "Add Item "; 
    }
    
//  Action Method   *******************************************************************************************	
	void itemAction() {
		try {
			 int itemId = 1;
			while(addItemLoop) {
	           
	            
	            System.out.print("Enter Item Name: ");
	            String itemName = scan.next();
	            
	            System.out.print("Enter Unit Price: ");
	            float unitPrice = scan.nextFloat();
//	With JDBC     *******************************************************************************************		            
	            String url = "jdbc:sqlserver://localhost:1433;" +
	                    "databaseName = myDB;" +
	                    "encrypt = true;" +
	                    "trustServerCertificate = true";

	            String user = "sa";
	            String pass = "root";
	            Connection con = null;
	            try {

	                 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	                 DriverManager.registerDriver(driver);

	                 con = DriverManager.getConnection(url, user, pass);


	                 Statement st = con.createStatement();
	                 
	                 String sqlInsertIntoItem = "INSERT INTO Item VALUES ('" + itemName + 
	                 		"', " + unitPrice + ")";

	                 Integer m = st.executeUpdate(sqlInsertIntoItem);
	                 if (m >= 1) {
	                     System.out.println("inserted successfully : " + sqlInsertIntoItem);
	                 } else {
	                     System.out.println("insertion failed");
	                 }
	                
	             } catch (Exception ex) {
	                 System.err.println(ex);
	             }
	            
	          repeat();
	          
//  Without JDBC   *******************************************************************************************	          
	          try{
		          	FileOutputStream fileout = new FileOutputStream("InvoiceSystem.txt",true);
		          	ObjectOutputStream out = new ObjectOutputStream(fileout);
		          	out.writeObject(itemId + "\n");
		          	out.writeObject(itemName + "\n");
		          	out.writeObject(unitPrice + "\n");
			      
		          	out.close();
		          	fileout.close();
		          	System.out.println("serialized and saved");
		          	
		          	Item item = new Item(itemName, unitPrice);
		        	Load_Data.itemsList.add(item);
		        	itemId++;
		      }
	        catch (Exception e){
	        	System.out.println("serialized Error");
		   
		      }
			}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
	}

//****************************************************************************************************************
	@Override
	public void repeat() {
		while(true){
            System.out.print("Do you want to add more item?(Y/y-N/n)  ");
            String select=scan.next();
            if(select.equals("N") || select.equals("n")){
            	addItemLoop = false;
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
