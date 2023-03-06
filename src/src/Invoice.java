package src;

public class Invoice {
    
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String invoiceDate;
	private int numberOfItems;
	private double totalAmount;
	private double paidAmount;
	private double balance;

	public Invoice(String firstName, String lastName, String phoneNumber, String invoiceDate, 
			int numberOfItems, double totalAmount, double paidAmount, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.invoiceDate = invoiceDate;
		this.numberOfItems = numberOfItems;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.balance = balance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
	    this.firstName = firstName;
	}
	
	public String getLastName() {
	    return lastName;
	}
	
	public void setLastName(String lastName) {
	    this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
	    return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	}
	
	public String getInvoiceDate() {
	    return invoiceDate;
	}
	
	public void setInvoiceDate(String invoiceDate) {
	    this.invoiceDate = invoiceDate;
	}
	
	public int getNumberOfItems() {
	    return numberOfItems;
	}
	
	public void setNumberOfItems(int numberOfItems) {
	    this.numberOfItems = numberOfItems;
	}
	
	public double getTotalAmount() {
	    return totalAmount;
	}
	
	public void setTotalAmount(double totalAmount) {
	    this.totalAmount = totalAmount;
	}
	
	public double getPaidAmount() {
	    return paidAmount;
	}
	
	public void setPaidAmount(double paidAmount) {
	    this.paidAmount = paidAmount;
	}
	
	public double getBalance() {
	    return balance;
	}
	
	public void setBalance(double balance) {
	    this.balance = balance;
	}
	// toString method to print invoice details
    @Override
    public String toString() {
        return "Invoice{" +
                "firstName=" + firstName +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", invoiceDate=" + invoiceDate +
                ", numberOfItems=" + numberOfItems +
                ", totalAmount=" + totalAmount +
                ", paidAmount=" + paidAmount +
                ", balance=" + balance +
                '}';
    }

}
