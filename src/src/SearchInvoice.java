package src;
import java.sql.*;
import java.util.*;

public class SearchInvoice extends MenuItem implements Repeat{
	Scanner scan = new Scanner(System.in);
	static boolean searchLoop = true;
//  Constructor    ********************************************************************************************		
	SearchInvoice(){
        this.itemName="Search (1) Invoice ";
    }
//  Action Method   *******************************************************************************************			
	void itemAction() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName = myDB;" + "encrypt = true;" + "trustServerCertificate = true";
			String user = "sa";
            String pass = "root";
            Connection con = null;
            
			while(searchLoop){
	            System.out.print("Enter Invoice No to Search:    ");
	            int searchInvoice = scan.nextInt();
	            try {
	                 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	                 DriverManager.registerDriver(driver);

	                 con = DriverManager.getConnection(url, user, pass);

	                 Statement st = con.createStatement();
	                 
	                 String sqlSearchInvoice = "SELECT * FROM Invoice WHERE id="+ searchInvoice +";";
		                ResultSet resultSet = st.executeQuery(sqlSearchInvoice);
		                if (!resultSet.next()) {
		                    System.out.println("Invoice ID not found");
		                } else {
		                    do {
		                    	System.out.println("---------------------------------------------------------- ");
			                	System.out.printf("%5s %1s %5s %5s %10s","Invoice Id: ",resultSet.getString("id")," ","Invoice Date: ",resultSet.getString("invoice_date"));
			                	System.out.println();
			                	System.out.println("---------------------------------------------------------- ");
			                	System.out.print("Customer Name:     ");
			                    System.out.println(resultSet.getString("customer_name"));
			                    System.out.print("Total Amount:      ");
			                    System.out.println(resultSet.getString("total"));
			                    System.out.print("Paid Amount:       ");
			                    System.out.println(resultSet.getString("paid_amount"));
			                    System.out.print("Balance:           ");
			                    System.out.println(resultSet.getString("balance"));
			                    System.out.println("_________________________________________________________ ");
		                    } while (resultSet.next());
		                }
		                
	             } catch (Exception ex) {
	                 System.err.println(ex);
	             }
	            
	            repeat();
			}
		}
		catch (Exception e){
			System.out.println("Error -_-  Invalid input");
		}
		
	}
//   *******************************************************************************************************
	@Override
	public void repeat() {
		while(true){
            System.out.print("Do you want to add more Data?(Y/y-N/n)  ");
            String select=scan.next();
            if(select.equals("N") || select.equals("n")){
            	searchLoop = false;
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