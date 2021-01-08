package Game;

import gui_fields.GUI_Field;
import java.awt.*;
import Controller.*;


public class CustomField extends Field {

    public CustomField(int positionID, String name, GUI_Field guiField, Color color) {
        super(positionID, color, name, guiField);
    }

    public void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController playerController, GUIController guiController) {

    }

    public String getName(){
        return name;
    }
}
