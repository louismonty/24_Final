package Game;

import Controller.GUIController;
import Controller.PlayerController;
import gui_fields.GUI_Field;
import Controller.ChanceCardController;

import java.awt.*;
import java.awt.color.*;
import Game.Language;

/**
 * @author Daniel
 *
 */

public abstract class Field {
    protected int positionID;
    protected Color colorID;
    protected String name;
    protected GUI_Field guiField;

    public Field(int positionID, Color colorID, String name, GUI_Field guiField){
        this.positionID = positionID;
        this.colorID = colorID;
        this.name = name;
        this.guiField = guiField;
    }

    public abstract void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController
            playerController, GUIController guiController, Language language);

    public String getName() {
        return name;
    }

    public GUI_Field getGUIField()
    {
        return guiField;
    }
}
