package src;
import java.util.*;

public class Item implements Repeat{
	Scanner scan = new Scanner(System.in);
    
    private String item_id;
    private String item_name;
    private float unit_price;
    private int quantity;
    private float price;
    static boolean item_loop = true;
    
    public Item() { 
    	while(item_loop) {
    		System.out.print("Enter Item Id: ");
            item_id = scan.next();
            
            System.out.print("Enter Item Name: ");
            item_name = scan.next();
            
            System.out.print("Enter Unit Price: ");
            unit_price = scan.nextFloat();
            
            System.out.print("Enter Quantity: ");
            quantity = scan.nextInt();
            
            System.out.print("Enter Price: ");
            price = scan.nextFloat();
            
            repeat();
    	}
        
    }
    
    // Getters and setters for the item properties
    public void setItemId(String item_id) {
        this.item_id = item_id;
    }
    
    public String getItemId() {
        return item_id;
    }
    
    public void setItemName(String item_name) {
        this.item_name = item_name;
    }
    
    public String getItemName() {
        return item_name;
    }
    
    public void setUnitPrice(float unit_price) {
        this.unit_price = unit_price;
    }
    
    public float getUnitPrice() {
        return unit_price;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public float getPrice() {
        return price;
    }

	@Override
	public void repeat() {
		while(true){
            System.out.print("Do you want to add more item?(Y/y-N/n)  ");
            String select=scan.next();
            if(select.equals("N") || select.equals("n")){
            	item_loop = false;
                break;
            }
            else if(select.equals("y")||select.equals("Y")){
                break;
            }
            else{
                System.out.println("Invalid letter  ");
            }
        }
		
	}
}
