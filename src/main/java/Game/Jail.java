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


}
