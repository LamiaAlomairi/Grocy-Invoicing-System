package src;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

public class Add_Item extends Menu_Item implements Repeat{
	Scanner scan = new Scanner(System.in);
	static boolean addItem_loop = true;
	
    Add_Item(){
        this.item_name = "Add Item "; 
    }
	
	void item_action() {
		try {
			while(addItem_loop) {
	    		System.out.print("Enter Item Id: ");
	            String item_id = scan.next();
	            
	            System.out.print("Enter Item Name: ");
	            String item_name = scan.next();
	            
	            System.out.print("Enter Unit Price: ");
	            float unit_price = scan.nextFloat();
	            
	            System.out.print("Enter Quantity: ");
	            int quantity = scan.nextInt();
	            
	            double quantityAmount = unit_price * quantity;
	            
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
	                 
	                 String sql_insert_into_item = "INSERT INTO Item VALUES ('" + item_name + 
	                 		"', " + unit_price + ", " + quantity + ", " + quantityAmount + ")";



	                 Integer m = st.executeUpdate(sql_insert_into_item);
	                 if (m >= 1) {
	                     System.out.println("inserted successfully : " + sql_insert_into_item);
	                 } else {
	                     System.out.println("insertion failed");
	                 }
	                
	             } catch (Exception ex) {
	                 System.err.println(ex);
	             }
	            
	          repeat();
	          try{
		          	FileOutputStream fileout = new FileOutputStream("InvoiceSystem.txt",true);
		          	ObjectOutputStream out = new ObjectOutputStream(fileout);
		          	out.writeObject(item_id + "\n");
		          	out.writeObject(item_name + "\n");
		          	out.writeObject(unit_price + "\n");
		          	out.writeObject(quantity + "\n");
		          	out.writeObject(quantityAmount + "\n");
			      
		          	out.close();
		          	fileout.close();
		          	System.out.println("serialized and saved");
		   
		      }
	        catch (Exception e){
	        	System.out.println("serialized Error");
		   
		      }
			}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
		
    	
	}
	@Override
	public void repeat() {
		while(true){
            System.out.print("Do you want to add more item?(Y/y-N/n)  ");
            String select=scan.next();
            if(select.equals("N") || select.equals("n")){
            	addItem_loop = false;
            	
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
