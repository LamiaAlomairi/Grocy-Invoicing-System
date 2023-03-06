package src;

import java.util.*;

public class Delete_Item extends Menu_Item{
	Scanner scan = new Scanner(System.in);
	
	Delete_Item(){
        this.item_name="Delete Item "; 
    }
	
	void item_action() {
		
		try {
	        for (int i = 0; i < Load_Data.itemsList.size(); i++) {
	            Item currentItem = Load_Data.itemsList.get(i);
	            System.out.println("Item ID: " + currentItem.getItemId());
	            System.out.println("Item Name: " + currentItem.getItemName()); 
	        }
	        System.out.println("Enter Item ID To Delete: " ); 
	        int itemIdToDelete = scan.nextInt();
	        boolean itemFound = false;
	        for (Item item : Load_Data.itemsList) {
	            if (item.getItemId() == itemIdToDelete) {
	                Load_Data.itemsList.remove(item);
	                itemFound = true;
	                break;
	            }
	        }
	        if (!itemFound) {
	            System.out.println("Item not found.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
        
	}
}
