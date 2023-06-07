package src;
import java.sql.*;
import java.util.*;

public class ChangeItemPrice extends MenuItem implements Repeat{
    Scanner scan = new Scanner(System.in);
    static boolean changeItemLoop = true;
//  Constructor    ********************************************************************************************	
    ChangeItemPrice() {
        this.itemName = "Change Item Price";
    }
    
//  Action Method   *******************************************************************************************	
    void itemAction() {
        try {
        	if(Load_Data.itemsList.isEmpty()) {
        		System.out.println("No Item In The List.");
        	}
        	else{
        		while(changeItemLoop) {
        			System.out.printf("%10s %10s %10s","Item Id","Item Name","Unit Price");
        			System.out.println();
        			
        			for (int i = 0; i < LoadData.itemsList.size(); i++) {
                        Item currentItem = LoadData.itemsList.get(i);
    		            System.out.printf("%10s %10s %10s",currentItem.getItemId(),currentItem.getItemName(),currentItem.getUnitPrice()); 
    		            System.out.println();
        			}
        			
        			System.out.print("Enter item id: ");
        			int selectedItemId = scan.nextInt();
        			boolean itemFound = false;
        			for (int i = 0; i < LoadData.itemsList.size(); i++) {
        			    Item currentItem = LoadData.itemsList.get(i);
        			    if (currentItem.getItemId() == selectedItemId) {
        			        itemFound = true;
        			        System.out.print("Enter new price: ");
        			        float newPriceValue = scan.nextFloat();
        			        LoadData.itemsList.get(i).setUnitPrice(newPriceValue);

//  With JDBC     *******************************************************************************************  	
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
                               
                                String sqlUpdateItem = "UPDATE Item SET unit_price ="+ newPriceValue +" WHERE item_id = "+ selectedItemId +";";
                                st.executeUpdate(sqlUpdateItem);
                            } catch (Exception ex) {
                                System.err.println(ex);
                            }
        			        break;
        			    }
        			}
        			if (!itemFound) {
        			    System.out.println("No Item With This id");
        			    repeat();
        			} else {
        			    System.out.println("Price changed successfully.");
        			    repeat();
        			}
        		}
        	}
        } 
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
//   *************************************************************************************************************
@Override
	public void repeat() {
		while(true){
	        System.out.print("Do you want to to change another price item?(Y/y-N/n)  ");
	        String select=scan.next();
	        if(select.equals("N") || select.equals("n")){
	        	changeItemLoop = false;
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
