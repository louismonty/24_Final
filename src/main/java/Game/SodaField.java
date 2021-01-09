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
    public void rentSodaMultiplier(DieController dieController,GameBoard gameBoard) {
        if(isPairBought(gameBoard)) {
            rent = (rent*dieController.diceValue())*2;
        }
        else {
            rent = (rent*dieController.diceValue());
        }
    }

    public void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController playerController, GUIController guiController, Language language) {

    }
}
