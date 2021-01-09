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

    /**
     * @param dieController
     * @param currentPlayer
     * @param language
     * @return void
     * If player chooses to rollDiceToGetOut in GUI, he/she rolls the dice and sets isInJail status as false
     * for the currentPlayer object.
     */

    public void rollDiceToGetOut(DieController dieController, Player currentPlayer,
                                 Language language){
        dieController.diceRoll();

        if(dieController.isDouble()){
            currentPlayer.isInJail(false);
            language.getText(0,0); // print "You are out of jail."
        }
    }

    /**
     *
     * @param currentPlayer
     * @param language
     * @return void
     * If a player chooses to useGetOutOfJailCard in GUI, the currentPlayer object's isInJail variable is
     * set to false. Meanwhile, they lose a getOutOfJailCard.
     */
    public void useGetOutOfJailCard(Player currentPlayer, Language language){
        currentPlayer.isInJail(false);
        language.getText(0,0); //print "You are out of jail."
    }


}
