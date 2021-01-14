package Game;

import Controller.GUIController;
import Controller.PlayerController;

/**
 * @author Isak
 */
public class PaymentChanceCard extends ChanceCard
{
    private int chanceCardID;

    public PaymentChanceCard(int chanceCardID)
    {
        super(chanceCardID);
    }

    public void subtractBasedOnHousesAndHotels(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController, int hotelCost, int houseCost, int textColumn)
    {
        int totalCost = 0;
        guiController.showChanceCard(language.getText(27,textColumn));
        for(int i =0; i < gameboard.getGameBoard().length; i++)
        {
            if(gameboard.getGameBoard()[i] instanceof PropertyField)
            {
                if (((PropertyField) gameboard.getGameBoard()[i]).getHouses() > 0)
                {
                    if (((PropertyField) gameboard.getGameBoard()[i]).getHouses() == 5)
                    {
                        totalCost += hotelCost;
                    }
                    else
                    {
                        totalCost += (((PropertyField) gameboard.getGameBoard()[i]).getHouses()*houseCost);
                    }
                }
            }
        }
        playerController.getCurrentPlayer().subtractBalance(totalCost);
    }

    public void subtractBalanceFromCard(Language language, GUIController guiController, PlayerController playerController, int amount, int textColumn)
    {
        guiController.showChanceCard(language.getText(27, textColumn));
        playerController.getCurrentPlayer().subtractBalance(amount);
    }

    public void oilPricesCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        subtractBasedOnHousesAndHotels(language, guiController, gameboard, playerController, 2000, 500, 2);
    }

    public void propertyTaxCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        subtractBasedOnHousesAndHotels(language, guiController, gameboard, playerController, 2300, 800, 3);
    }

    public void redLightCard(Language language, GUIController guiController, PlayerController playerController)
    {
        subtractBalanceFromCard(language, guiController, playerController, 1000, 4);
    }

    public void carWashCard(Language language, GUIController guiController, PlayerController playerController)
    {
        subtractBalanceFromCard(language, guiController, playerController, 300, 5);
    }

    public void beerCard(Language language, GUIController guiController, PlayerController playerController)
    {
        subtractBalanceFromCard(language, guiController, playerController, 200, 6);
    }

    public void carRepairCard(Language language, GUIController guiController, PlayerController playerController)
    {
        subtractBalanceFromCard(language, guiController, playerController, 3000, 7);
    }

    public void newTiresCard(Language language, GUIController guiController, PlayerController playerController)
    {
        subtractBalanceFromCard(language, guiController, playerController, 1000, 8);
    }

    public void parkingTicketCard(Language language, GUIController guiController, PlayerController playerController)
    {
        subtractBalanceFromCard(language, guiController, playerController, 200, 9);
    }

    public void carInsuranceCard(Language language, GUIController guiController, PlayerController playerController)
    {
        subtractBalanceFromCard(language, guiController, playerController, 1000, 10);
    }

    public void cigaretteCard(Language language, GUIController guiController, PlayerController playerController)
    {
        subtractBalanceFromCard(language, guiController, playerController, 200, 11);
    }

    public void dentistCard(Language language, GUIController guiController, PlayerController playerController)
    {
        subtractBalanceFromCard(language, guiController, playerController, 2000, 12);
    }

}
