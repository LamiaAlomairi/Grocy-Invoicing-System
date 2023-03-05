package src;

import java.util.ArrayList;

public class Load_Data extends Menu_Item{
	
	static ArrayList<Item> item = new ArrayList<Item>();
	static ArrayList<Invoice> invoice = new ArrayList<Invoice>();
	
	Load_Data(){
        this.item_name="Load Data ";
    }
	
	void item_action() {
		Item.item_loop = true;
		Invoice.invoice_loop = true;
		Item newItem = new Item();
		item.add(newItem);
		
		Invoice newInvoice = new Invoice();
		invoice.add(newInvoice);
	}
}
