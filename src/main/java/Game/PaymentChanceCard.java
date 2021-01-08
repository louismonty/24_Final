package Game;

import Controller.GUIController;

/**
 * @Author Isak Risager
 */
public class PaymentChanceCard extends ChanceCard
{
    private int chanceCardID;

    public PaymentChanceCard(int chanceCardID)
    {
        super(chanceCardID);
    }

    public void oilPricesCard(Player currentPlayer)
    {

    }

    public void propertyTaxCard()
    {

    }

    public void redLightCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.subtractBalance(1000);
    }

    public void carWashCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.subtractBalance(300);
    }

    public void beerCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.subtractBalance(200);
    }

    public void carRepairCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.subtractBalance(3000);
    }

    public void newTiresCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.subtractBalance(1000);
    }

    public void parkingTicketCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.subtractBalance(200);
    }

    public void carInsuranceCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.subtractBalance(1000);
    }

    public void cigaretteCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.subtractBalance(200);
    }

    public void dentistCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.subtractBalance(2000);
    }

}
