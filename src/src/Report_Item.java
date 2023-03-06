package src;

public class Report_Item extends Menu_Item{
	Report_Item(){
        this.item_name="Report All Items "; 
    }
	
	void item_action() {
		try {
			for (int i = 0; i < Load_Data.itemsList.size(); i++) {
	            Item currentItem = Load_Data.itemsList.get(i);
	            int b = i+1;
	            System.out.println("["+b+"]");
	            System.out.println("Item ID:         " + currentItem.getItemId());
	            System.out.println("Item Name:       " + currentItem.getItemName()); 
	            System.out.println("Item Unit Price: " + currentItem.getUnitPrice());
	            System.out.println("Item Quantity:   " + currentItem.getQuantity());
	        }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
