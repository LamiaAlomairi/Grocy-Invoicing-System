package src;

import java.util.*;

public class Invoice implements Repeat{
Scanner scan = new Scanner(System.in);
    
    private String customer_FirstName;
    private String customer_LastName;
    private int phone_number;
    private String invoice_date;
    private int number_of_item;
    private float total_amount;
    private float paid_amount;
    private float balance;
    static boolean invoice_loop = true;
    static Item newItems = new Item();
    
    public Invoice() { 
    	while(invoice_loop) {
    		System.out.print("Enter Customer First Name: ");
    		customer_FirstName = scan.next();
    		
    		System.out.print("Enter Customer Last Name: ");
    		customer_LastName = scan.next();
            
            System.out.print("Enter Customer Phone Number: ");
            phone_number = scan.nextInt();
            
            System.out.print("Enter Invoice Date: ");
            invoice_date = scan.next();
            
            System.out.print("Enter Number Of Item: ");
            number_of_item = scan.nextInt();
            
            System.out.print("Enter Total Amount: ");
            total_amount = scan.nextFloat();
            
            System.out.print("Enter Paid Amount: ");
            paid_amount = scan.nextFloat();
            
            System.out.print("Enter Balance: ");
            balance = scan.nextFloat();
            
            repeat();
    	}
        
    }
    
    // Getters and setters for the item properties
    public void setFirstName(String customer_FirstName) {
        this.customer_FirstName = customer_FirstName;
    }
    
    public String getFirstName() {
        return customer_FirstName;
    }
    
    public void setLastName(String customer_LastName) {
        this.customer_LastName = customer_LastName;
    }
    
    public String getLastName() {
        return customer_LastName;
    }
    
    public void setPhoneNumber(Integer phone_number) {
        this.phone_number = phone_number;
    }
    
    public Integer getPhoneNumber() {
        return phone_number;
    }
    
    public void setInvoiceDate(String invoice_date) {
        this.invoice_date = invoice_date;
    }
    
    public String getInvoiceDate() {
        return invoice_date;
    }
    
    public void setNumOfItem(int number_of_item) {
        this.number_of_item = number_of_item;
    }
    
    public int getNumOfItem() {
        return number_of_item;
    }
    
    public void setTotalAmount(float total_amount) {
        this.total_amount = total_amount;
    }
    
    public float getTotalAmount() {
        return total_amount;
    }
    
    public void setPaidAmount(float paid_amount) {
        this.paid_amount = paid_amount;
    }
    
    public float getPaidAmount() {
        return paid_amount;
    }
    
    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    public float getBalance() {
        return balance;
    }

	@Override
	public void repeat() {
		while(true){
            System.out.print("Do you want to add more invoice?(Y/y-N/n)  ");
            String select=scan.next();
            if(select.equals("N") || select.equals("n")){
            	invoice_loop = false;
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
