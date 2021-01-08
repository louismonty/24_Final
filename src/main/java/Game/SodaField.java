package Game;
import Controller.DieController;

public class SodaField extends BuyableField {

    private int rent = 100;

    public boolean isPairBought() {
        if(Player.getOwnedFields().contains("Squash","CocaCola")) {
            return true;
        }
    }
    public void rentSodaMultiplier(DieController dieController) {
        if(isPairBought()) {
            rent = (rent*dieController.diceValue())*2;
        }
        else {
            rent = (rent*dieController.diceValue());
        }
    }

}
