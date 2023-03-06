package src;
import java.util.*;

public class Search_invoice extends Menu_Item implements Repeat{
	Scanner scan = new Scanner(System.in);
	static boolean searchLoop = true;
	
	Search_invoice(){
        this.item_name="Search (1) Invoice ";
    }
	
	void item_action() {
		while(searchLoop){
            System.out.print("Enter Invoice No to Search:    ");
            int searchInvoice = scan.nextInt();
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
           
            repeat();
       }
	}

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
