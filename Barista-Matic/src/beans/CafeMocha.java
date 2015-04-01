package beans;

import java.util.HashMap;

public class CafeMocha extends Drink {
	private final String MOCHA = "Caffe Mocha";
	private HashMap<String, Integer> ingredients = null;

	public CafeMocha(){
	 this.setName(MOCHA);
     ingredients = new HashMap<String, Integer>();
     ingredients.put("Espresso", 1);
     ingredients.put("Cocoa", 1);
     ingredients.put("Steamed Milk", 1);
     ingredients.put("Whipped Cream", 1);
     this.setRecipe(ingredients);
	}
	
	@Override
	public String calculateCost() {
		Ingredient i1 = new Ingredient("Expresso",1,1.10);
		Ingredient i2 = new Ingredient("Steamed Milk",1,0.35);
		Ingredient i3 = new Ingredient("Whipped Cream",1,1.00);
		Ingredient i4 = new Ingredient("Cocoa",1,0.90);
		double cost = i1.GetCostByIngredient()+i2.GetCostByIngredient()+
				i3.GetCostByIngredient()+i4.GetCostByIngredient();
		return String.valueOf(cost);
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
