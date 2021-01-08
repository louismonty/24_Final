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

    public void stockDividendsCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.getAccount().addBalance(1000);
    }

    public void taxReturnCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.getAccount().addBalance(3000);
    }

    public void gamblingCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.getAccount().addBalance(1000);
    }

    public void salaryIncreaseCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.getAccount().addBalance(1000);
    }

    public void premiumBondCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.getAccount().addBalance(1000);
    }

    public void soldFurnitureCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.getAccount().addBalance(1000);
    }

    public void utilityGardenCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.getAccount().addBalance(200);
    }

    public void matadorGrantCard()
    {

    }

}
