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
    MoveChanceCard card;
    Rules rules = new Rules();

    @BeforeEach
    void setUp(){
        language.loadFile();
        gameBoard = new GameBoard(language);
        guiController.createGUIBoard(gameBoard.getGUIGameboard());
        card = new MoveChanceCard(1);
        playerController.setPlayerArray(new Player[]{new Player("test1",1),new Player("test2",2)});
        playerController.setCurrentPlayer(0);
    }

    @Test
    void moveToSpecificField() {
        card.moveToSpecificField(language,guiController,gameBoard,playerController,10,1);
        assertEquals(10,playerController.getCurrentPlayer().getPlayerPosition());

    }

    @Test
    void findNextFerryField() {
        assertEquals(5,card.findNextFerryField(playerController));
        playerController.getCurrentPlayer().setPlayerPosition(6);
        assertEquals(15,card.findNextFerryField(playerController));
        playerController.getCurrentPlayer().setPlayerPosition(16);
        assertEquals(25,card.findNextFerryField(playerController));
        playerController.getCurrentPlayer().setPlayerPosition(26);
        assertEquals(35,card.findNextFerryField(playerController));
    }

    @Test
    void startCard() {
        playerController.getCurrentPlayer().setPlayerPosition(1);
        card.startCard(language,guiController,gameBoard,playerController);
        rules.overStartRule(language, guiController, playerController);
        assertEquals(0,playerController.getCurrentPlayer().getPlayerPosition());
        assertEquals(34000, playerController.getCurrentPlayer().getAccount().getBalance());
    }

    @Test
    void threeFieldsForwardCard() {
        card.threeFieldsForwardCard(language,guiController,gameBoard,playerController);
        assertEquals(3,playerController.getCurrentPlayer().getPlayerPosition());
    }

    @Test
    void threeFieldsBackwardsCard() {
        card.threeFieldsBackwardsCard(language,guiController,gameBoard,playerController);
        assertEquals(37,playerController.getCurrentPlayer().getPlayerPosition());
    }

    @Test
    void frederiksbergAlleCard() {
        card.frederiksbergAlleCard(language,guiController,gameBoard,playerController);
        assertEquals(11,playerController.getCurrentPlayer().getPlayerPosition());
    }

    @Test
    void shipyardCard() {
        card.shipyardCard(language,guiController,gameBoard,playerController);
        assertEquals(5,playerController.getCurrentPlayer().getPlayerPosition());
    }

    @Test
    void molslinjenCard() {
        card.molslinjenCard(language,guiController,gameBoard,playerController);
        assertEquals(16,playerController.getCurrentPlayer().getPlayerPosition());
    }

    @Test
    void groenningenCard() {
        card.groenningenCard(language,guiController,gameBoard,playerController);
        assertEquals(24,playerController.getCurrentPlayer().getPlayerPosition());
    }

    @Test
    void vimmelskaftetCard() {
        card.vimmelskaftetCard(language,guiController,gameBoard,playerController);
        assertEquals(32,playerController.getCurrentPlayer().getPlayerPosition());
    }

    @Test
    void ferryCard() {
        card.ferryCard(language,guiController,gameBoard,playerController);
        assertEquals(5,playerController.getCurrentPlayer().getPlayerPosition());
    }

    @Test
    void strandvejenCard() {
        card.strandvejenCard(language,guiController,gameBoard,playerController);
        assertEquals(19,playerController.getCurrentPlayer().getPlayerPosition());
    }

    @Test
    void raadhuspladsenCard() {
        card.raadhuspladsenCard(language,guiController,gameBoard,playerController);
        assertEquals(39,playerController.getCurrentPlayer().getPlayerPosition());
    }
}