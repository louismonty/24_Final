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

    public void overStartRule(Player currentPlayer,GUIController guiController, Language language)
    {
        if(currentPlayer.getPlayerPosition()>=40)
        {
            currentPlayer.getAccount().setBalance(currentPlayer.getAccount().getBalance()+4000);
            currentPlayer.setPlayerPosition(currentPlayer.getPlayerPosition()-40);

            guiController.showMessage(language.getText(0,0));
        }
    }

    public void doubleExtraTurn(Player currentPlayer, DieController dieController)
    {
        if(dieController.isDouble() == true)
        {
            setExtraTurn(true);
            currentPlayer.setDoubleCounter(currentPlayer.getDoubleCounter()+1);
        }
    }

    public void threeDoubleGoToJail(Player currentPlayer)
    {
        if(currentPlayer.getDoubleCounter() == 3)
        {
            currentPlayer.setPlayerPosition(10);
            currentPlayer.setDoubleCounter(0);
            currentPlayer.setInJail(true);
        }
    }

    public void bankrupt(Player currentPlayer, PlayerController playerController, GUIController guiController)
    {
        Player[] tempPlayerArray = new Player[playerController.getPlayerArray().length-2];
        if(currentPlayer.getAccount().getBalance() < 0)
        {
            for(int i = 0; i>= playerController.getPlayerArray().length; i++ )
            {
                if(playerController.getPlayerArray()[i] != currentPlayer)
                {
                    tempPlayerArray[i] = playerController.getPlayerArray()[i];
                }
            }
            playerController.setPlayerArray(tempPlayerArray);
        }
    }

    public boolean win(Player currentPlayer, PlayerController playerController)
    {
        if(playerController.getPlayerArray().length == 1)
        {
            return true;
        }
        else
            return false;
    }

}
