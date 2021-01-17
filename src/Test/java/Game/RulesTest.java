package Game;

import Controller.DieController;
import Controller.GUIController;
import Controller.PlayerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesTest {
    Language language = new Language();
    GameBoard gameBoard;
    GUIController guiController = new GUIController();
    DieController dieController = new DieController();
    PlayerController playerController = new PlayerController();
    Rules rules = new Rules();


    @BeforeEach
    void setUp(){
        language.loadFile();
        gameBoard = new GameBoard(language);
        guiController.createGUIBoard(gameBoard.getGUIGameboard());
        playerController.setPlayerArray(new Player[]{new Player("test1",1),new Player("test2",2)});
        playerController.setCurrentPlayer(0);
    }

    @Test
    void doubleExtraTurn() {
        dieController.getDie1().setFaceValue(1);
        dieController.getDie2().setFaceValue(1);
        rules.doubleExtraTurn(dieController,playerController);
        assertEquals(true,rules.getExtraTurn());

    }

    @Test
    void threeDoubleGoToJail() {
        playerController.getCurrentPlayer().setDoubleCounter(3);
        rules.threeDoubleGoToJail(gameBoard,playerController);
        assertEquals(true,playerController.getCurrentPlayer().isInJail());
        assertEquals(10, playerController.getCurrentPlayer().getPlayerPosition());
    }

}