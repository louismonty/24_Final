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

    public void goToJailCard(Language language, GUIController guiController, PlayerController playerController)
    {
        guiController.showChanceCard(language.getText(28,3));
        playerController.getCurrentPlayer().setPlayerPosition(10);
        playerController.getCurrentPlayer().setInJail(true);
    }
}
