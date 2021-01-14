package Game;

import Controller.ChanceCardController;
import Controller.GUIController;
import Controller.PlayerController;
import gui_fields.GUI_Field;

import java.awt.*;

/**
 * @author Louis
 */
public class ChanceCardField extends Field {

    public ChanceCardField(int positionID, Color colorID, String name, GUI_Field guiField) {
        super(positionID, colorID, name, guiField);
    }

    public void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController playerController, GUIController guiController, Language language) {
        ChanceCard currentChanceCard;
        currentChanceCard = chanceCardController.drawChanceCard();
        chanceCardController.executeChanceCard(language, guiController, gameBoard, playerController,currentChanceCard);
    }
}
