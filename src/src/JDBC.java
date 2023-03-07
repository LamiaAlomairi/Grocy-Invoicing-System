package src;

import java.sql.*;

public class JDBC {
	static void createTable() {
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
            
			String sql_creat_invoice= "IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Invoice') "
					+ "CREATE TABLE Invoice(\r\n"
					+ "    id INT IDENTITY(1,1) PRIMARY KEY,\r\n"
					+ "    customer_name VARCHAR(20),\r\n"
					+ "    phone_number INT,\r\n"
					+ "    invoice_date DATE DEFAULT CURRENT_TIMESTAMP,\r\n"
					+ "    no_of_items INT,\r\n"
					+ "    total_amount FLOAT,\r\n"
					+ "    paid_amount FLOAT, \r\n"
					+ "    balance FLOAT \r\n"
					+ ");";
			st.executeUpdate(sql_creat_invoice);
			
			String sql_creat_item= "IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Item') "
					+ "CREATE TABLE Item(\r\n"
					+ "    item_id INT IDENTITY(1,1) PRIMARY KEY,\r\n"
					+ "    item_name VARCHAR(20),\r\n"
					+ "    unit_price FLOAT,\r\n"
					+ "    quantity INT,\r\n"
					+ "    quantityAmount FLOAT \r\n"
					+ ");";
			st.executeUpdate(sql_creat_item);
            
			con.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }		
		
	}
	
	static void addItem() {
		
	}
	
	static void addInvoice() {
		
	}
}
