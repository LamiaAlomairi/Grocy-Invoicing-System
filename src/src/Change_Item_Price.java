package src;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Change_Item_Price extends Menu_Item {
    Scanner scanner = new Scanner(System.in);

    Change_Item_Price() {
        this.item_name = "Change Item Price";
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
        	if(Load_Data.itemsList.isEmpty()) {
        		System.out.println("No Item In ArrayList.");
        	}
        	else{
        		displayAllItems();
                int selectedItemId = getSelectedItemId();
                float newPriceValue = getNewPrice();
                Load_Data.itemsList.get(selectedItemId).setUnitPrice(newPriceValue);
                System.out.println("Price changed successfully.");
        	}
        	try {

                Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                DriverManager.registerDriver(driver);

                con = DriverManager.getConnection(url, user, pass);


                Statement st = con.createStatement();
                
                String sql1 = "Select * from Item";
                ResultSet resultSet = st.executeQuery(sql1);


                while (resultSet.next()) {
                	System.out.println("-------------- ");
                	System.out.print("Item Id: ");
                	System.out.println(resultSet.getString("item_id"));
                	System.out.print("Item Name: ");
                    System.out.println(resultSet.getString("item_name"));
                    System.out.print("Unit Price: ");
                    System.out.println(resultSet.getString("unit_price"));
                    System.out.print("Quantity: ");
                    System.out.println(resultSet.getString("quantity"));
                    System.out.print("Quantity Amount: ");
                    System.out.println(resultSet.getString("quantityAmount"));
                }
                System.out.print("Enter item id: ");
                int selectedItemId = scanner.nextInt();
                float newPriceValue = getNewPrice();
                String sql_update_item = "UPDATE Item SET unit_price ="+ newPriceValue +" WHERE item_id = "+ selectedItemId +";";



                Integer m = st.executeUpdate(sql_update_item);
                if (m >= 1) {
                    System.out.println("Price change successfully ");
                } else {
                    System.out.println("change failed");
                }
                
            } catch (Exception ex) {
                System.err.println(ex);
            }
            
        } 
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private void displayAllItems() {
        for (int i = 1; i <= Load_Data.itemsList.size(); i++) {
            Item currentItem = Load_Data.itemsList.get(i);
            System.out.println("Item ID:         " + currentItem.getItemId());
            System.out.println("Item Name:       " + currentItem.getItemName());
            System.out.println("Item Unit Price: " + currentItem.getUnitPrice());
        }
    }

    private int getSelectedItemId() {
        int selectedItemId;
        do {
            System.out.print("Select Item ID to change price: ");
            selectedItemId = scanner.nextInt();
        } while (selectedItemId < 0 || selectedItemId >= Load_Data.itemsList.size());
        return selectedItemId;
    }

    private float getNewPrice() {
        System.out.print("Enter new price: ");
        return scanner.nextFloat();
    }
}
