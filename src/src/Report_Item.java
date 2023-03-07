package src;
import java.sql.*;

public class Report_Item extends Menu_Item{
	Report_Item(){
        this.item_name="Report All Items "; 
    }
	
	void item_action() {
		/*try {
			if(Load_Data.itemsList.isEmpty()) {
				System.out.println("No Data In ArrayList ");
			}
			else {
				System.out.printf("%5s %15s %15s %10s %18s","Item Id","Item Name","Unit Price","Quantity","Quantity Amount");
                System.out.println();
                System.out.println("_____________________________________________________________________");
				for (int i = 0; i < Load_Data.itemsList.size(); i++) {
		            Item currentItem = Load_Data.itemsList.get(i);
		            int b = i+1;
		            System.out.printf("%5s %15s %15s %10s %18s",b,currentItem.getItemName(),currentItem.getUnitPrice(),currentItem.getQuantity(),currentItem.getQuantityAmount());
                    System.out.println();
                    System.out.println("---------------------------------------------------------------------");
		            
		        }
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
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

            System.out.printf("%5s %15s %15s %10s %18s","Item Id","Item Name","Unit Price","Quantity","Quantity Amount");
            System.out.println();
            System.out.println("_____________________________________________________________________");
            while (resultSet.next()) {
            	System.out.printf("%5s %15s %15s %10s %18s",resultSet.getString("item_id"),resultSet.getString("item_name"),resultSet.getString("unit_price"),resultSet.getString("quantity"),resultSet.getString("quantityAmount"));
                System.out.println();
                System.out.println("---------------------------------------------------------------------");
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
	}
}
