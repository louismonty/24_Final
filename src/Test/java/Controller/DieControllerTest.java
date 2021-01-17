package Controller;

import static org.junit.jupiter.api.Assertions.*;
class DieControllerTest {


    @org.junit.jupiter.api.Test
    void diceValue() {
        DieController dieController = new DieController();
        dieController.getDie1().setFaceValue(5);
        dieController.getDie2().setFaceValue(5);
        assertEquals(10,dieController.diceValue());

    }

    @org.junit.jupiter.api.Test
    void isDouble() {
        DieController dieController = new DieController();
        dieController.getDie1().setFaceValue(5);
        dieController.getDie2().setFaceValue(5);
        assertEquals(true,dieController.isDouble());
        dieController.getDie1().setFaceValue(5);
        dieController.getDie2().setFaceValue(4);
        assertEquals(false,dieController.isDouble());
    }
}