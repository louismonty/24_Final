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

    public CustomField(int positionID, String name, GUI_Field guiField, Color color) {
        super(positionID, color, name, guiField);
    }

    /**
     *
     * @param gameBoard
     * @param chanceCardController
     * @param playerController
     * @param guiController
     * When landOnField is executed, the player's position is updated and nothing else happens.
     */
    public void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController playerController, GUIController guiController) {
    }

    public String getName(){
        return name;
    }
}
