package src;
import java.util.*;

public class Load_Data extends Menu_Item implements Repeat{
	Scanner scan = new Scanner(System.in);
	
	boolean item_loop = true;
	boolean invoice_loop = true;
	
	Load_Data(){
        this.item_name="Load Data ";
    }
	static ArrayList<Item> itemsList = new ArrayList<>();
	static ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
	void item_action() {
        
        while(item_loop) {
        	// Get item details from user
        	System.out.print("Enter Item Id: ");
        	int itemId = scan.nextInt();
        	scan.nextLine(); // Consume newline left-over
        	
        	System.out.print("Enter Item Name: ");
        	String itemName = scan.nextLine();
        	
        	System.out.print("Enter Unit Price: ");
        	double unitPrice = scan.nextDouble();
        	
        	System.out.print("Enter Quantity: ");
        	int quantity = scan.nextInt();
        	
        	double quantityAmount = unitPrice * quantity;
        	
        	repeat();
        	// Create item object and add to the list
        	Item item = new Item(itemId, itemName, unitPrice, quantity, quantityAmount);
        	itemsList.add(item);
        }
        
        
         invoice_loop = true;
        while (invoice_loop) {
            System.out.print("Enter Customer First Name: ");
            String firstName = scan.next();

            System.out.print("Enter Customer Last Name: ");
            String lastName = scan.next();

            System.out.print("Enter Customer Phone Number: ");
            int phoneNumber = scan.nextInt();

            System.out.print("Enter Invoice Date: ");
            String invoiceDate = scan.next();

            System.out.print("Enter Number Of Item: ");
            int numberOfItems = scan.nextInt();

            System.out.print("Enter Total Amount: ");
            double totalAmount = scan.nextDouble();

            System.out.print("Enter Paid Amount: ");
            double paidAmount = scan.nextDouble();

            double balance = totalAmount - paidAmount;
            
            repeat(); 
            
            Invoice invoice = new Invoice(firstName, lastName, phoneNumber, invoiceDate, numberOfItems, totalAmount, paidAmount, balance);
            invoiceList.add(invoice);
            
        }
        
	}
	@Override
	public void repeat() {
		while(true){
            System.out.print("Do you want to add more Data?(Y/y-N/n)  ");
            String select=scan.next();
            if(select.equals("N") || select.equals("n")){
            	item_loop = false;
            	invoice_loop = false;
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
