package src;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ShopName extends MenuItem{
	Scanner scan = new Scanner(System.in);
//  Constructor    ********************************************************************************************			
	ShopName(){
        this.itemName="Set Shop Name "; 
    }
	
	static String shopName;
	
	public void setShopName(String name){
		ShopName.shopName = name;
    }
    
    public String getShopName()
    {
    	return shopName;       
    }
//  Action Method   *******************************************************************************************				
	void item_action() {
		System.out.print("Write A Shop Name:  ");
		shopName = scan.next();
        System.out.println(" ");
        
        try {
	    	File file = new File("InvoiceSystem.txt"); 
			
			if (file.createNewFile()) {
				System.out.println("File created ");
				// Open the file in write mode
				FileWriter files = new FileWriter("InvoiceSystem.txt");
				files.write(ShopName.shopName);
				files.close();
				System.out.println("Data written to file successfully.");
			} 
			else {
				//System.out.println("File already exists.");
				// Open the file in write mode
				FileWriter files = new FileWriter("InvoiceSystem.txt");
				files.write(ShopName.shopName);
				files.close();
				System.out.println("Data written to file successfully.");
			}
	    } 
        catch (IOException e) {
	      System.out.println("An error occurred while writing to the file.");
	    }
	}
}
