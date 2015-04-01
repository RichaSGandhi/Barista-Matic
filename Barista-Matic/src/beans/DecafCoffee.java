package beans;
/**
 * @author Richa
 */
import java.text.DecimalFormat;
import java.util.HashMap;

import service.MenuImpl;

public class DecafCoffee extends Drink {
	private final String DECAF = "Decaf Coffee"; 
	private HashMap<String, Integer> ingredients = null;
	public DecimalFormat costFormatter = new DecimalFormat("$0.00");
	private MenuImpl drinkMenu = null;
	public DecafCoffee() {
		drinkMenu = super.getDrinkMenu();
		this.setName(DECAF);
	    ingredients = new HashMap<String, Integer>();
	    ingredients.put(DECAF, 3);
	    ingredients.put("Sugar", 1);
	    ingredients.put("Cream", 1);
	    this.setRecipe(ingredients);
	    drinkMenu.createDrink(this.getName(), this.calculateCost());
	}
	
	@Override
	public String calculateCost() {
		Ingredient i1 = new Ingredient("Decaf Coffee",3,0.75);
		Ingredient i2 = new Ingredient("Sugar",1,0.25);
		Ingredient i3 = new Ingredient("Cream",1,0.25);	
		double cost = i1.GetCostByIngredient()+i2.GetCostByIngredient()+
				i3.GetCostByIngredient();
		return costFormatter.format(cost);
	}

	@Override
	public boolean checkAvailabilty() {
		 return super.checkAvailabilty();	
	}

	@Override
	public void updateInventory() {
		// TODO Auto-generated method stub
		
	}

}
