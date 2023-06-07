package src;

public class ProgramStatistic extends MenuItem{
	ProgramStatistic(){
        this.itemName="Program statistic ";
    }
	
	void itemAction() {
		int selection1 = 0;
        int selection2 = 0;
        int selection3 = 0;
        int selection4 = 0;
        int selection5 = 0;
        int selection6 = 0;
        int selection7 = 0;
        
            for(int i=0; i<Main.stack.size(); i++){
                if (Main.stack.get(i)== 1) {
                    selection1++;
                }
                else if(Main.stack.get(i) == 2){
                   selection2++; 
                }
                else if(Main.stack.get(i) == 3) {
                    selection3++;
                }
                else if(Main.stack.get(i )== 4){
                   selection4++; 
                }
                else if(Main.stack.get(i) == 5){
                   selection5++; 
                }
                else if(Main.stack.get(i) == 6){
                    selection6++; 
                 }
                else if(Main.stack.get(i) == 7){
                    selection7++; 
                 }
                
            }
            
            System.out.println("Shop Settings        =  "+selection1);
            System.out.println("Manage Shop Items    =  "+selection2);
            System.out.println("Create New Invoice   =  "+selection3);
            System.out.println("Report: Statistics   =  "+selection4);
            System.out.println("Report: All Invoices =  "+selection5);
            System.out.println("Search Invoice       =  "+selection6);
            System.out.println("Program Statistics   =  "+selection7);

	}
}
