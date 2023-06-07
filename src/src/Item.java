package src;


public class Item{
	 private static int nextId = 1;
	 private int itemId;
	 private String itemName;
	 private float unitPrice;

	    public Item(String itemName, float unitPrice) {
	    	this.itemId = nextId;
	        nextId++;
	        this.itemName = itemName;
	        this.unitPrice = unitPrice;
	    }

	    // Getters and setters
	    public int getItemId() {
	        return itemId;
	    }

	    public String getItemName() {
	        return itemName;
	    }

	    public void setItemName(String itemName) {
	        this.itemName = itemName;
	    }

	    public float getUnitPrice() {
	        return unitPrice;
	    }

	    public void setUnitPrice(float unitPrice) {
	        this.unitPrice = unitPrice;
	    }


	    // toString method to print item details
	    @Override
	    public String toString() {
	        return "Item{" +
	                "itemId=" + itemId +
	                ", itemName='" + itemName + '\'' +
	                ", unitPrice=" + unitPrice +
	                '}';
	    }
}