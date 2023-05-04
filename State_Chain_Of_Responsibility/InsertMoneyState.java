package State_Chain_Of_Responsibility;

public class InsertMoneyState implements StateOfVendingMachine{

    public void idle(VendingMachine vendingMachine){}
    public void selectSnack(VendingMachine vendingMachine){}

    public void insertMoney(VendingMachine vendingMachine){
        System.out.println("Vending machine in insert money state.");
        double insertedMoney = vendingMachine.getInsertedMoney();
        double price = vendingMachine.getSelectedSnack().getPrice();
        System.out.println("Inserted money - $" + insertedMoney);
        if(insertedMoney >= price){
            vendingMachine.setStateOfVendingMachine(new DispenseSnackState());
            System.out.println("Inserted enough money, transitioning to dispense snack state.");
        }
        else{
            vendingMachine.setStateOfVendingMachine(new IdleState());
            System.out.println("Not enough money inserted, transitioning to idle state.");
            System.out.println("Returning $" + insertedMoney);
            vendingMachine.setInsertedMoney(0.0);
            vendingMachine.setSelectedSnack(null);
        }
    }

    public void dispenseSnack(VendingMachine vendingMachine){}
    
}