package src;

import java.util.*;

public class ShopItem extends MenuItem{
	
	static boolean shopItemWhile = true;
	Scanner scan = new Scanner(System.in);
//  Constructor    ********************************************************************************************			
	ShopItem(){
        this.itemName="Manage Shop Items";
    }
//  Action Method   *******************************************************************************************			
	void item_action() {
		while(shopItemWhile){
            try {
            	System.out.println("________________________________");
            	System.out.println("Shop Item Menu: ");
            	Array shopItemMenu = new Array();
            	Menu.showMenu(shopItemMenu.shopItemMenu);
            	System.out.print("Select Action  :");
            	int shopItemSelection = scan.nextInt();
            	
            	if(shopItemSelection >0 && shopItemSelection <= shopItemMenu.shopItemMenu.size()) {
            		shopItemSelection--;
            		shopItemMenu.shopItemMenu.get(shopItemSelection).itemAction();
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
