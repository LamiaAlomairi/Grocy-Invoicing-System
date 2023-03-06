package src;

public class List_of_invoice extends Menu_Item{
	List_of_invoice(){
        this.item_name="Report: All Invoices ";
    }
	
	void item_action() {
		try {
			for (int i = 0; i < Load_Data.invoiceList.size(); i++) {
	            Invoice currentInvoice = Load_Data.invoiceList.get(i);
	            int b = i+1;
	            System.out.println("Invoice No:      " + b);
	            System.out.println("Invoice Date:    " + currentInvoice.getInvoiceDate()); 
	            System.out.println("Customer Name:   " + currentInvoice.getFirstName() + " " + currentInvoice.getLastName());
	            System.out.println("Number Of Items: " + currentInvoice.getNumberOfItems());
	            System.out.println("Total Amount:    " + currentInvoice.getTotalAmount());
	            System.out.println("Balance:         " + currentInvoice.getBalance());
	        }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
