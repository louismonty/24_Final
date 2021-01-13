package Game;

import Controller.DieController;
import Controller.GUIController;
import Controller.PlayerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SodaFieldTest {

    Language language = new Language();
    GameBoard gameBoard;
    GUIController guiController = new GUIController();
    SodaField field;
    SodaField field2;
    PlayerController playerController = new PlayerController();



    @BeforeEach
    void setUp(){
            language.loadFile();
            gameBoard = new GameBoard(language);
            guiController.createGUIBoard(gameBoard.getGuiGamebord());
            field = (SodaField) gameBoard.getGameBoard()[12];
        field2 = (SodaField) gameBoard.getGameBoard()[28];
        playerController.setPlayerArray(new Player[]{new Player("test1",1)});
    }

    @Test
    void isPairBought() {
        field.owner = 1;
        field2.owner = 1;
        assertEquals(true,field.isPairBought(gameBoard));
        field2.owner = 0;
        assertEquals(false,field.isPairBought(gameBoard));


    }

    @Test
    void rentSodaMultiplier() {
        field.owner = 1;
        field2.owner = 1;
        playerController.setCurrentPlayer(0);
        playerController.getCurrentPlayer().setNumberOfMoves(2);

        assertEquals(400,field.rentSodaMultiplier(playerController,gameBoard));
        field2.owner = 0;
        assertEquals(200,field.rentSodaMultiplier(playerController,gameBoard));
    }
}