package src;
import java.util.*;

public class Exit extends Menu_Item{
	Scanner scan = new Scanner(System.in);
	Exit(){
        this.item_name="Exit ";
    }
	
	void item_action() {
		while(true){
            System.out.print("Are you sure you want to exit?(Y/y-N/n)  ");
            String exit=scan.next();
            if(exit.equals("N") || exit.equals("n")){
                break;
            }
            else if(exit.equals("y")||exit.equals("Y")){
            	Main.program = false;
            	System.out.println("Good Bye 0_-  ");
                break;
            }
            else{
                System.out.println("Invalid letter  ");
            }
        }
		
	}
}
