package beans;

import java.util.HashMap;

public class Coffee extends Drink {
	private HashMap<String, Integer> ingredients = null;
	private final String COFFEE = "Coffee";
	
	public Coffee(){
		 this.setName(COFFEE);
	        ingredients = new HashMap<String, Integer>();
	        ingredients.put(COFFEE, 3);
	        ingredients.put("Sugar", 1);
	        ingredients.put("Cream", 1);
	        this.setRecipe(ingredients);
	}
	@Override
	public String calculateCost() {
		Ingredient i1 = new Ingredient("Coffee",3,0.75);
		Ingredient i2 = new Ingredient("Sugar",1,0.25);
		Ingredient i3 = new Ingredient("Cream",1,0.25);	
		double cost = i1.GetCostByIngredient()+i2.GetCostByIngredient()+
				i3.GetCostByIngredient();
		return String.valueOf(cost);
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
