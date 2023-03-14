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

/*
package src;

public class Item{
	 private static int nextId = 1;
	 private int itemId;
	 private String itemName;
	 private float unitPrice;
	 private int quantity;
	 private float quantityAmount;

	    public Item(String itemName, float unitPrice, int quantity, double quantityAmount) {
	    	this.itemId = nextId;
	        nextId++;
	        this.itemName = itemName;
	        this.unitPrice = unitPrice;
	        this.quantity = quantity;
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

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
	    
	    public float getQuantityAmount() {
	        return quantityAmount;
	    }

	    public void setQuantityAmount(float quantityAmount) {
	        this.quantityAmount = quantityAmount;
	    }

	    // toString method to print item details
	    @Override
	    public String toString() {
	        return "Item{" +
	                "itemId=" + itemId +
	                ", itemName='" + itemName + '\'' +
	                ", unitPrice=" + unitPrice +
	                ", quantity=" + quantity +
	                ", quantityAmount=" + quantityAmount +
	                '}';
	    }
}
*/