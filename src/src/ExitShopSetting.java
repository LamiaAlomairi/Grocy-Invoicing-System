package src;

public class ExitShopSetting extends MenuItem{
	ExitShopSetting(){
        this.itemName="Go Back "; 
    }
	
	void itemAction() {
		ShopSetting.shopSettingWhile = false;
	}
}
