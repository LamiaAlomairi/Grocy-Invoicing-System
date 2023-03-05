package src;

public class Exit_Shop_Setting extends Menu_Item{
	Exit_Shop_Setting(){
        this.item_name="Go Back "; 
    }
	
	void item_action() {
		Shop_setting.shop_setting_while = false;
	}
}
