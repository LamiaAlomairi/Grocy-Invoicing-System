package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Invoice_header extends Menu_Item{
	
	Scanner scan = new Scanner(System.in);
	
	Invoice_header(){
        this.item_name="Set Invoice Header "; 
    }
	// Telephone getter and setter *************************************************
	static int telephone;
	public void setTelephone(int telephone){
		Invoice_header.telephone = telephone;
    }
    
    public Integer getTelephone()
    {
    	return telephone;       
    }
    // Fax getter and setter ******************************************************
    static int fax;
	public void setFax(int fax){
		Invoice_header.fax = fax;
    }
    
    public Integer getFax()
    {
    	return fax;       
    }
    // Email getter and setter ***************************************************
    static String email;
	
	public void setEmail(String email){
		Invoice_header.email = email;
    }
    
    public String getEmail()
    {
    	return email;       
    }
    // Website getter and setter *************************************************
    static String website;
	
	public void setWebsite(String website){
		Invoice_header.website = website;
    }
    
    public String getWebsite()
    {
    	return website;       
    }
	/***************************************************************************/
	void item_action() {
		System.out.print("Write Telephone Number:  ");
		telephone = scan.nextInt();
        System.out.println(" ");
        
        System.out.print("Write Fax Number:  ");
		fax = scan.nextInt();
		System.out.println(" ");
		
		System.out.print("Write Shop Email:  ");
		email = scan.next();
		System.out.println(" ");
		
		System.out.print("Write A Shop Website:  ");
		website = scan.next();
		System.out.println(" ");
        
        try {
	    	File file = new File("InvoiceSystem.txt"); 
			
			if (file.createNewFile()) {
				System.out.println("File created ");
				// Open the file in write mode
				FileWriter files = new FileWriter("InvoiceSystem.txt");
				files.write("Shop Telephone: " + Invoice_header.telephone);
				files.write("\n");
				files.write("Shop Fax: " + Invoice_header.fax);
				files.write("\n");
				files.write("Shop Email: " + Invoice_header.email);
				files.write("\n");
				files.write("Shop Website: " + Invoice_header.website);
				files.close();
				System.out.println("Data written to file successfully.");
			} 
			else {
				System.out.println("File already exists.");
				// Open the file in write mode
				FileWriter files = new FileWriter("InvoiceSystem.txt");
				files.write("Shop Telephone: " + Invoice_header.telephone + "\n");
				files.write("Shop Fax: " + Invoice_header.fax + "\n");
				files.write("Shop Email: " + Invoice_header.email + "\n");
				files.write("Shop Website: " + Invoice_header.website);
				files.close();
				System.out.println("Data written to file successfully.");
			}
	    } 
        catch (IOException e) {
	      System.out.println("An error occurred while writing to the file.");
	    }
	}
}
