package Game;

import Controller.GUIController;
import Controller.PlayerController;

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

    public void addBalanceFromCard(GUIController guiController, Language language, PlayerController playerController, int amount, int textColumn)
    {
        guiController.showChanceCard(language.getText(25,textColumn));
        playerController.getCurrentPlayer().addBalance(amount);
    }
    public void receiveMoneyFromOthers(GUIController guiController, Language language, PlayerController playerController, int amount, int textColumn)
    {
    guiController.showChanceCard(language.getText(25,textColumn));
        for(int i = 0; i < playerController.getPlayerArray().length; i++)
        {
            playerController.getCurrentPlayer().addBalance(amount);
            playerController.getPlayerArray()[i].subtractBalance(amount);
        }
    }

    public void lotteryCard(PlayerController playerController, GUIController guiController, Language language)
    {
        addBalanceFromCard(guiController, language, playerController, 500, 2);
    }

    public void stockDividendsCard(PlayerController playerController, GUIController guiController, Language language)
    {
        addBalanceFromCard(guiController, language, playerController, 1000, 3);
    }

    public void taxReturnCard(PlayerController playerController, GUIController guiController, Language language)
    {
        addBalanceFromCard(guiController, language, playerController, 3000, 4);
    }

    public void gamblingCard(PlayerController playerController, GUIController guiController, Language language)
    {
        addBalanceFromCard(guiController, language, playerController, 1000, 5);
    }

    public void salaryIncreaseCard(PlayerController playerController, GUIController guiController, Language language)
    {
        addBalanceFromCard(guiController, language, playerController, 1000, 6);
    }

    public void premiumBondCard(PlayerController playerController, GUIController guiController, Language language)
    {
        addBalanceFromCard(guiController, language, playerController, 1000, 7);
    }

    public void soldFurnitureCard(PlayerController playerController, GUIController guiController, Language language)
    {
        addBalanceFromCard(guiController, language, playerController, 1000, 8);
    }

    public void utilityGardenCard(PlayerController playerController, GUIController guiController, Language language)
    {
        addBalanceFromCard(guiController, language, playerController, 200, 9);
    }

    public void matadorGrantCard(PlayerController playerController, GameBoard gameboard, GUIController guiController, Language language)
    {
        int totalAmount = playerController.getCurrentPlayer().getAccount().getBalance();
        guiController.showChanceCard(language.getText(25,10));
        for(int i =0; i < gameboard.getGameBoard().length; i++)
        {
            if(gameboard.getGameBoard()[i] instanceof BuyableField)
            {
                totalAmount += ((BuyableField) gameboard.getGameBoard()[i]).getPrice();
                if (gameboard.getGameBoard()[i] instanceof PropertyField)
                {
                    if (((PropertyField) gameboard.getGameBoard()[i]).getHouses() > 0)
                    {
                        totalAmount += (((PropertyField) gameboard.getGameBoard()[i]).getHouses() * ((PropertyField) gameboard.getGameBoard()[i]).getHousePrice());
                    }
                }
            }
        }
        if(totalAmount < 15000)
        {
            playerController.getCurrentPlayer().addBalance(40000);
        }

    }

    public void birthdayCard(PlayerController playerController, GUIController guiController, Language language)
    {
        receiveMoneyFromOthers(guiController, language, playerController, 200, 11);
    }

    public void potluckCard(PlayerController playerController, GUIController guiController, Language language)
    {
        receiveMoneyFromOthers(guiController, language, playerController, 500, 12);
    }

    public void familyPartyCard(PlayerController playerController, GUIController guiController, Language language)
    {
        receiveMoneyFromOthers(guiController, language, playerController, 500, 13);
    }

}