package Game;

import Controller.ChanceCardController;
import Controller.GUIController;
import gui_fields.GUI_Field;
import java.awt.*;
import Controller.PlayerController;

public class JailField extends Field{

    public JailField(int positionID, Color colorID, String name, GUI_Field guiField)
    {
        super(positionID, colorID, name, guiField);
    }

    public void goToJail(GameBoard gameboard, PlayerController playerController)
    {
        gameboard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition()].getGUIField().setCar(playerController.getCurrentPlayer().getGUIPlayer(),false);
        playerController.getCurrentPlayer().setPlayerPosition(10);
        gameboard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition()].getGUIField().setCar(playerController.getCurrentPlayer().getGUIPlayer(), true);

        playerController.getCurrentPlayer().setInJail(true);
    }

    @Override
    public void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController
            playerController, GUIController guiController, Language language)
    {
        goToJail(playerController);
        guiController.showMessage(language.getText(18,2));
    }
}
