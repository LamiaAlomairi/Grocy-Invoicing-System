package src;

import java.util.ArrayList;

public class Menu {
	static void show_menu(ArrayList<Menu_Item> menu) 
    {
        for (int i = 0; i < menu.size(); i++)
        {
            System.out.println("["+(i+1) + "] " + menu.get(i).item_name);
            //SchoolDetail.setupWhile = true;
        }
    }
}
