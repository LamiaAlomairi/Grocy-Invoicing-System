package src;

import java.util.ArrayList;

public class Statistic extends Menu_Item{
//  Constructor    ********************************************************************************************			
	Statistic(){
        this.item_name="Report: Statistics ";
    }
//  Action Method   *******************************************************************************************					
	void item_action() {
		int numOfItems = Load_Data.itemsList.size();
        int numOfInvoices = Load_Data.invoiceList.size();
        float totalSales = calculateTotalSales(Load_Data.invoiceList);
        
        System.out.println("Number of items:    " + numOfItems);
        System.out.println("Number of invoices: " + numOfInvoices);
        System.out.println("Total sales:        " + totalSales);
	}

	private float calculateTotalSales(ArrayList<Invoice> invoiceList) {
		 float totalSales = 0;
	        //for (Invoice invoice : invoiceList) {
	        for(int i=0; i<Load_Data.invoiceList.size(); i++) {   
	                totalSales += Load_Data.invoiceList.get(i).getTotalAmount();
	            
	        }
	        return totalSales;
	}
}
