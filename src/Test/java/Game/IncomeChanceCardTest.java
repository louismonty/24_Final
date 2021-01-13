package Game;

import Controller.GUIController;
import Controller.PlayerController;
import gui_fields.GUI_Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncomeChanceCardTest {
    Language language = new Language();
    PlayerController playerController = new PlayerController();
    GUIController guiController = new GUIController();
    GameBoard gameBoard;
    IncomeChanceCard card;

    @BeforeEach
    void setUp(){
        GUI_Field[] fields = new GUI_Field[0];
        guiController.createGUIBoard(fields);
        language.loadFile();
        gameBoard = new GameBoard(language);
        playerController.setPlayerArray(new Player[]{new Player("test1",1),new Player("test2",2)});
        card = new IncomeChanceCard(1);
    }

    @Test
    void addBalanceFromCard() {
        card.addBalanceFromCard(language,guiController,playerController,200,1);
        assertEquals(30200,playerController.getPlayerArray()[0].getAccount().getBalance());
    }

    @Test
    void receiveMoneyFromOthers() {
        card.receiveMoneyFromOthers(language,guiController,playerController,200,1);
        assertEquals(30200,playerController.getPlayerArray()[0].getAccount().getBalance());
        assertEquals(29800,playerController.getPlayerArray()[1].getAccount().getBalance());
    }

    @Test
    void lotteryCard() {
        card.lotteryCard(language,guiController,playerController);
        assertEquals(30500,playerController.getPlayerArray()[0].getAccount().getBalance());
    }

    @Test
    void stockDividendsCard() {
        card.stockDividendsCard(language,guiController,playerController);
        assertEquals(31000,playerController.getPlayerArray()[0].getAccount().getBalance());
    }

    @Test
    void taxReturnCard() {
        card.taxReturnCard(language,guiController,playerController);
        assertEquals(33000,playerController.getPlayerArray()[0].getAccount().getBalance());
    }

    @Test
    void gamblingCard() {
        card.gamblingCard(language,guiController,playerController);
        assertEquals(31000,playerController.getPlayerArray()[0].getAccount().getBalance());
    }

    @Test
    void salaryIncreaseCard() {
        card.salaryIncreaseCard(language,guiController,playerController);
        assertEquals(31000,playerController.getPlayerArray()[0].getAccount().getBalance());
    }

    @Test
    void premiumBondCard() {
        card.premiumBondCard(language,guiController,playerController);
        assertEquals(31000,playerController.getPlayerArray()[0].getAccount().getBalance());
    }

    @Test
    void soldFurnitureCard() { ;
        card.soldFurnitureCard(language,guiController,playerController);
        assertEquals(31000,playerController.getPlayerArray()[0].getAccount().getBalance());
    }

    @Test
    void utilityGardenCard() {
        card.utilityGardenCard(language,guiController,playerController);
        assertEquals(30200,playerController.getPlayerArray()[0].getAccount().getBalance());
    }

    @Test
    void matadorGrantCard() {
        playerController.getPlayerArray()[1].getAccount().setBalance(0);
        playerController.setCurrentPlayer(0);
        card.matadorGrantCard(language,guiController,gameBoard,playerController);
        playerController.setCurrentPlayer(1);
        card.matadorGrantCard(language,guiController,gameBoard,playerController);
        assertEquals(30000,playerController.getPlayerArray()[0].getAccount().getBalance());
        assertEquals(40000,playerController.getPlayerArray()[1].getAccount().getBalance());
    }

    @Test
    void birthdayCard() {
        card.birthdayCard(language,guiController,playerController);
        assertEquals(30200,playerController.getPlayerArray()[0].getAccount().getBalance());
        assertEquals(29800,playerController.getPlayerArray()[1].getAccount().getBalance());
    }

    @Test
    void potluckCard() {
        card.potluckCard(language,guiController,playerController);
        assertEquals(30500,playerController.getPlayerArray()[0].getAccount().getBalance());
        assertEquals(29500,playerController.getPlayerArray()[1].getAccount().getBalance());
    }

    @Test
    void familyPartyCard() {
        card.familyPartyCard(language,guiController,playerController);
        assertEquals(30500,playerController.getPlayerArray()[0].getAccount().getBalance());
        assertEquals(29500,playerController.getPlayerArray()[1].getAccount().getBalance());
    }
}