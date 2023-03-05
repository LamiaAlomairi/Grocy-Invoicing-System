package src;

import java.util.ArrayList;

public class Array {
	ArrayList<Menu_Item> main_menu = new ArrayList<Menu_Item>(); 
    ArrayList<Menu_Item> shop_setting_menu = new ArrayList<Menu_Item>();
    Array()
    {
        this.main_menu.add(new Shop_setting());
	    this.main_menu.add(new Shop_item());
	    this.main_menu.add(new New_invoice());
	    this.main_menu.add(new Statistic());
	    this.main_menu.add(new List_of_invoice());
	    this.main_menu.add(new Search_invoice());
	    this.main_menu.add(new Program_statistic());
	    this.main_menu.add(new Exit());
	    
	    this.shop_setting_menu.add(new Load_Data());
	    this.shop_setting_menu.add(new Shop_name());
	    this.shop_setting_menu.add(new Invoice_header());
	    this.shop_setting_menu.add(new Exit_Shop_Setting());
    }
}
