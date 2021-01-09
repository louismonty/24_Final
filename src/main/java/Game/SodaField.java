package Game;
import Controller.*;
import gui_fields.GUI_Field;

import java.awt.*;

/**
 * @Author Louis
 */
public class SodaField extends BuyableField
{

    private int rent = 100;

    public SodaField(int positionID, Color colorID, String name, GUI_Field guiField, int price, int pawnValue, int group)
    {
        super(positionID, colorID, name, guiField, price, pawnValue, group);
    }

    public boolean isPairBought(GameBoard gameBoard)
    {
        BuyableField sodaFieldOne =(BuyableField) gameBoard.getGameBoard()[12];
        BuyableField sodaFieldTwo =(BuyableField) gameBoard.getGameBoard()[28];
        if(sodaFieldOne.getOwner() == sodaFieldTwo.getOwner())
        {
            return true;
        }
        else
            {
                return false;
            }
    }

    /**
     * @Author Victor
     * @param playerController
     * @param gameBoard
     * @return rent for the field based on dice values
     */
    public int rentSodaMultiplier(PlayerController playerController,GameBoard gameBoard)
    {
        if(isPairBought(gameBoard))
        {
            return (rent*playerController.getCurrentPlayer().getNumberOfMoves())*2;
        }
        else
            {
                return(rent*playerController.getCurrentPlayer().getNumberOfMoves());
            }
    }

    @Override
    public int payRent(PlayerController playerController,GameBoard gameBoard, Language language)
    {
        return rentSodaMultiplier(playerController,gameBoard);
    }
}
