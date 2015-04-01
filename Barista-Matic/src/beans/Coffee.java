package beans;
/**
 * @author Richa
 */
import java.text.DecimalFormat;
import java.util.HashMap;

import service.MenuImpl;

public class Coffee extends Drink {
	private HashMap<String, Integer> ingredients = null;
	private final String COFFEE = "Coffee";
	private MenuImpl drinkMenu = null;
	public DecimalFormat costFormatter = new DecimalFormat("$0.00");
	public Coffee(){
		drinkMenu = super.getDrinkMenu();
		 this.setName(COFFEE);
	        ingredients = new HashMap<String, Integer>();
	        ingredients.put(COFFEE, 3);
	        ingredients.put("Sugar", 1);
	        ingredients.put("Cream", 1);
	        this.setRecipe(ingredients);
	        drinkMenu.createDrink(this.getName(), this.calculateCost());
	}
	@Override
	public String calculateCost() {
		Ingredient i1 = new Ingredient("Coffee",3,0.75);
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
