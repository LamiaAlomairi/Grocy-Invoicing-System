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