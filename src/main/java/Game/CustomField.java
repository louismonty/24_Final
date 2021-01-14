package Game;

import gui_fields.GUI_Field;
import java.awt.*;
import Controller.*;

/**
 * @author Lucas
 * Blueprint for the CustomField class that includes the method landOnField() inherited from the Field class.
 * Also includes the inherited getName() method, inherited from Field class.
 */

public class CustomField extends Field {

    public CustomField(int positionID, Color colorID, String name, GUI_Field guiField) {
        super(positionID, colorID, name, guiField);
    }

    public void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController playerController, GUIController guiController, Language language) {
    }

    public String getName(){
        return name;
    }
}
