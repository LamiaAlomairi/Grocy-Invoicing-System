package src;
import java.sql.*;
import java.util.*;

public class Exit extends MenuItem{
	Scanner scan = new Scanner(System.in);
	
//  Constructor    ********************************************************************************************	
	Exit(){
        this.itemName="Exit ";
    }
//  Action Method   *******************************************************************************************		
	void itemAction() {
		while(true){
            System.out.print("Are you sure you want to exit?(Y/y-N/n)  ");
            String exit=scan.next();
            if(exit.equals("N") || exit.equals("n")){
                break;
            }
            else if(exit.equals("y")||exit.equals("Y")){
            	Main.program = false;
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
	                String sqlDelete3 = "DROP TABLE Invoice_Item;";
	                st.executeUpdate(sqlDelete3);
	                String sqlDelete = "DROP TABLE Item;";
	                st.executeUpdate(sqlDelete);
	                
	                String sqlDelete2 = "DROP TABLE Invoice;";
	                st.executeUpdate(sqlDelete2);
	                
	            } catch (Exception ex) {
	                System.err.println(ex);
	            }
            	System.out.println("Good Bye 0_-  ");
                break;
            }
            else{
                System.out.println("Invalid letter  ");
            }
        }
		
	}
}
