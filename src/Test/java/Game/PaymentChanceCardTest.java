package Game;

import Controller.GUIController;
import Controller.PlayerController;
import gui_fields.GUI_Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentChanceCardTest {

    Language language = new Language();
    PlayerController playerController = new PlayerController();
    GUIController guiController = new GUIController();
    PaymentChanceCard card;

    @BeforeEach
    void setUp(){
        language.loadFile();
        GUI_Field[] fields = new GUI_Field[0];
        guiController.createGUIBoard(fields);
        card = new PaymentChanceCard(1);
        playerController.setPlayerArray(new Player[]{new Player("test1",1),new Player("test2",2)});
        playerController.setCurrentPlayer(0);
    }


    @Test
    void subtractBalanceFromCard() {
        card.subtractBalanceFromCard(language,guiController,playerController,1000,1);
        assertEquals(29000,playerController.getCurrentPlayer().getAccount().getBalance());
    }


    @Test
    void redLightCard() {
        card.redLightCard(language,guiController,playerController);
        assertEquals(29000,playerController.getCurrentPlayer().getAccount().getBalance());
    }

    @Test
    void carWashCard() {
        card.carWashCard(language,guiController,playerController);
        assertEquals(29700,playerController.getCurrentPlayer().getAccount().getBalance());
    }

    @Test
    void beerCard() {
        card.beerCard(language,guiController,playerController);
        assertEquals(29800,playerController.getCurrentPlayer().getAccount().getBalance());
    }

    @Test
    void carRepairCard() {
        card.carRepairCard(language,guiController,playerController);
        assertEquals(27000,playerController.getCurrentPlayer().getAccount().getBalance());
    }

    @Test
    void newTiresCard() {
        card.newTiresCard(language,guiController,playerController);
        assertEquals(29000,playerController.getCurrentPlayer().getAccount().getBalance());
    }

    @Test
    void parkingTicketCard() {
        card.parkingTicketCard(language,guiController,playerController);
        assertEquals(29800,playerController.getCurrentPlayer().getAccount().getBalance());
    }

    @Test
    void carInsuranceCard() {
        card.carInsuranceCard(language,guiController,playerController);
        assertEquals(29000,playerController.getCurrentPlayer().getAccount().getBalance());
    }

    @Test
    void cigaretteCard() {
        card.cigaretteCard(language,guiController,playerController);
        assertEquals(29800,playerController.getCurrentPlayer().getAccount().getBalance());
    }

    @Test
    void dentistCard() {
        card.dentistCard(language,guiController,playerController);
        assertEquals(28000,playerController.getCurrentPlayer().getAccount().getBalance());
    }
}