package Game;

import Controller.*;
import gui_fields.GUI_Player;

/**
 * @author Isak Risager
 */
public class Rules
{


    private boolean extraTurn = false;

    public void setExtraTurn(boolean extraTurn) {
        this.extraTurn = extraTurn;
    }

    public boolean getExtraTurn() {
        return extraTurn;
    }

    public void overStartRule(Language language, GUIController guiController, PlayerController playerController)
    {
        if(playerController.getCurrentPlayer().getPlayerPosition()>=40)
        {
            playerController.getCurrentPlayer().addBalance(4000);
            playerController.getCurrentPlayer().setPlayerPosition(playerController.getCurrentPlayer().getPlayerPosition()-40);

            guiController.showMessage(language.getText(12,2));
        }
    }

    public void doubleExtraTurn(DieController dieController, PlayerController playerController )
    {
        if(dieController.isDouble() == true)
        {
            setExtraTurn(true);
            playerController.getCurrentPlayer().setDoubleCounter(playerController.getCurrentPlayer().getDoubleCounter()+1);
        }
    }

    public void threeDoubleGoToJail(GameBoard gameboard, PlayerController playerController)
    {
        if(playerController.getCurrentPlayer().getDoubleCounter() == 3)
        {
            gameboard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition()].getGUIField().setCar(playerController.getCurrentPlayer().getGUIPlayer(),false);
            playerController.getCurrentPlayer().setPlayerPosition(10);
            gameboard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition()].getGUIField().setCar(playerController.getCurrentPlayer().getGUIPlayer(), true);
            playerController.getCurrentPlayer().setDoubleCounter(0);
            playerController.getCurrentPlayer().setInJail(true);
        }
    }

    public void threeTurnsInJail(Language language, GUIController guiController, PlayerController playerController)
    {
        playerController.getCurrentPlayer().setInJail(false);
        playerController.getCurrentPlayer().setTurnsInJail(0);
        playerController.getCurrentPlayer().subtractBalance(1000);
        guiController.showMessage(language.getText(12,3));
    }

    public void bankrupt(Language language, GUIController guiController, PlayerController playerController)
    {

        Player[] tempPlayerArray = new Player[playerController.getPlayerArray().length-1];
        if(playerController.getCurrentPlayer().getAccount().getBalance() < 0)
        {
            guiController.showMessage(playerController.getCurrentPlayer().getName() + language.getText(12,5));
            int t = 0;
            for(int i = 0; i<playerController.getPlayerArray().length; i++ )
            {
                if(playerController.getPlayerArray()[i] != playerController.getCurrentPlayer())
                {
                    tempPlayerArray[t] = playerController.getPlayerArray()[i];
                    t++;
                }
            }
            playerController.setPlayerArray(tempPlayerArray);
        }
    }

    public boolean win(Language language, GUIController guiController, PlayerController playerController)
    {
        if(playerController.getPlayerArray().length == 1)
        {
            guiController.showMessage(playerController.getPlayerArray()[0].getName() + language.getText(12,4));
            return false;
        }
        else
            return true;
    }

}
