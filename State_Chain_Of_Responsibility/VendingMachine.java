package State_Chain_Of_Responsibility;

import java.util.ArrayList;

public class VendingMachine {
    
    private StateOfVendingMachine stateOfVendingMachine;
    private Snack selectedSnack;
    private double insertedMoney;
    private SnackDispenseHandler snackDispenseHandler;
    private ArrayList<Snack> snacks;

    public VendingMachine(SnackDispenseHandler snackDispenseHandler, ArrayList<Snack> snacks){
        this.stateOfVendingMachine = new IdleState();
        this.selectedSnack = null;
        this.insertedMoney = 0.0;
        this.snackDispenseHandler = snackDispenseHandler;
        this.snacks = snacks;
    }

    public StateOfVendingMachine getStateOfVendingMachine(){
        return this.stateOfVendingMachine;
    }

    public void setStateOfVendingMachine(StateOfVendingMachine stateOfVendingMachine){
        this.stateOfVendingMachine = stateOfVendingMachine;
    }

    public Snack getSelectedSnack(){
        return this.selectedSnack;
    }

    public void setSelectedSnack(Snack selectedSnack){
        this.selectedSnack = selectedSnack;
    }

    public double getInsertedMoney(){
        return this.insertedMoney;
    }

    public void setInsertedMoney(double insertedMoney){
        this.insertedMoney = insertedMoney;
    }

    public SnackDispenseHandler getSnackDispenseHandler(){
        return this.snackDispenseHandler;
    }

    public void setSnackDispenseHandler(SnackDispenseHandler snackDispenseHandler){
        this.snackDispenseHandler = snackDispenseHandler;
    }

    public ArrayList<Snack> getSnacks(){
        return this.snacks;
    }

    public void setSnacks(ArrayList<Snack> snacks){
        this.snacks = snacks;
    }

    public void idle(){
        getStateOfVendingMachine().idle(this);
    }

    public void selectSnack(Snack snack){
        this.setSelectedSnack(snack);
        getStateOfVendingMachine().selectSnack(this);
    }

    public void insertMoney(double money){
        this.setInsertedMoney(money);
        getStateOfVendingMachine().insertMoney(this);
    }

    public void dispenseSnack(){
        getStateOfVendingMachine().dispenseSnack(this);
    }

    public String toString(){
        String output = "Vending machine status -";
        output += "\n   State: " + getStateOfVendingMachine();
        output += "\n   Selection: " + getSelectedSnack();
        output += "\n   Inserted Money: $" + getInsertedMoney();
        for(Snack snack: getSnacks()){
            output += "\n   " + snack.toString();
        }
        return output;
    }
}
