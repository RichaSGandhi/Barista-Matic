package beans;

import java.util.HashMap;

public class Cappuccino extends Drink {
	private final String CAPPUCCINO = "Cappuccino";
    private HashMap<String, Integer> ingredients = null;
    
    public Cappuccino(){
    	this.setName(CAPPUCCINO);
        ingredients = new HashMap<String, Integer>();
        ingredients.put("Espresso", 2);
        ingredients.put("Steamed Milk", 1);
        ingredients.put("Foamed Milk", 1);
        this.setRecipe(ingredients);
    }
	@Override
	public String calculateCost() {
		Ingredient i1 = new Ingredient("Expresso",2,1.10);
		Ingredient i2 = new Ingredient("Steam Milk",1,0.35);
		Ingredient i3 = new Ingredient("Foam Milk",1,0.35);
		double cost = i1.GetCostByIngredient() +i2.GetCostByIngredient()+
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
