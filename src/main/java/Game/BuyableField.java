package Game;

import Controller.GUIController;
import gui_fields.GUI_Field;

import java.awt.*;

/**
 * @author “Daniel”
 *
 */


public abstract class BuyableField extends Field {

    protected int price;
    protected int rent;
    protected Player owner;
    protected boolean isPropertyBought;
    protected int pawnValue;
    protected boolean isPawned;
    protected Field[] group;

    public BuyableField(int price, int rent, int pawnValue, Field[] group, int positionID, Color colorID,
                        String name, GUI_Field guiField){
        super(positionID, colorID, name, guiField);
        this.price = price;
        this.rent = rent;
        this.pawnValue = pawnValue;
        this.group = group;
    }

    public abstract void buy(Player player);
    public abstract void auction(GUIController guiController, Player[] players);
}
