package beans;

import java.text.DecimalFormat;
import java.util.HashMap;

import data.Inventory;
import service.MenuImpl;

public class CafeLatte extends Drink{
	private final String LATTE = "Caffe Latte";
	private HashMap<String, Integer> ingredients = null;
	private MenuImpl drinkMenu = null;
	public DecimalFormat costFormatter = new DecimalFormat("$0.00");
	//private Inventory inventory = null;
	 public CafeLatte() {
		//inventory = super.getStockInventory();
	    drinkMenu = super.getDrinkMenu();
        this.setName(LATTE);     
        ingredients = new HashMap<String, Integer>();
        ingredients.put("Espresso", 2);
        ingredients.put("Steamed Milk", 1);
        this.setRecipe(ingredients); 
        drinkMenu.createDrink(this.getName(), this.calculateCost());
 }
	@Override
	public String calculateCost() {
		Ingredient i1 = new Ingredient("Expresso",2,1.10);
		Ingredient i2 = new Ingredient("Steamed Milk",1,0.35);
		double cost = i1.GetCostByIngredient()+i2.GetCostByIngredient();
		return costFormatter.format(cost);
	}

	@Override
	public boolean checkAvailabilty() {
		 return super.checkAvailabilty();	
	}


	@Override
	public void updateInventory() {	
		super.updateInventory();	
	}

}
