package src;

public class Exit_Shop_Item extends Menu_Item{
	Exit_Shop_Item(){
        this.item_name="Go Back "; 
    }
	
	void item_action() {
		Shop_item.shop_item_while = false;
	}
}
