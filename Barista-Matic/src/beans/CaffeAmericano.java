package beans;

import java.util.HashMap;

public class CaffeAmericano extends Drink {
	private final String AMERICANO = "Caffe Americano";
	private HashMap<String, Integer> ingredients = null;
	
	public CaffeAmericano(){
		this.setName(AMERICANO);
        ingredients = new HashMap<String, Integer>();
        ingredients.put("Espresso", 3);
        this.setRecipe(ingredients);
	}
	@Override
	public String calculateCost() {
		Ingredient i = new Ingredient("Expresso",3,1.10);
		double cost = i.GetCostByIngredient();
		return String.valueOf(cost);
	}

	@Override
	public boolean checkAvailabilty() {
		 return super.checkAvailabilty();	
	}

	@Override
	public void updateInventory() {
		
		
	}
	

}
