package beans;
/**
 * @author Richa
 */
import java.text.DecimalFormat;
import java.util.HashMap;

import service.MenuImpl;

public class CafeMocha extends Drink {
	private final String MOCHA = "Caffe Mocha";
	private HashMap<String, Integer> ingredients = null;
	private MenuImpl drinkMenu = null;
	public DecimalFormat costFormatter = new DecimalFormat("$0.00");
	public CafeMocha(){
	 this.setName(MOCHA);
	 drinkMenu = super.getDrinkMenu();
     ingredients = new HashMap<String, Integer>();
     ingredients.put("Espresso", 1);
     ingredients.put("Cocoa", 1);
     ingredients.put("Steamed Milk", 1);
     ingredients.put("Whipped Cream", 1);
     this.setRecipe(ingredients);
     drinkMenu.createDrink(this.getName(), this.calculateCost());
	}
	
	@Override
	public String calculateCost() {
		Ingredient i1 = new Ingredient("Expresso",1,1.10);
		Ingredient i2 = new Ingredient("Steamed Milk",1,0.35);
		Ingredient i3 = new Ingredient("Whipped Cream",1,1.00);
		Ingredient i4 = new Ingredient("Cocoa",1,0.90);
		double cost = i1.GetCostByIngredient()+i2.GetCostByIngredient()+
				i3.GetCostByIngredient()+i4.GetCostByIngredient();
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
