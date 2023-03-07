package src;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Delete_Item extends Menu_Item{
	Scanner scan = new Scanner(System.in);
	
	Delete_Item(){
        this.item_name="Delete Item "; 
    }
	
	void item_action() {
		String url = "jdbc:sqlserver://localhost:1433;" +
                "databaseName = myDB;" +
                "encrypt = true;" +
                "trustServerCertificate = true";

        String user = "sa";
        String pass = "root";
        Connection con = null;
		
		try {
				try {
	                Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	                DriverManager.registerDriver(driver);
	                con = DriverManager.getConnection(url, user, pass);
	                Statement st = con.createStatement();
	                String sql1 = "Select * from Item";
	                ResultSet resultSet = st.executeQuery(sql1);

	                System.out.printf("%5s %15s","Item Id","Item Name");
                    System.out.println();
                    System.out.println("___________________________");
	                while (resultSet.next()) {
	                	System.out.printf("%5s %15s",resultSet.getString("item_id"),resultSet.getString("item_name"));
	                    System.out.println();
	                    System.out.println("---------------------------");
	                }
	                
	                System.out.print("Enter item id: ");
	                int selectedItemId = scan.nextInt();
	                String sql_update_item = "DELETE FROM Item WHERE item_id ="+ selectedItemId +";";

	                Integer m = st.executeUpdate(sql_update_item);
	                if (m >= 1) {
	                    System.out.println("Item delete successfully ");
	                } else {
	                    System.out.println("delete failed");
	                }
	                
	            } catch (Exception ex) {
	                System.err.println(ex);
	            }
        	/*
        		for (int i = 0; i < Load_Data.itemsList.size(); i++) {
    	            Item currentItem = Load_Data.itemsList.get(i);
    	            System.out.println("Item ID: " + currentItem.getItemId());
    	            System.out.println("Item Name: " + currentItem.getItemName()); 
    	        }
    	        
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
        	*/
	    } 
		catch (Exception e) {
	    	System.out.println("Wrong Input. ");
	    } 
	}
}
