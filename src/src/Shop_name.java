package src;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Shop_name extends Menu_Item{
	Scanner scan = new Scanner(System.in);
//  Constructor    ********************************************************************************************			
	Shop_name(){
        this.item_name="Set Shop Name "; 
    }
	
	static String shop_Name;
	
	public void setShopName(String name){
		Shop_name.shop_Name = name;
    }
    
    public String getShopName()
    {
    	return shop_Name;       
    }
//  Action Method   *******************************************************************************************				
	void item_action() {
		System.out.print("Write A Shop Name:  ");
		shop_Name = scan.next();
        System.out.println(" ");
        
        try {
	    	File file = new File("InvoiceSystem.txt"); 
			
			if (file.createNewFile()) {
				System.out.println("File created ");
				// Open the file in write mode
				FileWriter files = new FileWriter("InvoiceSystem.txt");
				files.write(Shop_name.shop_Name);
				files.close();
				System.out.println("Data written to file successfully.");
			} 
			else {
				//System.out.println("File already exists.");
				// Open the file in write mode
				FileWriter files = new FileWriter("InvoiceSystem.txt");
				files.write(Shop_name.shop_Name);
				files.close();
				System.out.println("Data written to file successfully.");
			}
	    } 
        catch (IOException e) {
	      System.out.println("An error occurred while writing to the file.");
	    }
	}
}
