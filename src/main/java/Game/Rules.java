package Game;

import gui_fields.GUI_Player;

public class Rules
{


    private boolean extraTurn = false;

    public void setExtraTurn(boolean extraTurn) {
        this.extraTurn = extraTurn;
    }

    public boolean getExtraTurn() {
        return extraTurn;
    }

    public void overStartRules(Player currentPlayer,GUIController guiController)
    {
        if(currentPlayer.getPlayerPosition()>=40)
        {
            currentPlayer.getPlayerAccount().setBalance(currentPlayer.getPlayerAccount().getBalance()+4000);
            currentPlayer.setPlayerPosition(currentPlayer.getPlayerPosition()-40);
            guiController.showMessege("du får 2 m for at komme over start");
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
        if(currentPlayer.getDoubleCounter == 3)
        {
            currentPlayer.setPlayerPosition(10);
            currentPlayer.setDoubleCounter(0);
            currentPlayer.setInJail(true);
        }
    }

    public void bankrupt(Player currentPlayer, PlayerController playerController, GUIController guiController)
    {
        if(currentPlayer.getAccount() < 0)
        {
            for(int i = 0; i>= playerController.getPlayerArray().length; i++ )
            {
                if(playerController.getPlayerArray[i] != currentPlayer)
                {
                    playerController.setPlayerArray[i] = playerController.getPlayerArray[i];
                }
            }
        }
    }

    public boolean win(Player currentPlayer, PlayerController playerController)
    {
        if(playerController.getPlayerArray().length == 1)
            return true;
        else
            return false;
    }

}
