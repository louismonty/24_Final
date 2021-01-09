package Game;

import Controller.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

import java.awt.*;

/**
 * @Author Isak Risager
 */
public class PropertyField extends BuyableField
{
    private int houses;

    public PropertyField(int positionID, Color colorID, String name, GUI_Field guiField, int price, int rent, int pawnValue, int group)
    {
        super(positionID, colorID, name, guiField, price, rent, pawnValue, group);
        houses = 0;
    }

    public void landOnField(GameBoard gameboard, PlayerController playerController, GUIController guiController, ChanceCardController chanceCardController, Language language){
        PropertyField currentField = (PropertyField) gameboard.getGameboard()[playerController.getCurrentPlayer().getPlayerPosition()];
        if(!currentField.getIsPropertyBought())
        {
            guiController.showMessage(language.getText(0,0)+currentField.getName());
            if( playerController.getCurrentPlayer().getAccount().getBalance() > currentField.getPrice())
            {
                guiController.makeOwner(playerController.getCurrentPlayer().getPlayerPosition(), guiPlayer.getPrimaryColor());
                currentField.setOwner(playerController.getCurrentPlayer());
                currentField.setIsPropertyBought(true);
                playerController.getCurrentPlayer().getAccount().setBalance(playerController.getCurrentPlayer().getAccount().getBalance()-currentField.getPrice());
            }

        }
        else if(currentField.getOwner().equals(playerController.getCurrentPlayer()))
        {
        }
        else{
            guiController.showMessage(language.getText(0,0)+currentField.getOwner().getPlayerName());
            playerController.getCurrentPlayer().getAccount().setBalance(playerController.getCurrentPlayer().getAccount().getBalance()-currentField.getPrice());
            currentField.getOwner().getPlayerAccount().setBalance(currentField.getOwner().getPlayerAccount().getBalance()+currentField.getRent());
            guiController.updatePlayerBal(currentField.getOwner().getPlayerAccount().getBalance(), guiPlayerArray[currentField.getOwner().getPlayerId()]);
        }
    }
}
