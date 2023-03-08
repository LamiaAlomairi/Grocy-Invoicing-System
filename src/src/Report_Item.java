package src;

public class Report_Item extends Menu_Item{
//  Constructor    ********************************************************************************************		
	Report_Item(){
        this.item_name="Report All Items "; 
    }
//  Action Method   *******************************************************************************************			
	void item_action() {
		try {
			if(Load_Data.itemsList.isEmpty()) {
				System.out.println("No Data In ArrayList ");
			}
			else {
				System.out.printf("%5s %15s %15s %10s %18s","Item Id","Item Name","Unit Price","Quantity","Quantity Amount");
                System.out.println();
                System.out.println("_____________________________________________________________________");
				for (int i = 0; i < Load_Data.itemsList.size(); i++) {
		            Item currentItem = Load_Data.itemsList.get(i);
		            int b = i+1;
		            System.out.printf("%5s %15s %15s %10s %18s",b,currentItem.getItemName(),currentItem.getUnitPrice(),currentItem.getQuantity(),currentItem.getQuantityAmount());
                    System.out.println();
                    System.out.println("---------------------------------------------------------------------");
		        }
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
