package src;

public class Invoice_Item {
	 private int itemId;
	 private int invoiceId;
	 private float unitPrice;
	 private int quantity;
	 private float quantityAmount;

	 public Invoice_Item(int invoiceId, int itemId,  int quantity, float quantityAmount) {
	        this.itemId = itemId;
	        this.invoiceId = invoiceId;
	        this.quantity = quantity;
	        this.quantityAmount = quantityAmount;
	    }

// Getters and setters      ****************************************************************************************
	    public int getItemId() {
	        return itemId;
	    }
	    public void setItemId(int itemId) {
	        this.itemId = itemId;
	    }
	    //************************
	    public int getInvoiceId() {
	        return invoiceId;
	    }
	    public void setInvoiceId(int invoiceId) {
	        this.invoiceId = invoiceId;
	    }
	  //************************
	    public float getUnitPrice() {
	        return unitPrice;
	    }
	    public void setUnitPrice() {
	        this.unitPrice = Load_Data.itemsList.get(itemId).getUnitPrice();
	    }
	  //************************
	    public int getQuantity() {
	        return quantity;
	    }
	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
	  //************************
	    public float getQuantityAmount() {
	        return quantityAmount;
	    }
	    public void setQuantityAmount(float quantityAmount) {
	        this.quantityAmount = unitPrice * quantity;
	    }

	    // toString method to print item details
	    @Override
	    public String toString() {
	        return "Invoice_Item{" +
	        		"invoiceId=" + invoiceId +
	                "itemId=" + itemId +
	                ", unitPrice=" + unitPrice +
	                ", quantity=" + quantity +
	                ", quantityAmount=" + quantityAmount +
	                '}';
	    }
}
