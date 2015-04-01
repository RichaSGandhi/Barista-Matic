package beans;

import java.util.HashMap;

import service.MenuImpl;
import data.Inventory;
public abstract class Drink {
	
	private String name;  
    private String cost;
    private HashMap<String, Integer> recipe;
	private Inventory stockInventory = null;
    private MenuImpl drinkMenu = null;
    
    public Drink() {
        stockInventory = Inventory.getInstance();
        drinkMenu = MenuImpl.getInstance();
       
    }
    public HashMap<String, Integer> getRecipe() {
		return recipe;
	}
	public void setRecipe(HashMap<String, Integer> recipe) {
		this.recipe = recipe;
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public Inventory getStockInventory() {
			return stockInventory;
	}
		
	public MenuImpl getDrinkMenu() {
			return drinkMenu;
	}
		
	public abstract String calculateCost();
	public  boolean checkAvailabilty(){
		  boolean check = stockInventory.isAvailable(
	                this.getRecipe());
	        
		  drinkMenu.updateMenu(this.getName(),check);
	        
	        return check;
	}
	public String dispenseDrink() {                
        String message = "";
        String msg = "";
        
        // Is drink possibly unavailable?
        if (this.checkAvailabilty()) {            
        	stockInventory.useStock(this.getRecipe());
        	
        	msg = "\nDispensing:";
        }
        else {
        	msg = "\nOut of stock:";
        }
        
        message = (msg + " " +this.getName()).toString();
        
        return message;
    }
	
	public void updateInventory(){
		stockInventory.useStock(this.recipe);
	}
  

}
