package Game;

import Controller.PlayerController;
import gui_fields.GUI_Field;

import java.awt.*;

public class FerryField extends BuyableField {

    public FerryField(int positionID, Color colorID, String name, GUI_Field guiField, int price, int pawnValue, int group) {
        super(positionID, colorID, name, guiField, price, pawnValue, group);
    }
    private int rent = 500;

    public int rentFerryMultiplier(GameBoard gameBoard){
        int multiplier = 0;
        int ferryFields[] = {5,15,25,35};
        for(int i=0; i<4;i++){
            BuyableField ferryField = (BuyableField) gameBoard.getGameBoard()[ferryFields[i]];
            if(ferryField.getOwner() == this.owner){
                multiplier += 1;
            }

        }
        return multiplier;

    }
    @Override
    public int payRent(PlayerController playerController, GameBoard gameBoard, Language language) {
        return rent*rentFerryMultiplier(gameBoard);
    }
}
