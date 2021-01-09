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

    public void lotteryCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.addBalance(500);
    }

    public void stockDividendsCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.addBalance(1000);
    }

    public void taxReturnCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.addBalance(3000);
    }

    public void gamblingCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.addBalance(1000);
    }

    public void salaryIncreaseCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.addBalance(1000);
    }

    public void premiumBondCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.addBalance(1000);
    }

    public void soldFurnitureCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.getAccount().addBalance(1000);
        currentPlayer.addBalance(1000);
    }

    public void utilityGardenCard(Player currentPlayer, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        currentPlayer.addBalance(200);
    }

    public void matadorGrantCard(Player currentPlayer, GameBoard gameboard, GUIController guiController, Language language)
    {
        int totalAmount = currentPlayer.getAccount().getBalance();
        guiController.showChanceCard(language.getText(0,0));
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
            currentPlayer.addBalance(40000);
        }

    }

    public void birthdayCard(PlayerController playerController, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        for(int i = 0; i < playerController.getPlayerArray().length; i++)
        {
            playerController.getCurrentPlayer().addBalance(200);
            playerController.getPlayerArray()[i].subtractBalance(200);
        }
    }

    public void potluckCard(PlayerController playerController, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        for(int i = 0; i < playerController.getPlayerArray().length; i++)
        {
            playerController.getCurrentPlayer().addBalance(500);
            playerController.getPlayerArray()[i].subtractBalance(500);
        }
    }

    public void familyPartyCard(PlayerController playerController, GUIController guiController, Language language)
    {
        guiController.showChanceCard(language.getText(0,0));
        for(int i = 0; i < playerController.getPlayerArray().length; i++)
        {
            playerController.getCurrentPlayer().addBalance(500);
            playerController.getPlayerArray()[i].subtractBalance(500);
        }
    }

}