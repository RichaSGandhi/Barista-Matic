package data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Inventory {
	 private HashMap<String, Integer> ingredientUnits = null;
	 private HashMap<String, Double>  ingredientCosts = null;
	 private static Inventory instance = null;
	 public static Inventory getInstance(){
	        if (instance == null) {
	            instance = new Inventory();
	        }
	        return instance;
	    }
	    public void priceInventory() { 
	        ingredientCosts = new HashMap<String, Double>();        
	        try {
	            ingredientCosts.put("Coffee", 0.75);
	            ingredientCosts.put("Decaf Coffee", 0.75);
	            ingredientCosts.put("Sugar", 0.25);
	            ingredientCosts.put("Cream", 0.25);
	            ingredientCosts.put("Steamed Milk", 0.35);
	            ingredientCosts.put("Foamed Milk", 0.35);
	            ingredientCosts.put("Espresso", 1.10);
	            ingredientCosts.put("Cocoa", 0.90);
	            ingredientCosts.put("Whipped Cream", 1.00);
	        }
	        catch(NullPointerException e) {
	            System.err.println(e.getMessage());
	        }       
	    }

	
	    public void InitializeIngredientsInventory() {  
	        if (ingredientUnits == null)
	            ingredientUnits = new HashMap<String, Integer>();

	        try {
	            ingredientUnits.put("Cocoa", 10);
	            ingredientUnits.put("Coffee", 10);
	            ingredientUnits.put("Cream", 10);
	            ingredientUnits.put("Decaf Coffee", 10);
	            ingredientUnits.put("Espresso", 10);
	            ingredientUnits.put("Foamed Milk", 10);
	            ingredientUnits.put("Steamed Milk", 10);
	            ingredientUnits.put("Sugar", 10);
	            ingredientUnits.put("Whipped Cream", 10);
	        }
	        catch(NullPointerException e) {
	            System.err.println(e.getMessage());
	        }
	    }
	  
	    public boolean isAvailable(HashMap<String, Integer> recipe) {        
	        boolean available = true;
	        try {            
	            Set<Map.Entry<String, Integer>> toBeUsed = recipe.entrySet();        
	            Set<Map.Entry<String, Integer>> stock = this.ingredientUnits.entrySet();

	            int toBeUsedUnits = 0;
	            int stockUnits = 0;

	            boolean availability[] = new boolean[toBeUsed.size()];
	            int recipeIngredientIndex = 0;                  

	            String toBeUsedKey = "";        
	            for (Map.Entry<String, Integer> consumable : toBeUsed) {

	            	toBeUsedKey = consumable.getKey().toString();
	                toBeUsedUnits = consumable.getValue().intValue();

	                for (Map.Entry<String, Integer> ingredient : stock) {
	                    if (ingredient.getKey().equals(toBeUsedKey)) {
	                    	stockUnits = ingredient.getValue().intValue();
	                        availability[recipeIngredientIndex] = (toBeUsedUnits <= stockUnits);
	                        break;
	                    }
	                }
	                recipeIngredientIndex++;
	            }

	            for (int i=0; i < availability.length; i++)
	                available = (available && availability[i]);  
	        }
	        catch(NullPointerException npe) {
	            System.err.println(npe.getMessage());
	            available = false;
	        }
	        return available;
	    }
	    public String getInventoryUnits() {
	        
	        StringBuilder builder = new StringBuilder();
	        builder.append("\nInventory: ");
	        builder.append("\n\n");
	        
	        try {
	            Set<Map.Entry<String, Integer>> stock = ingredientUnits.entrySet();

	            for (Map.Entry<String, Integer> ingredients : stock) {
	                builder.append(ingredients.getKey().toString());
	                builder.append(",");
	                builder.append(ingredients.getValue().intValue());
	                builder.append("\n\n");
	            }
	        }
	        catch(NullPointerException e) {
	            System.err.println(e.getMessage());
	        }
	        
	        return builder.toString();
	    }

	    public void useStock(HashMap<String, Integer> recipe) {                
	        try {
	            Set<Map.Entry<String, Integer>> toBeUsed = recipe.entrySet();
	            Set<Map.Entry<String, Integer>> stock = this.ingredientUnits.entrySet();
	            
	            int stockUnits = 0;
	            int toBeUsedUnits = 0;
	            String toBeUsedName = "";

	            for (Map.Entry<String, Integer> consumable : toBeUsed) {
	            	toBeUsedName  = consumable.getKey().toString();
	            	toBeUsedUnits = consumable.getValue().intValue();

	                for (Map.Entry<String, Integer> ingredient : stock) {
	                    // search for this named ingredient
	                    if (ingredient.getKey().equals(toBeUsedName)) {
	                    	stockUnits = ingredient.getValue().intValue();
	                    	stockUnits -= toBeUsedUnits;
	                    	ingredient.setValue(stockUnits);
	                        break;
	                    }
	                }
	            }            
	        }
	        catch(NullPointerException e) {
	            System.err.println(e.getMessage());
	        }          
	    }
	    public String printInventory() {
	        
	        StringBuilder sb = new StringBuilder();
	        sb.append("\nInventory");
	        sb.append("\n\n");
	        
	        try {
	            Set<Map.Entry<String, Integer>> stock = ingredientUnits.entrySet();

	            for (Map.Entry<String, Integer> stockAmounts : stock) {
	                sb.append(stockAmounts.getKey().toString());
	                sb.append(",");
	                sb.append(stockAmounts.getValue().intValue());
	                sb.append("\n\n");
	            }
	        }
	        catch(NullPointerException e) {
	            System.err.println(e.getMessage());
	        }
	        
	        return sb.toString();
	    }

	    
}
