package Game;

import gui_fields.GUI_Player;

public class Rules
{
    public void overStartRules(Player currentPlayer,GUIController guiController)
    {
        if(currentPlayer.getPlayerPosition()>=40)
        {
            currentPlayer.getPlayerAccount().setBalance(currentPlayer.getPlayerAccount().getBalance()+4000);
            currentPlayer.setPlayerPosition(currentPlayer.getPlayerPosition()-40);
            guiController.showMessege("du får 2 m for at komme over start");
        }
    }

    public void threeDoubleGoToJail(Player currentPlayer)
    {

    }

    public void bankrupt(Player currentPlayer, GUIController guiController)
    {

    }

    public void win(Player currentPlayer)
    {

    }

}
