package src;

import java.util.*;

public class Change_Item_Price extends Menu_Item {
    Scanner scanner = new Scanner(System.in);

    Change_Item_Price() {
        this.item_name = "Change Item Price";
    }

    void item_action() {
        try {
        	if(Load_Data.itemsList.isEmpty()) {
        		System.out.println("No Item In The List.");
        	}
        	else
        	{
        		displayAllItems();
                int selectedItemId = getSelectedItemId();
                float newPriceValue = getNewPrice();
                Load_Data.itemsList.get(selectedItemId).setUnitPrice(newPriceValue);
                System.out.println("Price changed successfully.");
        	}
            
        } 
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private void displayAllItems() {
        for (int i = 1; i <= Load_Data.itemsList.size(); i++) {
            Item currentItem = Load_Data.itemsList.get(i);
            System.out.println("Item ID:         " + currentItem.getItemId());
            System.out.println("Item Name:       " + currentItem.getItemName());
            System.out.println("Item Unit Price: " + currentItem.getUnitPrice());
        }
    }

    private int getSelectedItemId() {
        int selectedItemId;
        do {
            System.out.print("Select Item ID to change price: ");
            selectedItemId = scanner.nextInt();
        } while (selectedItemId < 0 || selectedItemId >= Load_Data.itemsList.size());
        return selectedItemId;
    }

    private float getNewPrice() {
        System.out.print("Enter new price: ");
        return scanner.nextFloat();
    }
}
