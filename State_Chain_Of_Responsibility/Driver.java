package State_Chain_Of_Responsibility;

import java.util.*;

public class Driver {
 
    public static void main(String[] args){

        // NOTE: Based on the given problem description I made the assumption that 
        // any failure such as not enough money inserted or not enough quantity results
        // in the money being returned and the vending machine transitioning to idle.

        // Create driver with 6 different snacks and Chain of Command in this order 
        // -> Coke, Pepsi, Cheetos, Doritos, KitKat, and Snickers.
        Snack coke = new Snack("Coke", 1.00, 10);
        Snack pepsi = new Snack("Pepsi", 1.50, 5);
        Snack cheetos = new Snack("Cheetos", 2.00, 3);
        Snack doritos = new Snack("Doritos", 2.50, 3);
        Snack kitKat = new Snack("KitKat", 3.00, 2);
        Snack snickers = new Snack("Snickers", 3.50, 1);
        ArrayList<Snack> snacks = new ArrayList<Snack>(Arrays.asList(coke, pepsi, 
                                                                     cheetos, doritos,
                                                                     kitKat, snickers));
        SnackDispenseHandler snackDispenseHandler = new CokeDispenseHandler(
                                                    new PepsiDispenseHandler(
                                                    new CheetosDispenseHandler(
                                                    new DoritosDispenseHandler(
                                                    new KitKatDispenseHandler(
                                                    new SnickersDispenseHandler(null))))));
        VendingMachine vendingMachine = new VendingMachine(snackDispenseHandler, snacks);
        
        System.out.println("\nCase where there is enough money and quantity:\n");

        // Vending machine starts in idle state.
        vendingMachine.idle();

        // User should select a snack, selectSnack(), from Vending Machine.
        vendingMachine.selectSnack(coke);

        // Vending machine should wait for user to insert money, insertMoney().
        // If money inserted is >= price then dispense item if enough quantity.
        vendingMachine.insertMoney(2.00);

        // To dispense snack, the VendingMachine class should call the dispenseSnack() method 
        // on the current state object. The state object will handle the event and transition 
        // to the appropriate state based on the availability of snacks.
        vendingMachine.dispenseSnack();

        System.out.println(vendingMachine);

        System.out.println("\nCase where is not enough money:\n");

        vendingMachine.idle();
        vendingMachine.selectSnack(snickers);
        vendingMachine.insertMoney(3.00);
        vendingMachine.dispenseSnack();
        System.out.println(vendingMachine);

        System.out.println("\nCase where quantity hits 0 with snickers:\n");

        vendingMachine.idle();
        vendingMachine.selectSnack(snickers);
        vendingMachine.insertMoney(3.50);
        vendingMachine.dispenseSnack();
        System.out.println(vendingMachine);

        System.out.println("\nCase where there is no more quantity:\n");

        vendingMachine.idle();
        vendingMachine.selectSnack(snickers);
        vendingMachine.insertMoney(4.00);
        vendingMachine.dispenseSnack();
        System.out.println(vendingMachine);
        
    }

}
