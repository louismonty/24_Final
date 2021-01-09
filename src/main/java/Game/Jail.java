package Game;
import Controller.*;

/**
 * @author Lucas
 */

public class Jail {
    private int bail = 1000;

    /**
     * @param currentPlayer
     * A player can choose to pay bail to get out of jail.
     */

    public void payBail(Player currentPlayer){
        currentPlayer.getAccount().subtractBalance(bail);
    }
}
