package src;

import java.util.ArrayList;

public class Array {
	ArrayList<Menu_Item> main_menu = new ArrayList<Menu_Item>(); 
    ArrayList<Menu_Item> shop_setting_menu = new ArrayList<Menu_Item>();
    ArrayList<Menu_Item> shop_item_menu = new ArrayList<Menu_Item>();
    Array()
    {
    	// Main Menu List ------------------------------------------------
        this.main_menu.add(new Shop_setting());
	    this.main_menu.add(new Shop_item());
	    this.main_menu.add(new New_invoice());
	    this.main_menu.add(new Statistic());
	    this.main_menu.add(new List_of_invoice());
	    this.main_menu.add(new Search_invoice());
	    this.main_menu.add(new Program_statistic());
	    this.main_menu.add(new Exit());
	    // Shop Setting Menu List ----------------------------------------
	    this.shop_setting_menu.add(new Load_Data());
	    this.shop_setting_menu.add(new Shop_name());
	    this.shop_setting_menu.add(new Invoice_header());
	    this.shop_setting_menu.add(new Exit_Shop_Setting());
	    // Manage Shop Items Menu List -----------------------------------
	    this.shop_item_menu.add(new Add_Item());
	    this.shop_item_menu.add(new Delete_Item());
	    this.shop_item_menu.add(new Change_Item_Price());
	    this.shop_item_menu.add(new Report_Item());
	    this.shop_item_menu.add(new Exit_Shop_Item());
    }
}
