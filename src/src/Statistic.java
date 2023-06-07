package src;
public class Statistic extends MenuItem{
//  Constructor    ********************************************************************************************			
	Statistic(){
        this.itemName="Report: Statistics ";
    }
//  Action Method   *******************************************************************************************					
	void itemAction() {
        int numOfInvoices = LoadData.invoiceList.size();
        
        System.out.println("Number of items:    " + LoadData.noOfItem);
        System.out.println("Number of invoices: " + numOfInvoices);
        System.out.println("Total sales:        " + LoadData.totalSales);
	}

	
}
