package src;


public class Item{
	 private int itemId;
	 private String itemName;
	 private double unitPrice;
	 private int quantity;

	    public Item(int itemId, String itemName, double unitPrice, int quantity) {
	        this.itemId = itemId;
	        this.itemName = itemName;
	        this.unitPrice = unitPrice;
	        this.quantity = quantity;
	    }

	    // Getters and setters
	    public int getItemId() {
	        return itemId;
	    }

	    public void setItemId(int itemId) {
	        this.itemId = itemId;
	    }

	    public String getItemName() {
	        return itemName;
	    }

	    public void setItemName(String itemName) {
	        this.itemName = itemName;
	    }

	    public double getUnitPrice() {
	        return unitPrice;
	    }

	    public void setUnitPrice(double unitPrice) {
	        this.unitPrice = unitPrice;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    // toString method to print item details
	    @Override
	    public String toString() {
	        return "Item{" +
	                "itemId=" + itemId +
	                ", itemName='" + itemName + '\'' +
	                ", unitPrice=" + unitPrice +
	                ", quantity=" + quantity +
	                '}';
	    }
}
