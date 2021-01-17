package Game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FerryFieldTest {
    Language language = new Language();


    @Test
    void rentFerryMultiplier() {
        language.loadFile();
        GameBoard gameBoard = new GameBoard(language);
        FerryField field = (FerryField) gameBoard.getGameBoard()[5];
        field.owner = 1;
        assertEquals(1,field.rentFerryMultiplier(gameBoard));
        field = (FerryField) gameBoard.getGameBoard()[15];
        field.owner = 1;
        assertEquals(2,field.rentFerryMultiplier(gameBoard));

    }
}