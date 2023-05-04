package State_Chain_Of_Responsibility;

public class DispenseSnackState extends SelectSnackState{
    
    public void idle(VendingMachine vendingMachine){}
    public void selectSnack(VendingMachine vendingMachine){}
    public void insertMoney(VendingMachine vendingMachine){}

    public void dispenseSnack(VendingMachine vendingMachine){
        System.out.println("Vending machine in dispense snack state.");
        int quantity = vendingMachine.getSelectedSnack().getQuantity();
        double insertedMoney = vendingMachine.getInsertedMoney();
        double price = vendingMachine.getSelectedSnack().getPrice();
        if(quantity - 1 >= 0){
            System.out.println("Enough quantity, dispensing snack.");
            vendingMachine.getSnackDispenseHandler().dispenseSnack(vendingMachine.getSelectedSnack());
            if(insertedMoney > price){
                System.out.println("Transitioning to idle state.");
                System.out.println("Returning change $" + (insertedMoney - price));
            }
        }
        else{
            System.out.println("No more quantity, transitioning to idle state.");
            System.out.println("Returning $" + insertedMoney);
        }
        vendingMachine.setStateOfVendingMachine(new IdleState());
        vendingMachine.setInsertedMoney(0.0);
        vendingMachine.setSelectedSnack(null);
    }
    
}