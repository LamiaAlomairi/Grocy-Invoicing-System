package src;

import java.util.ArrayList;

public class Menu {
	static void showMenu(ArrayList<MenuItem> menu) 
    {
        for (int i = 0; i < menu.size(); i++)
        {
            System.out.println("["+(i+1) + "] " + menu.get(i).itemName);
            ShopSetting.shopSettingWhile = true;
            ShopItem.shopItemWhile = true;
            SearchInvoice.searchLoop = true;
            AddItem.addItemLoop = true;
            ChangeItemPrice.changeItemLoop = true;
            DeleteItem.deleteItemLoop = true;
        }
    }
}
