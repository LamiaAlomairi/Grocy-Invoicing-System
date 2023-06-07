package src;

public class ExitShopItem extends MenuItem{
	ExitShopItem(){
        this.itemName="Go Back "; 
    }
	
	void itemAction() {
		ShopItem.shopItemWhile = false;
	}
}
