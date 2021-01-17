package Game;

import Controller.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

import java.awt.*;

/**
 * @author Isak
 */
public class PropertyField extends BuyableField
{
    private int houses;
    private int housePrice;
    private int csvLine;

    public PropertyField(int positionID, Color colorID, String name, GUI_Field guiField, int price, int pawnValue, int group, int housePrice, int csvLine)
    {
        super(positionID, colorID, name, guiField, price, pawnValue, group);
        houses = 0;
        this.housePrice = housePrice;
        this.csvLine = csvLine;
    }

    public int payRent(PlayerController playerController, GameBoard gameboard, Language language)
    {
        boolean groupOwned = false;
        for (int i = 0; i<gameboard.getGameBoard().length; i++)
        {
            if(gameboard.getGameBoard()[i] instanceof PropertyField)
            {
                if (((BuyableField) gameboard.getGameBoard()[i]).getGroup() == this.group)
                {
                    if (((BuyableField) gameboard.getGameBoard()[i]).owner == this.owner)
                    {
                        groupOwned = true;
                    }
                    else
                        {
                            groupOwned = false;
                            break;
                        }
                }
            }
        }
        int rent;
        if(groupOwned && this.houses == 0)
        {
            rent = Integer.parseInt(language.getText(csvLine, 2)) * 2;
        }
        else
            {
                rent = Integer.parseInt(language.getText(csvLine, houses + 2));
            }
        return rent;
    }

    public void setHouses(int houses)
    {
        this.houses = houses;
    }
    public int getHouses()
    {
        return houses;
    }
    public int getHousePrice()
    {
        return housePrice;
    }
}
