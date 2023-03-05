package src;

public class Exit extends Menu_Item{
	Exit(){
        this.item_name="Exit ";
    }
	
	void item_action() {
		Main.program = false;
	}
}
