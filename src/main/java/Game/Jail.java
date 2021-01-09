package Game;
import Controller.*;

/**
 * @author Lucas
 */

public class Jail {
    private int bail = 1000;

    /**
     * @param currentPlayer
     * When executed, the currentPlayer gets bail subtracted from their account.
     */

    public void payBail(Player currentPlayer){
        currentPlayer.getAccount().subtractBalance(bail);
    }

    public void rollDiceToGetOut(DieController dieController, Player currentPlayer,
                                 Language language){
        dieController.diceRoll();

        if(dieController.isDouble()){
            currentPlayer.isInJail(false);
            language.getText(0,0); // print "You are out of jail".
        }
    }
}
