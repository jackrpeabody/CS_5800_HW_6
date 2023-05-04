package State_Chain_Of_Responsibility;

public class KitKatDispenseHandler extends SnackDispenseHandler{

    public KitKatDispenseHandler(SnackDispenseHandler next){
        super(next);
    }

    public void dispenseSnack(Snack snack){
        if(snack.getName() == "KitKat"){
            System.out.println("Dispensing KitKat.");
            snack.setQuantity(snack.getQuantity() - 1);
        }
        else{
            super.dispenseSnack(snack);
        }
    }
}