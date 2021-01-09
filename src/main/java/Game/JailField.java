package Game;

import Controller.GUIController;
import Controller.GameBoard;
import gui_fields.GUI_Field;
import java.awt.*;
import Controller.PlayerController;

public class JailField extends Field{

    public JailField(int positionID, Color colorID, String name, GUI_Field guiField){
        super(positionID, colorID, name, guiField);
    }
    public void goToJail(Player currentPlayer){
        currentPlayer.setPlayerPosition(30);
        currentPlayer.isInJail(true);
    }
    public void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController
            playerController, GUIController guiController, Language language){
        goToJail(playerController.getCurrentPlayer());
        guiController.showMessage(language.getText(0,0));
    }
}
