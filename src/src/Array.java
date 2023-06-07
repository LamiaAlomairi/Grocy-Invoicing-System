package src;

import java.util.ArrayList;

public class Array {
	ArrayList<MenuItem> mainMenu = new ArrayList<MenuItem>(); 
    ArrayList<MenuItem> shopSettingMenu = new ArrayList<MenuItem>();
    ArrayList<MenuItem> shopItemMenu = new ArrayList<MenuItem>();
    Array()
    {
    	// Main Menu List ------------------------------------------------
        this.mainMenu.add(new ShopSetting());
	    this.mainMenu.add(new ShopItem());
	    this.mainMenu.add(new NewInvoice());
	    this.mainMenu.add(new Statistic());
	    this.mainMenu.add(new ListOfInvoice());
	    this.mainMenu.add(new SearchInvoice());
	    this.mainMenu.add(new ProgramStatistic());
	    this.mainMenu.add(new Exit());
	    // Shop Setting Menu List ----------------------------------------
	    this.shopSettingMenu.add(new LoadData());
	    this.shopSettingMenu.add(new ShopName());
	    this.shopSettingMenu.add(new InvoiceHeader());
	    this.shopSettingMenu.add(new ExitShopSetting());
	    // Manage Shop Items Menu List -----------------------------------
	    this.shopItemMenu.add(new AddItem());
	    this.shopItemMenu.add(new DeleteItem());
	    this.shopItemMenu.add(new ChangeItemPrice());
	    this.shopItemMenu.add(new ReportItem());
	    this.shopItemMenu.add(new ExitShopItem());
    }
}
