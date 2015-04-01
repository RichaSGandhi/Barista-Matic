package service;

//Using this Menu interface to set up the service used for printing the Menu
//And updating the Menu after every dispense.
public interface Menu {
	
	public String printMenu();
	public void updateMenu(String name, boolean inStock);
	public void createDrink(String Name, String cost);

}
