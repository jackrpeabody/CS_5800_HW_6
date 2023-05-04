package State_Chain_Of_Responsibility;

public class IdleState implements StateOfVendingMachine{
    
    public void idle(VendingMachine vendingMachine){
        System.out.println("Vending machine in idle state.");
        vendingMachine.setStateOfVendingMachine(new SelectSnackState());
        System.out.println("Transitioning to select snack state.");
    }

    public void selectSnack(VendingMachine vendingMachine){}
    public void insertMoney(VendingMachine vendingMachine){}
    public void dispenseSnack(VendingMachine vendingMachine){}

}