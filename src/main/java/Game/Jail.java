package Game;
import Controller.*;

/**
 * @author Lucas
 */

public class Jail {
    private int bail = 1000;

    /**
     * @param playerController
     * @return void
     * When executed, the currentPlayer gets bail subtracted from their account.
     */

    public void payBail(Language language, GUIController guiController, PlayerController playerController){
        playerController.getCurrentPlayer().subtractBalance(bail);
        playerController.getCurrentPlayer().setInJail(false);
        playerController.getCurrentPlayer().setTurnsInJail(0);
        guiController.showMessage(language.getText(11,3)); // "You are out of jail."
    }

    /**
     * @param dieController
     * @param playerController
     * @param language
     * @return void
     * If player chooses to rollDiceToGetOut in GUI, he/she rolls the dice and sets isInJail status as false
     * for the currentPlayer object.
     */

    public void rollDiceToGetOut(Language language, GUIController guiController, DieController dieController, GameBoard gameboard, PlayerController playerController){
        dieController.diceRoll(guiController);
        if(dieController.isDouble())
        {
            playerController.getCurrentPlayer().setInJail(false);
            guiController.showMessage(language.getText(11,2)); // print "You are out of jail."
            gameboard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition()].getGUIField().setCar(playerController.getCurrentPlayer().getGUIPlayer(),false);
            playerController.getCurrentPlayer().setPlayerPosition(playerController.getCurrentPlayer().getPlayerPosition()+dieController.diceValue());
            gameboard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition()].getGUIField().setCar(playerController.getCurrentPlayer().getGUIPlayer(), true);
            playerController.getCurrentPlayer().setDoubleCounter(1);
            playerController.getCurrentPlayer().setHasRolledToGetOutOfJail(true);
        }
        else
        {
            playerController.getCurrentPlayer().setTurnsInJail(playerController.getCurrentPlayer().getTurnsInJail()+1);
        }
    }

    /**
     *
     * @param playerController
     * @param language
     * @return void
     * If a player chooses to useGetOutOfJailCard in GUI, the currentPlayer object's isInJail variable is
     * set to false. Meanwhile, they lose a getOutOfJailCard.
     */
    public void useGetOutOfJailCard(Language language, GUIController guiController, PlayerController playerController){
        playerController.getCurrentPlayer().setInJail(false);
        playerController.getCurrentPlayer().setTurnsInJail(0);
        playerController.getCurrentPlayer().setGetOutOfJailCard(playerController.getCurrentPlayer().getGetOutOfJailCard() - 1);
        guiController.showMessage(language.getText(11,4)); //print "You are out of jail."
    }

    /**
     *
     * @param dieController
     * @param playerController
     * @param guiController
     * @param gameboard
     * @param language
     * @return void
     * Introduces GUIButtons for player to choose a method to get out of jail.
     */
    public void inJail(Language language, GUIController guiController, DieController dieController,
                        GameBoard gameboard, PlayerController playerController){
        if(playerController.getCurrentPlayer().getGetOutOfJailCard() > 0) {
            String buttons = guiController.buttons(playerController.getCurrentPlayer().getName()+" "+language.getText(11, 5), language.getText(11, 6),
                    language.getText(11, 7), language.getText(11, 8)); // "1: Choose option", "2: Pay Bail", "3: Roll Dice", "4: use Jail Card".
            if (buttons.equals(language.getText(11, 6))) {
                payBail(language, guiController, playerController);
            }
            else if (buttons.equals(language.getText(11, 7))) {
                rollDiceToGetOut(language, guiController, dieController, gameboard, playerController);
            }
            else if (buttons.equals(language.getText(11, 8))) {
                useGetOutOfJailCard(language, guiController, playerController);
            }
        }
        else if (playerController.getCurrentPlayer().getGetOutOfJailCard() == 0){
            String buttons = guiController.buttons(playerController.getCurrentPlayer().getName()+" "+language.getText(11, 5), language.getText(11, 6),
                    language.getText(11, 7)); // "1: Choose option", "2: Pay Bail", "3: Roll Dice"
            if (buttons.equals(language.getText(11, 6))) {
                payBail(language, guiController, playerController);
            }
            else if (buttons.equals(language.getText(11, 7))) {
                rollDiceToGetOut(language, guiController, dieController, gameboard, playerController);
            }
        }
        }
}
