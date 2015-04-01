package service;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuImpl implements Menu{
	 private static MenuImpl instance = null;
	 private ArrayList<String[]> drinksInMenu = null;
	 
	 public static MenuImpl getInstance(){
	        if (instance == null) {
	            instance = new MenuImpl();
	        }
	        return instance;
	    }
	 
	@Override
	public String printMenu() {
		StringBuilder sb = new StringBuilder();
        sb.append("\nMenu:");
        sb.append("\n\n");
                
        /*
         * Append drink attribute to menu (i.e. #,drinkName,$N.NN,true||false)
         */
        int index = 1;
        for (String[] drinkItem : this.drinksInMenu) {
            sb.append(index);
            sb.append(",");
            String nextDrink = drinkItem[0]+ ","+drinkItem[1]+","+drinkItem[2];
            sb.append(nextDrink);
            sb.append("\n\n");
            index++;
        }
        String newMenu = sb.toString();
        return newMenu;
	}

	@Override
	public void updateMenu(String name,boolean inStock) {
		for(String[] drinks : drinksInMenu) {

            if (name.equals(drinks[0].toString())) {
                drinks[2] = Boolean.toString(inStock);
                break;
            }
        }    
		
	}
	 public void createDrink(String drinkName, String drinkCost) {
	        
	        if (this.drinksInMenu == null) {
	            this.drinksInMenu = new ArrayList<String[]>();
	        }
	        
	        String inStock = Boolean.toString(true); // default availability
	        String[] attributes = new String[] { drinkName, drinkCost, inStock };
	        
	        this.drinksInMenu.add(attributes);
	    }

	
}
