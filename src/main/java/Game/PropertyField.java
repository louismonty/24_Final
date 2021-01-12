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
        int rent = Integer.parseInt(language.getText(csvLine,houses+2));
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
