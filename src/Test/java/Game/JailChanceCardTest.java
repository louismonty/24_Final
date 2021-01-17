package Game;

import Controller.GUIController;
import Controller.PlayerController;
import gui_fields.GUI_Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JailChanceCardTest {
    Language language = new Language();
    GUIController guiController = new GUIController();
    PlayerController playerController = new PlayerController();

    @Test
    void getOutOfJailCard() {
        language.loadFile();
        playerController.setPlayerArray(new Player[]{new Player("test1",1)});
        playerController.setCurrentPlayer(0);
        GUI_Field[] fields = new GUI_Field[0];
        guiController.createGUIBoard(fields);
        JailChanceCard card = new JailChanceCard(1);
        card.getOutOfJailCard(language,guiController,playerController);
        assertEquals(1,playerController.getPlayerArray()[0].getGetOutOfJailCard());
    }
}