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

    public PropertyField(int positionID, Color colorID, String name, GUI_Field guiField, int price, int pawnValue, int group)
    {
        super(positionID, colorID, name, guiField, price, pawnValue, group);
        houses = 0;
    }

    public int payRent(PlayerController playerController, GameBoard gameboard, Language language)
    {
        int rent = Integer.parseInt(language.getText(0,houses));
        return rent;
    }
}
