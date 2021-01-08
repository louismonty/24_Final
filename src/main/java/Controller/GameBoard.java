package Controller;

import Game.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Start;
import gui_main.GUI;

import java.awt.*;

import static java.awt.Color.*;


/**
 * @author “Daniel”
 *
 */

public class GameBoard {
    private Field gameBoard[] = new Field[39];

    public GameBoard(Language language){
        gameBoard[0] = new StartField(0, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), RED, BLACK));
        gameBoard[1] = new PropertyField(1, BLUE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[2] = new ChanceCardField(2, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), BLACK, black));
        gameBoard[3] = new PropertyField(3, BLUE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[4] = new TaxField(4, cyan, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[5] = new FerryField(5, BLUE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[6] = new PropertyField(6, ORANGE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[7] = new ChanceCardField(7, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), BLACK, black));
        gameBoard[8] = new PropertyField(8, ORANGE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[9] = new PropertyField(9, ORANGE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[10] = new JailField(10, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[11] = new PropertyField(11, YELLOW, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[12] = new SodaField(12, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[13] = new PropertyField(13, YELLOW, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[14] = new PropertyField(14, YELLOW, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[15] = new FerryField(15, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[16] = new PropertyField(16, GRAY, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[17] = new ChanceCardField(17, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), BLACK, black));
        gameBoard[18] = new PropertyField(18, GRAY, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[19] = new PropertyField(19, GRAY, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[20] = new CustomField(20, cyan, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[21] = new PropertyField(21, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[22] = new ChanceCardField(22, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), BLACK, black));
        gameBoard[23] = new PropertyField(23, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[24] = new PropertyField(24, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[25] = new FerryField(25, BLUE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[26] = new PropertyField(26, WHITE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[27] = new PropertyField(27, WHITE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[28] = new SodaField(28, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[29] = new PropertyField(29, WHITE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[30] = new JailField(30, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[31] = new PropertyField(31, YELLOW, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[32] = new PropertyField(32, YELLOW, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[33] = new ChanceCardField(33, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), BLACK, black));
        gameBoard[34] = new PropertyField(34, YELLOW, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[35] = new FerryField(35, BLUE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[36] = new ChanceCardField(36, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), BLACK, black));
        gameBoard[37] = new PropertyField(37, MAGENTA, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[38] = new TaxField(38, cyan, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[39] = new PropertyField(39, MAGENTA, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));

    }
}
