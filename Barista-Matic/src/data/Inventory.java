package data;
/**
 * @author Richa
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Inventory {
	 private HashMap<String, Integer> ingredientUnits = null;
	 private TreeMap<String, Integer> sortedIngredients = null;
	 private static Inventory instance = null;
	 public static Inventory getInstance(){
	        if (instance == null) {
	            instance = new Inventory();
	        }
	        return instance;
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
	    public void sortingInventory(){
	    	if (sortedIngredients == null)
	    		sortedIngredients = new TreeMap<String, Integer>();
	        else
	        	sortedIngredients.clear(); 
	        	sortedIngredients.putAll(ingredientUnits);
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
	    	sortingInventory();
	        StringBuilder sb = new StringBuilder();
	        sb.append("\nInventory:");
	        sb.append("\n\n");
	        
	        try {
	            Set<Map.Entry<String, Integer>> stock = sortedIngredients.entrySet();

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
