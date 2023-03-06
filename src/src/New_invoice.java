package src;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class New_invoice extends Menu_Item implements Repeat{
	Scanner scan = new Scanner(System.in);
	static boolean newInvoice_loop = true;
	
	New_invoice(){
        this.item_name="Create New Invoice ";
    }
	
	void item_action() {
		while(newInvoice_loop) {
			System.out.print("Enter Customer First Name: ");
			String customer_FirstName = scan.next();
    		
    		System.out.print("Enter Customer Last Name: ");
    		String customer_LastName = scan.next();
            
            System.out.print("Enter Customer Phone Number: ");
            int phone_number = scan.nextInt();
            
            System.out.print("Enter Invoice Date: ");
            String invoice_date = scan.next();
            
            System.out.print("Enter Number Of Item: ");
            int number_of_item = scan.nextInt();
            
            System.out.print("Enter Total Amount: ");
            float total_amount = scan.nextFloat();
            
            System.out.print("Enter Paid Amount: ");
            float paid_amount = scan.nextFloat();
            
            System.out.print("Enter Balance: ");
            float balance = scan.nextFloat();
            
            repeat();
            
          try{
	          	FileOutputStream fileout = new FileOutputStream("InvoiceSystem.txt",true);
	          	ObjectOutputStream out = new ObjectOutputStream(fileout);
	          	out.writeObject(customer_FirstName + "\n");
	          	out.writeObject(customer_LastName + "\n");
	          	out.writeObject(phone_number + "\n");
	          	out.writeObject(invoice_date + "\n");
	          	out.writeObject(number_of_item + "\n");
	          	out.writeObject(total_amount + "\n");
	          	out.writeObject(paid_amount + "\n");
	          	out.writeObject(balance + "\n");
		      
	          	out.close();
	          	fileout.close();
	          	System.out.println("serialized and saved");
	   
	      }
        catch (Exception e){
	        	e.printStackTrace();
	   
	      }
    	}
	}

	@Override
	public void repeat() {
		while(true){
            System.out.print("Do you want to add more invoice?(Y/y-N/n)  ");
            String select=scan.next();
            if(select.equals("N") || select.equals("n")){
            	newInvoice_loop = false;
            	
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
