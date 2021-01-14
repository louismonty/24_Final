package Game;

import Controller.GUIController;
import Controller.PlayerController;

/**
 * @author Isak
 */
public class IncomeChanceCard extends ChanceCard
{
    private int chanceCardID;

    public IncomeChanceCard(int chanceCardID)
    {
        super(chanceCardID);
    }

    public void addBalanceFromCard(Language language, GUIController guiController, PlayerController playerController, int amount, int textColumn)
    {
        guiController.showChanceCard(language.getText(25,textColumn));
        playerController.getCurrentPlayer().addBalance(amount);
    }
    public void receiveMoneyFromOthers(Language language, GUIController guiController, PlayerController playerController, int amount, int textColumn)
    {
    guiController.showChanceCard(language.getText(25,textColumn));
        for(int i = 0; i < playerController.getPlayerArray().length; i++)
        {
            playerController.getCurrentPlayer().addBalance(amount);
            playerController.getPlayerArray()[i].subtractBalance(amount);
        }
    }

    public void lotteryCard(Language language, GUIController guiController, PlayerController playerController)
    {
        addBalanceFromCard(language, guiController, playerController, 500, 2);
    }

    public void stockDividendsCard(Language language, GUIController guiController, PlayerController playerController)
    {
        addBalanceFromCard(language, guiController, playerController, 1000, 3);
    }

    public void taxReturnCard(Language language, GUIController guiController, PlayerController playerController)
    {
        addBalanceFromCard(language, guiController, playerController, 3000, 4);
    }

    public void gamblingCard(Language language, GUIController guiController, PlayerController playerController)
    {
        addBalanceFromCard(language, guiController, playerController, 1000, 5);
    }

    public void salaryIncreaseCard(Language language, GUIController guiController, PlayerController playerController)
    {
        addBalanceFromCard(language, guiController, playerController, 1000, 6);
    }

    public void premiumBondCard(Language language, GUIController guiController, PlayerController playerController)
    {
        addBalanceFromCard(language, guiController, playerController, 1000, 7);
    }

    public void soldFurnitureCard(Language language, GUIController guiController, PlayerController playerController)
    {
        addBalanceFromCard(language, guiController, playerController, 1000, 8);
    }

    public void utilityGardenCard(Language language, GUIController guiController, PlayerController playerController)
    {
        addBalanceFromCard(language, guiController, playerController, 200, 9);
    }

    public void matadorGrantCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        int totalAmount = playerController.getCurrentPlayer().getAccount().getBalance();
        guiController.showChanceCard(language.getText(25,10));
        for(int i =0; i < gameboard.getGameBoard().length; i++)
        {
            if(gameboard.getGameBoard()[i] instanceof BuyableField)
            {
                if(((BuyableField) gameboard.getGameBoard()[i]).getOwner() == playerController.getCurrentPlayer().getPlayerID())
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
        }
        if(totalAmount < 15000)
        {
            playerController.getCurrentPlayer().addBalance(40000);
        }
    }

    public void birthdayCard(Language language, GUIController guiController, PlayerController playerController)
    {
        receiveMoneyFromOthers(language, guiController, playerController, 200, 11);
    }

    public void potluckCard(Language language, GUIController guiController, PlayerController playerController)
    {
        receiveMoneyFromOthers(language, guiController, playerController, 500, 12);
    }

    public void familyPartyCard(Language language, GUIController guiController, PlayerController playerController)
    {
        receiveMoneyFromOthers(language, guiController, playerController, 500, 13);
    }

}