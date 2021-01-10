package Game;

import Controller.GUIController;

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

    public void getOutOfJailCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(28,2));
        currentPlayer.setGetOutOfJailCard(currentPlayer.getGetOutOfJailCard()+1);
    }

    public void goToJailCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(28,3));
        currentPlayer.setPlayerPosition(10);
        currentPlayer.setInJail(true);
    }
}
