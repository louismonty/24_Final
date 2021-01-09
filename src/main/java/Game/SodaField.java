package Game;
import Controller.*;
import gui_fields.GUI_Field;

import java.awt.*;

public class SodaField extends BuyableField {

    private int rent = 100;

    public SodaField(int positionID, Color colorID, String name, GUI_Field guiField, int price, int rent, int pawnValue, int group) {
        super(positionID, colorID, name, guiField, price, rent, pawnValue, group);
    }

    public boolean isPairBought(GameBoard gameBoard) {
        BuyableField sodaFieldOne =(BuyableField) gameBoard.getGameBoard()[12];
        BuyableField sodaFieldTwo =(BuyableField) gameBoard.getGameBoard()[28];
        if(sodaFieldOne.getOwner() == sodaFieldTwo.getOwner()) {
            return true;
        }
        else{
            return false;
        }
    }
    public int rentSodaMultiplier(PlayerController playerController,GameBoard gameBoard) {
        if(isPairBought(gameBoard)) {
            return (rent*playerController.getCurrentPlayer().getNumberOfMoves())*2;
        }
        else {
            return(rent*playerController.getCurrentPlayer().getNumberOfMoves());
        }
    }

    @Override
    public int payRent(PlayerController playerController,GameBoard gameBoard){
        return rentSodaMultiplier(playerController,gameBoard);
    }
}
