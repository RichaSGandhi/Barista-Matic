package app;
/**
 * @author Richa
 */
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
        
        MenuImpl mainMenu  = MenuImpl.getInstance();
        
        CaffeAmericano americano = new CaffeAmericano();
        CafeLatte latte = new CafeLatte();
        CafeMocha mocha = new CafeMocha();
        Cappuccino cappuccino = new Cappuccino();
        Coffee coffee = new Coffee(); 
        DecafCoffee decaf = new DecafCoffee();  
        
        boolean quit = false;

        int selection = 0;
        Scanner scanner = new Scanner(System.in);        
        while(true) {
                    
            StringBuilder sb = new StringBuilder();            
            sb.append(inventory.printInventory());
            sb.append(mainMenu.printMenu());

            System.out.print(sb.toString());
            //System.out.println("\n");
            String userEntered = "";
         
              userEntered = scanner.nextLine();
              while(userEntered.isEmpty() || userEntered.trim().equals("") || userEntered.trim().equals("\n"))
            	  userEntered = scanner.nextLine(); 
              //Checking Length in case the invalid characters start with r or q or any valid selections
              if (userEntered.length() >1)
            	 selection = 0;
              else
                selection = Character.getNumericValue(
                		userEntered.charAt(0));
            String choice = "";
            switch(selection) {

                case 1:
                	choice = americano.dispenseDrink();
                    break;
                case 2:
                	choice = latte.dispenseDrink();
                    break;
                case 3:
                	choice = mocha.dispenseDrink();
                    break;
                case 4:
                	choice = cappuccino.dispenseDrink();
                    break;
                case 5:
                	choice = coffee.dispenseDrink();
                    break;
                case 6:
                	choice = decaf.dispenseDrink();
                    break;
                //Since the numeric value of character q or Q is 26. 
                case 26:
                    quit=true;
                    break;
                //Since the numeric value of character r and R is 27. 
                case 27:
                	inventory.InitializeIngredientsInventory();
                    break;


                default:                    
                	choice = ("\nInvalid Entry:"+" "+userEntered).toString();
                    break;
                    
            }

            if (quit)
                break;
            
            if (!choice.isEmpty())
                System.out.println(choice);
   
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
