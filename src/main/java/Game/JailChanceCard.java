package Game;

import Controller.GUIController;

/**
 * @Author Isak Risager
 */

public class JailChanceCard extends ChanceCard
{
    private int getChanceCardID;

    public JailChanceCard(int chanceCardID)
    {
        super(chanceCardID);
    }

    public void getOutOfJailCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.setGetOutOfJailCard(currentPlayer.getGetOutOfJailCard()+1);
    }

    public void goToJailCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.setPlayerPosition(10);
        currentPlayer.setInJail(true);
    }
}
