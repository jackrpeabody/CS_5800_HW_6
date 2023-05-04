package State_Chain_Of_Responsibility;

public class SelectSnackState implements StateOfVendingMachine{

    public void idle(VendingMachine vendingMachine){}

    public void selectSnack(VendingMachine vendingMachine){
        System.out.println("Vending machine in select snack state.");
        System.out.println("Selected snack - " + vendingMachine.getSelectedSnack());
        vendingMachine.setStateOfVendingMachine(new InsertMoneyState());
        System.out.println("Transitioning to insert money state.");
    }

    public void insertMoney(VendingMachine vendingMachine){}
    public void dispenseSnack(VendingMachine vendingMachine){}
    
}