package src;
import java.text.*;
import java.time.LocalDate;

public class Invoice {
	private static int nextId = 1;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private LocalDate  invoiceDate;
	private float paidAmount;
	private float balance;
	private int invoiceId;
	private float total;

	public Invoice(String firstName, String lastName, String phoneNumber2, float total, float paidAmount, float balance) {
		this.invoiceId = nextId;
        nextId++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber2;
		this.invoiceDate = LocalDate.now();
		this.total = total;
		this.paidAmount = paidAmount;
		this.balance = balance;
	}

	public int getInvoiceId() {
        return invoiceId;
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
	
	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}
	
	public void setInvoiceDate(LocalDate  invoiceDate) {
	    this.invoiceDate = invoiceDate;
	}
	
	public float getTotal() {
	    return total;
	}
	
	public void setTotal(float total) {
	    this.total = total;
	}
	
	public float getPaidAmount() {
	    return paidAmount;
	}
	
	public void setPaidAmount(float paidAmount) {
	    this.paidAmount = paidAmount;
	}
	
	public float getBalance() {
	    return balance;
	}
	
	public void setBalance(float balance) {
	    this.balance = balance;
	}
	// toString method to print invoice details
    @Override
    public String toString() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // define a date format
        String formattedDate = dateFormat.format(invoiceDate);
        return "Invoice{" +
        		"invoiceId=" + invoiceId +
                "firstName=" + firstName +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", invoiceDate=" + formattedDate  +
                ", paidAmount=" + paidAmount +
                ", balance=" + balance +
                '}';
    }

}





/*
package src;
import java.text.*;
import java.time.LocalDate;

public class Invoice {
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private LocalDate  invoiceDate;
	private int numberOfItems;
	private double totalAmount;
	private double paidAmount;
	private double balance;

	public Invoice(String firstName, String lastName, int phoneNumber, 
			int numberOfItems, double totalAmount, double paidAmount, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.invoiceDate = LocalDate.now();
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
	
	public int getPhoneNumber() {
	    return phoneNumber;
	}
	
	public void setPhoneNumber(int phoneNumber) {
	    this.phoneNumber = phoneNumber;
	}
	
	
	
	public void setInvoiceDate(LocalDate  invoiceDate) {
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
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // define a date format
        String formattedDate = dateFormat.format(invoiceDate);
        return "Invoice{" +
                "firstName=" + firstName +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", invoiceDate=" + formattedDate  +
                ", numberOfItems=" + numberOfItems +
                ", totalAmount=" + totalAmount +
                ", paidAmount=" + paidAmount +
                ", balance=" + balance +
                '}';
    }

}
*/