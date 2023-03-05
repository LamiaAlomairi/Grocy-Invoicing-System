package src;

import java.util.*;
import java.util.Stack;

public class Main {
	
	static boolean program = true;
	static Stack<Integer> stack = new Stack<Integer>();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Array firstMenu = new Array();
	    
	    int first_selection;
	    
	    while(program)
		{
	    	try {
	    		System.out.println("________________________________");
			    System.out.println("Application Main Menu: ");
			    Menu.show_menu(firstMenu.main_menu);
			    System.out.print("Select Action  :");
			    first_selection = scan.nextInt();
			    
			    if(first_selection >0 && first_selection <= firstMenu.main_menu.size()) {
			    	first_selection = first_selection - 1;
			    	 switch (first_selection) {
		                case 0, 1, 2, 3, 4, 5, 6, 7:
		                	stack.push(first_selection);
					    	firstMenu.main_menu.get(first_selection).item_action();
		                    break;
		                default:
		                    System.out.println("Invalid Input ");
			    	 }
			    	//stack.push(first_selection);
			    	//firstMenu.main_menu.get(first_selection-1).item_action();
			    	 
			    }
			    else {
			    	System.out.println(" ________________________________________________");
			    	System.out.println("|   Invalid number, please enter a valid number  |");
			    	System.out.println("|________________________________________________|");
			    }
			} 
	    	catch (Exception e) {
				System.out.println(" _____________________________________________");
			    System.out.println("|  Invalid input, please enter a valid input  |");
			    System.out.println("|_____________________________________________|");
			    scan.next(); // clear the buffer
			}
		}

	}

}
