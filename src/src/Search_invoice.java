package src;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Search_invoice extends Menu_Item implements Repeat{
	Scanner scan = new Scanner(System.in);
	static boolean searchLoop = true;
//  Constructor    ********************************************************************************************		
	Search_invoice(){
        this.item_name="Search (1) Invoice ";
    }
//  Action Method   *******************************************************************************************			
	void item_action() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;" +
                    "databaseName = myDB;" +
                    "encrypt = true;" +
                    "trustServerCertificate = true";

            String user = "sa";
            String pass = "root";
            Connection con = null;
			while(searchLoop){
	            System.out.print("Enter Invoice No to Search:    ");
	            int searchInvoice = scan.nextInt();
	            /*
	            for(int i=0; i < Load_Data.invoiceList.size(); i++){
	            	int b = i + 1;
	                if(b == searchInvoice){
	                	System.out.println("Invoice No:      " + b);
	    	            System.out.println("Invoice Date:    " + Load_Data.invoiceList.get(b).getInvoiceDate()); 
	    	            System.out.println("Customer Name:   " + Load_Data.invoiceList.get(b).getFirstName() + " " + Load_Data.invoiceList.get(b).getLastName());
	    	            System.out.println("Number Of Items: " + Load_Data.invoiceList.get(b).getNumberOfItems());
	    	            System.out.println("Total Amount:    " + Load_Data.invoiceList.get(b).getTotalAmount());
	    	            System.out.println("Balance:         " + Load_Data.invoiceList.get(b).getBalance());
	                }
	            }
	            */
	            
	            try {
	                 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	                 DriverManager.registerDriver(driver);

	                 con = DriverManager.getConnection(url, user, pass);

	                 Statement st = con.createStatement();
	                 
	                 String sql_search_invoice = "SELECT * FROM Invoice WHERE id="+ searchInvoice +";";
		                ResultSet resultSet = st.executeQuery(sql_search_invoice);
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
			                    System.out.print("Number Of Items:   ");
			                    System.out.println(resultSet.getString("no_of_items"));
			                    System.out.print("Total Amount:      ");
			                    System.out.println(resultSet.getString("total_amount"));
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
