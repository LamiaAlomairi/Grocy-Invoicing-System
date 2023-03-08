package src;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.util.Stack;

public class Main{
	
	static boolean program = true;
	static boolean jdbc_program = true;
	static Stack<Integer> stack = new Stack<Integer>();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		createTable();
		Array firstMenu = new Array();
	    
	    int first_selection;
	    while(program){
 	    	try {
 	    		System.out.println("________________________________");
 			    System.out.println("Application Main Menu: ");
 			    Menu.show_menu(firstMenu.main_menu);
 			    System.out.print("Select Action  :");
 			    first_selection = scan.nextInt();
 			    stack.push(first_selection);
 			    if(first_selection >0 && first_selection <= firstMenu.main_menu.size()) {
 			    	first_selection = first_selection - 1;
 			    	 switch (first_selection) {
 		                case 0, 1, 2, 3, 4, 5, 6, 7:
 		                	
 					    	firstMenu.main_menu.get(first_selection).item_action();
 		                    break;
 		                default:
 		                    System.out.println("Invalid Input ");
 			    	 } 
 			    }
 			    else {
 			    	System.out.println(" ________________________________________________");
 			    	System.out.println("|   Invalid number, please enter a valid number  |");
 			    	System.out.println("|________________________________________________|");
 			    }
 			} 
 	    	catch (Exception e) {
 				System.out.println(" _____________________________________________");
 			    System.out.println("|  Invalid input, please enter a valid input  |");
 			    System.out.println("|_____________________________________________|");
 			    scan.next(); // clear the buffer
 			}
 		}
	}
// Method To Create Tables   *************************************************************************************	
	static void createTable() {
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
}
