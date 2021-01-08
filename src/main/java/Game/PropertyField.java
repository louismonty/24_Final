package Game;

import gui_fields.GUI_Field;

import java.awt.*;

/**
 * @Author Isak Risager
 */
public class PropertyField extends BuyableField
{
    private int houses;

    public PropertyField(int positionID, Color colorID, String name, GUI_Field guiField, int price, int rent, int pawnValue, Field[] group)
    {
        super(price, rent, pawnValue, group, positionID, colorID, name, guiField);

    }
}
