package src;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class InvoiceHeader extends MenuItem{
	
	Scanner scan = new Scanner(System.in);
//  Constructor    ********************************************************************************************			
	InvoiceHeader(){
        this.itemName="Set Invoice Header "; 
    }
	
	// Telephone getter and setter *************************************************
	static int telephone;
	public void setTelephone(int telephone){
		InvoiceHeader.telephone = telephone;
    }
    
    public Integer getTelephone()
    {
    	return telephone;       
    }
    // Fax getter and setter ******************************************************
    static int fax;
	public void setFax(int fax){
		InvoiceHeader.fax = fax;
    }
    
    public Integer getFax()
    {
    	return fax;       
    }
    // Email getter and setter ***************************************************
    static String email;
	
	public void setEmail(String email){
		InvoiceHeader.email = email;
    }
    
    public String getEmail()
    {
    	return email;       
    }
    // Website getter and setter *************************************************
    static String website;
	
	public void setWebsite(String website){
		InvoiceHeader.website = website;
    }
    
    public String getWebsite()
    {
    	return website;       
    }
	/***************************************************************************/
	void itemAction() {
		try {
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
					files.write("Shop Telephone: " + InvoiceHeader.telephone);
					files.write("Shop Fax: " + InvoiceHeader.fax);
					files.write("Shop Email: " + InvoiceHeader.email);
					files.write("Shop Website: " + InvoiceHeader.website);
					files.close();
					System.out.println("Data written to file successfully.");
				} 
				else {
					//System.out.println("File already exists.");
					// Open the file in write mode
					FileWriter files = new FileWriter("InvoiceSystem.txt");
					files.write("Shop Telephone: " + InvoiceHeader.telephone + "\n");
					files.write("Shop Fax: " + InvoiceHeader.fax + "\n");
					files.write("Shop Email: " + InvoiceHeader.email + "\n");
					files.write("Shop Website: " + InvoiceHeader.website);
					files.close();
					System.out.println("Data written to file successfully.");
				}
		    } 
	        catch (Exception e) {
		      System.out.println("An error occurred while writing to the file.");
		    }
		}
		catch (Exception ex){
		      System.out.println("An error fond.");
		}
        
        
		
	}
}
