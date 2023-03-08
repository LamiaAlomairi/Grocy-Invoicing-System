package src;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Delete_Item extends Menu_Item{
	Scanner scan = new Scanner(System.in);
//  Constructor    ********************************************************************************************	
	Delete_Item(){
        this.item_name="Delete Item "; 
    }
//  Action Method   *******************************************************************************************	
	void item_action() {
		if(Load_Data.itemsList.isEmpty()) {
    		System.out.println("No Item In The List.");
    	}
    	else{
//Without JDBC   *******************************************************************************************	          
    		for (int i = 0; i < Load_Data.itemsList.size(); i++) {
	            Item currentItem = Load_Data.itemsList.get(i);
	            System.out.println("Item ID: " + currentItem.getItemId());
	            System.out.println("Item Name: " + currentItem.getItemName()); 
	        }
    		try {
    			System.out.println("Enter Item ID To Delete: " ); 
    	        int itemIdToDelete = scan.nextInt();
    	        
    	        for (int i=0; i< Load_Data.itemsList.size(); i++) {
    	            if (Load_Data.itemsList.get(i).getItemId() == itemIdToDelete) {
    	                Load_Data.itemsList.remove(i);
    	                break;
    	            }
    	            else {
    	            	System.out.println("Item not found.");
    	            }
    	        }
//With JDBC     *******************************************************************************************		                      
                String url = "jdbc:sqlserver://localhost:1433;" + "databaseName = myDB;" +
    	                "encrypt = true;" + "trustServerCertificate = true";
    	        String user = "sa";
    	        String pass = "root";
    	        Connection con = null;
                try {
	                Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	                DriverManager.registerDriver(driver);
	                con = DriverManager.getConnection(url, user, pass);
	                Statement st = con.createStatement();
	                String sql_delete_item = "DELETE FROM Item WHERE item_id ="+ itemIdToDelete +";";
	                st.executeUpdate(sql_delete_item);
	            } catch (Exception ex) {
	                System.out.println("JDBC delete error");
	            }
    	    } 
    		catch (Exception e) {
    	    	System.out.println("Wrong Input. ");
    	    } 
	        
    	}
	}
}
