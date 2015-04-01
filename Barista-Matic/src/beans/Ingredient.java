package beans;
/**
 * @author Richa
 */
public class Ingredient {
	public String Name ;
    public int Units ;
    public double UnitCost ;

	public Ingredient(String name,int units,double cost){
		this.Name = name;
		this.Units = units;
		this.UnitCost = cost;
	}
	 public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getUnits() {
		return Units;
	}

	public void setUnits(int units) {
		Units = units;
	}

	public double getUnitCost() {
		return UnitCost;
	}

	public void setUnitCost(double unitCost) {
		UnitCost = unitCost;
	}
     public double GetCostByIngredient()
     {
         return UnitCost * Units;
     }
}
