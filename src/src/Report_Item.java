package src;
import java.sql.*;

public class Report_Item extends Menu_Item{
	Report_Item(){
        this.item_name="Report All Items "; 
    }
	
	void item_action() {
		try {
			if(Load_Data.itemsList.isEmpty()) {
				try {
					String url = "jdbc:sqlserver://localhost:1433;" +
			                "databaseName = myDB;" +
			                "encrypt = true;" +
			                "trustServerCertificate = true";

			        String user = "sa";
			        String pass = "root";
			        Connection con = null;
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
	            } catch (Exception ex) {
	                System.err.println(ex);
	            }
			}
			else {
				for (int i = 0; i < Load_Data.itemsList.size(); i++) {
		            Item currentItem = Load_Data.itemsList.get(i);
		            int b = i+1;
		            System.out.println("["+b+"]");
		            System.out.println("Item ID:              " + currentItem.getItemId());
		            System.out.println("Item Name:            " + currentItem.getItemName()); 
		            System.out.println("Item Unit Price:      " + currentItem.getUnitPrice());
		            System.out.println("Item Quantity:        " + currentItem.getQuantity());
		            System.out.println("Item Quantity Amount: " + currentItem.getQuantityAmount());
		        }
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
