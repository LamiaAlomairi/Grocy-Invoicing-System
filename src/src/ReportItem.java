package src;

public class ReportItem extends MenuItem{
//  Constructor    ********************************************************************************************		
	ReportItem(){
        this.itemName="Report All Items "; 
    }
//  Action Method   *******************************************************************************************			
	void itemAction() {
		try {
			if(LoadData.itemsList.isEmpty()) {
				System.out.println("No Data In ArrayList ");
			}
			else {
				System.out.printf("%5s %15s %15s","Item Id","Item Name","Unit Price");
                System.out.println();
                System.out.println("________________________________________________________________");
				for (int i = 0; i < LoadData.itemsList.size(); i++) {
		            Item currentItem = LoadData.itemsList.get(i);
		            int b = i+1;
		            System.out.printf("%5s %15s %15s ",b,currentItem.getItemName(),currentItem.getUnitPrice());
                    System.out.println();
                    System.out.println("----------------------------------------------------------------");
		        }
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}