package Game;

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

    private Field[] gameBoard = new Field[39];

    public GameBoard(Language language){
        gameBoard[0] = new StartField(0, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), RED, BLACK));
        gameBoard[1] = new PropertyField(1, BLUE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),1200,600,3);
        gameBoard[2] = new ChanceCardField(2, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), BLACK, black));
        gameBoard[3] = new PropertyField(3, BLUE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),1200,600,3);
        gameBoard[4] = new TaxField(4, cyan, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[5] = new FerryField(5, BLUE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),4000,2000,1);
        gameBoard[6] = new PropertyField(6, ORANGE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),2000,1000,4);
        gameBoard[7] = new ChanceCardField(7, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), BLACK, black));
        gameBoard[8] = new PropertyField(8, ORANGE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),2000,1000,4);
        gameBoard[9] = new PropertyField(9, ORANGE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),2400,1200,4);
        gameBoard[10] = new JailField(10, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[11] = new PropertyField(11, YELLOW, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),2800,1400,5);
        gameBoard[12] = new SodaField(12, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),3000,1500,2);
        gameBoard[13] = new PropertyField(13, YELLOW, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),2800,1400,5);
        gameBoard[14] = new PropertyField(14, YELLOW, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),3200,1600,5);
        gameBoard[15] = new FerryField(15, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),4000,2000,1);
        gameBoard[16] = new PropertyField(16, GRAY, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),3600,1800,6);
        gameBoard[17] = new ChanceCardField(17, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), BLACK, black));
        gameBoard[18] = new PropertyField(18, GRAY, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),3600,1800,6);
        gameBoard[19] = new PropertyField(19, GRAY, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),4000,2000,6);
        gameBoard[20] = new CustomField(20, cyan, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[21] = new PropertyField(21, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),4400,2200,7);
        gameBoard[22] = new ChanceCardField(22, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), BLACK, black));
        gameBoard[23] = new PropertyField(23, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),4400,2200,7);
        gameBoard[24] = new PropertyField(24, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),4800,2400,7);
        gameBoard[25] = new FerryField(25, BLUE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),4000,2000,1);
        gameBoard[26] = new PropertyField(26, WHITE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),5200,2600,8);
        gameBoard[27] = new PropertyField(27, WHITE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),);
        gameBoard[28] = new SodaField(28, RED, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),5200,2600,8);
        gameBoard[29] = new PropertyField(29, WHITE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),5600,2800,8);
        gameBoard[30] = new JailField(30, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[31] = new PropertyField(31, YELLOW, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),6000,3000,9);
        gameBoard[32] = new PropertyField(32, YELLOW, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),6000,3000,9);
        gameBoard[33] = new ChanceCardField(33, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), BLACK, black));
        gameBoard[34] = new PropertyField(34, YELLOW, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),6400,3200,9);
        gameBoard[35] = new FerryField(35, BLUE, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),4000,2000,1);
        gameBoard[36] = new ChanceCardField(36, BLACK, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), BLACK, black));
        gameBoard[37] = new PropertyField(37, MAGENTA, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),7000,3500,10);
        gameBoard[38] = new TaxField(38, cyan, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK));
        gameBoard[39] = new PropertyField(39, MAGENTA, language.getText(0,0), new GUI_Start(language.getText
                (0,0), language.getText(0,0), language.getText(0,0), cyan, BLACK),8000,4000,10);

    }
    public Field[] getGameBoard() {
        return gameBoard;
    }
}
