package src;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Change_Item_Price extends Menu_Item implements Repeat{
    Scanner scan = new Scanner(System.in);
    static boolean change_Item_loop = true;
//  Constructor    ********************************************************************************************	
    Change_Item_Price() {
        this.item_name = "Change Item Price";
    }
    
//  Action Method   *******************************************************************************************	
    void item_action() {
        try {
        	if(Load_Data.itemsList.isEmpty()) {
        		System.out.println("No Item In The List.");
        	}
        	else{
        		while(change_Item_loop) {
        			for (int i = 0; i < Load_Data.itemsList.size(); i++) {
                        Item currentItem = Load_Data.itemsList.get(i);
                        System.out.println("Item ID:         " + currentItem.getItemId());
                        System.out.println("Item Name:       " + currentItem.getItemName());
                        System.out.println("Item Unit Price: " + currentItem.getUnitPrice());
                    }
            		System.out.print("Enter item id: ");
                    int selectedItemId = scan.nextInt();
                    System.out.print("Enter new price: ");
                    float newPriceValue = scan.nextFloat();
                    Load_Data.itemsList.get(selectedItemId-1).setUnitPrice(newPriceValue);
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
                        /*
                        String sql1 = "Select * from Item";
                        ResultSet resultSet = st.executeQuery(sql1);

                        System.out.printf("%5s %15s %15s %10s %18s","Item Id","Item Name","Unit Price","Quantity","Quantity Amount");
                        System.out.println();
                        System.out.println("_____________________________________________________________________");
                        while (resultSet.next()) {
                        	System.out.printf("%5s %15s %15s %10s %18s",resultSet.getString("item_id"),resultSet.getString("item_name"),resultSet.getString("unit_price"),resultSet.getString("quantity"),resultSet.getString("quantityAmount"));
                            System.out.println();
                            System.out.println("---------------------------------------------------------------------");
                        }
                        */
                        String sql_update_item = "UPDATE Item SET unit_price ="+ newPriceValue +" WHERE item_id = "+ selectedItemId +";";
                        st.executeUpdate(sql_update_item);
                    } catch (Exception ex) {
                        System.err.println(ex);
                    }
                    repeat();
        		}
                System.out.println("Price changed successfully.");
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
	        	change_Item_loop = false;
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
