package src;

import java.util.ArrayList;

public class Menu {
	static void show_menu(ArrayList<Menu_Item> menu) 
    {
        for (int i = 0; i < menu.size(); i++)
        {
            System.out.println("["+(i+1) + "] " + menu.get(i).item_name);
            Shop_setting.shop_setting_while = true;
            Shop_item.shop_item_while = true;
            New_invoice.newInvoice_loop = true;
            Search_invoice.searchLoop = true;
            Add_Item.addItem_loop = true;
            Change_Item_Price.change_Item_loop = true;
        }
    }
}
