package app;

import java.util.Scanner;

import beans.CafeLatte;
import beans.CafeMocha;
import beans.CaffeAmericano;
import beans.Cappuccino;
import beans.Coffee;
import beans.DecafCoffee;
import service.MenuImpl;
import data.Inventory;

public class MainBaristaMaticApp {
	public static void main(String[] args) throws Exception {
        
        // I am using a singleton Pattern here so that only 1 instance of Inventory and Menu are created.
		Inventory inventory = Inventory.getInstance();
        inventory.InitializeIngredientsInventory();
        inventory.priceInventory();
        MenuImpl mainMenu  = MenuImpl.getInstance();
        
        Coffee coffee = new Coffee();
        
        DecafCoffee decaf = new DecafCoffee();
     
        CaffeAmericano americano = new CaffeAmericano();
        
        CafeLatte latte = new CafeLatte();
      
        CafeMocha mocha = new CafeMocha();
        
        Cappuccino cappuccino = new Cappuccino();
    
        boolean quit = false;

        int selection = 0;
        Scanner scanner = new Scanner(System.in);        
        while(true) {
                    
            StringBuilder sb = new StringBuilder();            
            sb.append(inventory.printInventory());
            sb.append(mainMenu.printMenu());

            System.out.print(sb.toString());
            System.out.println("\n");
            String userEntered = "";
         
                userEntered = scanner.nextLine();
                try {
                selection = Character.getNumericValue(
                		userEntered.charAt(0));
                }catch(Exception e){
                	e.printStackTrace();
                }

            String actionTaken = "";
            switch(selection) {

                case 1:
                    actionTaken = americano.dispenseDrink();
                    break;
                case 2:
                    actionTaken = latte.dispenseDrink();
                    break;
                case 3:
                    actionTaken = mocha.dispenseDrink();
                    break;
                case 4:
                    actionTaken = cappuccino.dispenseDrink();
                    break;
                case 5:
                    actionTaken = coffee.dispenseDrink();
                    break;
                case 6:
                    actionTaken = decaf.dispenseDrink();
                    break;


                default:                    
                    actionTaken = ("\nInvalid Entry:"+" "+userEntered).toString();
                    break;
                    
            }

            if (quit)
                break;
            
            if (!actionTaken.isEmpty())
                System.out.println(actionTaken);
   
            americano.checkAvailabilty();
            latte.checkAvailabilty();
            mocha.checkAvailabilty();
            cappuccino.checkAvailabilty();
            coffee.checkAvailabilty();
            decaf.checkAvailabilty();    
               
        }
        scanner.close();
 
    } 
    
}
