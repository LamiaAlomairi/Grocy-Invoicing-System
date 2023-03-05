package src;
import java.util.*;
public class Shop_setting extends Menu_Item{
	Scanner scan = new Scanner(System.in);
	static boolean shop_setting_while = true;
	Shop_setting(){
        this.item_name="Shop Settings";
    }
	
	void item_action() {
		
		while(shop_setting_while){
            try {
            	System.out.println("________________________________");
            	System.out.println("Shop Settings Menu: ");
            	Array shopSetting_Menu = new Array();
            	Menu.show_menu(shopSetting_Menu.shop_setting_menu);
            	System.out.print("Select Action  :");
            	int shop_setting_selection = scan.nextInt();
            	if(shop_setting_selection >0 && shop_setting_selection <= shopSetting_Menu.shop_setting_menu.size()) {
            		shop_setting_selection--;
            		shopSetting_Menu.shop_setting_menu.get(shop_setting_selection).item_action();
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
