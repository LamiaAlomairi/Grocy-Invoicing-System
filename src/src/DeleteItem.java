package src;

import java.sql.*;
import java.util.*;

public class DeleteItem extends MenuItem implements Repeat{
	Scanner scan = new Scanner(System.in);
	static boolean deleteItemLoop = true;
//  Constructor    ********************************************************************************************	
	DeleteItem(){
        this.itemName="Delete Item "; 
    }
//  Action Method   *******************************************************************************************	
	void itemAction() {
		boolean found = false;
		try {
			if(LoadData.itemsList.isEmpty()) {
	    		System.out.println("No Item In The List.");
	    	}
	    	else{
//   Without JDBC   *******************************************************************************************	
	    		while(deleteItemLoop) {
	    			for (int i = 0; i < LoadData.itemsList.size(); i++) {
			            Item currentItem = LoadData.itemsList.get(i);
			            System.out.println("Item ID: " + currentItem.getItemId());
			            System.out.println("Item Name: " + currentItem.getItemName()); 
			        }
		    		try {
		    			System.out.println("Enter Item ID To Delete: " ); 
		    	        int itemIdToDelete = scan.nextInt();
		    	        
		    	        for (int i=0; i< LoadData.itemsList.size(); i++) {
		    	            if (LoadData.itemsList.get(i).getItemId() == itemIdToDelete) {
		    	                LoadData.itemsList.remove(i);
		    	                found = true;
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
					                String sqlDeleteItem = "DELETE FROM Item WHERE item_id ="+ itemIdToDelete +";";
					                st.executeUpdate(sqlDeleteItem);
					            } catch (Exception ex) {
					                System.out.println("JDBC delete error");
					            }
		    	                break;
		    	            }
		    	        }
		    	        if (!found) {
		    	            System.out.println("Item not found.");
		    	        }
		    	    } 
		    		catch (Exception e) {
		    	    	System.out.println("Wrong Input. ");
		    	    }
		    		repeat();
	    		}
	    	}
		}
		catch(Exception e) {
			
		}
		
		
	}
	@Override
	public void repeat() {
		while(true){
	        System.out.print("Do you want to delete another item?(Y/y-N/n)  ");
	        String select=scan.next();
	        if(select.equals("N") || select.equals("n")){
	        	deleteItemLoop = false;
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
