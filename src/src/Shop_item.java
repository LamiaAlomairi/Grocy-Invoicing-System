package src;

import java.util.*;

public class Shop_item extends Menu_Item{
	
	static boolean shop_item_while = true;
	Scanner scan = new Scanner(System.in);
	
	Shop_item(){
        this.item_name="Manage Shop Items";
    }
	
	void item_action() {
		while(shop_item_while){
            try {
            	System.out.println("________________________________");
            	System.out.println("Shop Item Menu: ");
            	Array shopItem_Menu = new Array();
            	Menu.show_menu(shopItem_Menu.shop_item_menu);
            	System.out.print("Select Action  :");
            	int shop_item_selection = scan.nextInt();
            	
            	if(shop_item_selection >0 && shop_item_selection <= shopItem_Menu.shop_item_menu.size()) {
            		shop_item_selection--;
            		shopItem_Menu.shop_item_menu.get(shop_item_selection).item_action();
            	}
            	else {
            		System.out.println(" ________________________________________________");
            		System.out.println("|   Invalid number, please enter a valid number  |");
            		System.out.println("|________________________________________________|");
            	}
            } 
            catch (Exception e) {
            	System.out.println(" _____________________________________________");
            	System.out.println("|  Invalid input, please enter a valid input  |");
            	System.out.println("|_____________________________________________|");
            	scan.next(); // clear the buffer
            }
        }
	}
}
