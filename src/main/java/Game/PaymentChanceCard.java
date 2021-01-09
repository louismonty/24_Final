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

    public void oilPricesCard(Player currentPlayer, GameBoard gameboard, GUIController guiController, Language language)
    {
        int totalCost = 0;
        guiController.showChanceCard(language.getText(0,0));
        for(int i =0; i < gameboard.getGameBoard().length; i++)
        {
            if(gameboard.getGameBoard()[i] instanceof PropertyField)
            {
                if (((PropertyField) gameboard.getGameBoard()[i]).getHouses() > 0)
                {
                    if (((PropertyField) gameboard.getGameBoard()[i]).getHouses() == 5)
                    {
                        totalCost = totalCost + 2000;
                    }
                    else
                    {
                        totalCost = totalCost + (((PropertyField) gameboard.getGameBoard()[i]).getHouses()*500);
                    }
                }
            }
        }
        currentPlayer.subtractBalance(totalCost);
    }

    public void propertyTaxCard(Player currentPlayer, GameBoard gameboard, GUIController guiController, Language language)
    {
        {
            int totalCost = 0;
            guiController.showChanceCard(language.getText(0,0));
            for(int i =0; i < gameboard.getGameBoard().length; i++)
            {
                if(gameboard.getGameBoard()[i] instanceof PropertyField)
                {
                    if (((PropertyField) gameboard.getGameBoard()[i]).getHouses() > 0)
                    {
                        if (((PropertyField) gameboard.getGameBoard()[i]).getHouses() == 5)
                        {
                            totalCost = totalCost + 2300;
                        }
                        else
                        {
                            totalCost = totalCost + (((PropertyField) gameboard.getGameBoard()[i]).getHouses()*800);
                        }
                    }
                }
            }
            currentPlayer.subtractBalance(totalCost);
        }
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
