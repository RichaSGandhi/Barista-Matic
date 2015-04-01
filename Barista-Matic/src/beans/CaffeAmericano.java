package beans;
/**
 * @author Richa
 */
import java.text.DecimalFormat;
import java.util.HashMap;

import service.MenuImpl;

public class CaffeAmericano extends Drink {
	private final String AMERICANO = "Caffe Americano";
	private HashMap<String, Integer> ingredients = null;
	private MenuImpl drinkMenu = null;
	public DecimalFormat costFormatter = new DecimalFormat("$0.00");
	public CaffeAmericano(){
		drinkMenu = super.getDrinkMenu();
		this.setName(AMERICANO);
        ingredients = new HashMap<String, Integer>();
        ingredients.put("Espresso", 3);
        this.setRecipe(ingredients);
        drinkMenu.createDrink(this.getName(), this.calculateCost());
	}
	@Override
	public String calculateCost() {
		Ingredient i = new Ingredient("Expresso",3,1.10);
		double cost = i.GetCostByIngredient();
		return costFormatter.format(cost);
	}

	@Override
	public boolean checkAvailabilty() {
		 return super.checkAvailabilty();	
	}

	@Override
	public void updateInventory() {
		
		
	}
	

}
