package Game;

import Controller.GUIController;
import Controller.PlayerController;

/**
 * @Author Isak
 */

public class JailChanceCard extends ChanceCard
{
    private int getChanceCardID;

    public JailChanceCard(int chanceCardID)
    {
        super(chanceCardID);
    }

    public void getOutOfJailCard(Language language, GUIController guiController, PlayerController playerController)
    {
        guiController.showChanceCard(language.getText(28,2));
        playerController.getCurrentPlayer().setGetOutOfJailCard(playerController.getCurrentPlayer().getGetOutOfJailCard()+1);
    }

    public void goToJailCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        guiController.showChanceCard(language.getText(28,3));
        gameboard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition()].getGUIField().setCar(playerController.getCurrentPlayer().getGUIPlayer(),false);
        playerController.getCurrentPlayer().setPlayerPosition(10);
        gameboard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition()].getGUIField().setCar(playerController.getCurrentPlayer().getGUIPlayer(), true);
        playerController.getCurrentPlayer().setInJail(true);
    }
}
