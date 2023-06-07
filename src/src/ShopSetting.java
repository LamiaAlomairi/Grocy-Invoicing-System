package src;
import java.util.*;
public class ShopSetting extends MenuItem{
	Scanner scan = new Scanner(System.in);
	static boolean shopSettingWhile = true;
	
//  Constructor    ********************************************************************************************			
	ShopSetting(){
        this.itemName="Shop Settings";
    }
//  Action Method   *******************************************************************************************				
	void itemAction() {
		
		while(shopSettingWhile){
            try {
            	System.out.println("________________________________");
            	System.out.println("Shop Settings Menu: ");
            	Array shopSettingMenu = new Array();
            	Menu.showMenu(shopSettingMenu.shopSettingMenu);
            	System.out.print("Select Action  :");
            	int shopSettingSelection = scan.nextInt();
            	if(shopSettingSelection >0 && shopSettingSelection <= shopSettingMenu.shopSettingMenu.size()) {
            		shopSettingSelection--;
            		shopSettingMenu.shopSettingMenu.get(shopSettingSelection).itemAction();
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
