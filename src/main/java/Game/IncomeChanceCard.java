package Game;

import Controller.GUIController;

/**
 * @author Isak Risager
 */
public class IncomeChanceCard extends ChanceCard
{
    private int chanceCardID;

    public IncomeChanceCard(int chanceCardID)
    {
        super(chanceCardID);
    }

    public void lotteryCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.getAccount().addBalance(500);
    }
}
