package Game;

import Controller.GUIController;
import Controller.PlayerController;
import gui_fields.GUI_Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveChanceCardTest {
    Language language = new Language();
    PlayerController playerController = new PlayerController();
    GUIController guiController = new GUIController();
    GameBoard gameBoard;

    @BeforeEach
    void setUp(){
        language.loadFile();
        gameBoard = new GameBoard(language);
        guiController.createGUIBoard(gameBoard.getGuiGamebord());
        playerController.setPlayerArray(new Player[]{new Player("test1",1),new Player("test2",2)});
    }

    @Test
    void moveToSpecificField() {

    }

    @Test
    void findNextFerryField() {
    }

    @Test
    void startCard() {
    }

    @Test
    void threeFieldsForwardCard() {
    }

    @Test
    void threeFieldsBackwardsCard() {
    }

    @Test
    void frederiksbergAlleCard() {
    }

    @Test
    void shipyardCard() {
    }

    @Test
    void molslinjenCard() {
    }

    @Test
    void groenningenCard() {
    }

    @Test
    void vimmelskaftetCard() {
    }

    @Test
    void ferryCard() {
    }

    @Test
    void strandvejenCard() {
    }

    @Test
    void raadhuspladsenCard() {
    }
}