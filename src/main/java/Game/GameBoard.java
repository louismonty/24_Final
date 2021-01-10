package Game;

import Game.*;
import gui_fields.*;
import gui_main.GUI;
import org.graalvm.compiler.core.common.Fields;

import java.awt.*;

import static java.awt.Color.*;


/**
 * @author “Daniel”
 *
 */

public class GameBoard {

    private Field[] gameBoard = new Field[40];

    public GameBoard(Language language){
        gameBoard[0] = new StartField(0, RED,"Start", new GUI_Start(language.getText
                (13,1), language.getText(12,2), language.getText(12,3), RED, BLACK));

        gameBoard[1] = new PropertyField(1, BLUE,"Rødovrevej", new GUI_Street(language.getText
                (13,4), language.getText(13,5), language.getText(13,6), cyan, BLACK),1200,600,3, 1000,30);

        gameBoard[2] = new ChanceCardField(2, BLACK,"Prøv lykken", new GUI_Chance(language.getText
                (13,7), language.getText(13,8), language.getText(13,9), BLACK, black));

        gameBoard[3] = new PropertyField(3, BLUE,"Hvidovrevej", new GUI_Street(language.getText
                (13,10), language.getText(13,11), language.getText(13,12), cyan, BLACK),1200,600,3, 1000,31);

        gameBoard[4] = new TaxField(4, cyan,"Indkomstskat", new GUI_Tax(language.getText
                (13,13), language.getText(13,14), language.getText(13,15), cyan, BLACK));

        gameBoard[5] = new FerryField(5, BLUE,"Scandlines", new GUI_Shipping(language.getText
                (13,16), language.getText(13,17), language.getText(13,18), cyan, BLACK),4000,2000,1);

        gameBoard[6] = new PropertyField(6, ORANGE,"Roskildevej", new GUI_Street(language.getText
                (13,19), language.getText(13,20), language.getText(13,21), cyan, BLACK),2000,1000,4, 1000,32);

        gameBoard[7] = new ChanceCardField(7, BLACK,"Prøv lykken", new GUI_Chance(language.getText
                (13,22), language.getText(13,23), language.getText(13,24), BLACK, black));

        gameBoard[8] = new PropertyField(8, ORANGE,"Valby Langgade", new GUI_Street(language.getText
                (13,25), language.getText(13,26), language.getText(13,27), cyan, BLACK),2000,1000,4,1000,33);

        gameBoard[9] = new PropertyField(9, ORANGE,"Allégade", new GUI_Street(language.getText
                (13,28), language.getText(13,29), language.getText(13,30), cyan, BLACK),2400,1200,4,1000,34);

        gameBoard[10] = new JailField(10, BLACK,"Fængsel", new GUI_Jail("default",language.getText
                (13,31), language.getText(13,32), language.getText(13,33), cyan, BLACK));

        gameBoard[11] = new PropertyField(11, YELLOW,"Frederiksberg Allé", new GUI_Street(language.getText
                (13,34), language.getText(13,35), language.getText(13,36), cyan, BLACK),2800,1400,5,2000,35);

        gameBoard[12] = new SodaField(12, RED,"Soda", new GUI_Brewery(language.getText
                (13,37), language.getText(13,38), language.getText(13,39), cyan, BLACK),3000,1500,2);

        gameBoard[13] = new PropertyField(13, YELLOW,"Bülowsvej", new GUI_Street(language.getText
                (13,40), language.getText(13,41), language.getText(13,42), cyan, BLACK),2800,1400,5,2000,36);

        gameBoard[14] = new PropertyField(14, YELLOW,"GL. Kongevej", new GUI_Street(language.getText
                (13,43), language.getText(13,44), language.getText(13,45), cyan, BLACK),3200,1600,5,2000,37);

        gameBoard[15] = new FerryField(15, RED,"Mols-Linien", new GUI_Shipping(language.getText
                (13,46), language.getText(13,47), language.getText(13,48), cyan, BLACK),4000,2000,1);

        gameBoard[16] = new PropertyField(16, GRAY,"Bernstorffsvej", new GUI_Street(language.getText
                (13,49), language.getText(13,50), language.getText(13,51), cyan, BLACK),3600,1800,6,2000,38);

        gameBoard[17] = new ChanceCardField(17, BLACK,"Prøv lykken", new GUI_Chance(language.getText
                (13,52), language.getText(13,53), language.getText(13,54), BLACK, black));

        gameBoard[18] = new PropertyField(18, GRAY,"Hellerupvej", new GUI_Street(language.getText
                (13,55), language.getText(13,56), language.getText(13,57), cyan, BLACK),3600,1800,6,2000,39);

        gameBoard[19] = new PropertyField(19, GRAY,"Strandvejen", new GUI_Street(language.getText
                (13,58), language.getText(13,59), language.getText(13,60), cyan, BLACK),4000,2000,6,2000,40);

        gameBoard[20] = new CustomField(20, cyan,"Parkering", new GUI_Refuge("default",language.getText
                (13,61), language.getText(13,62), language.getText(13,63), cyan, BLACK));

        gameBoard[21] = new PropertyField(21, RED,"Trianglen", new GUI_Street(language.getText
                (13,64), language.getText(13,65), language.getText(13,66), cyan, BLACK),4400,2200,7,3000,41);

        gameBoard[22] = new ChanceCardField(22, BLACK,"Prøv lykken", new GUI_Chance(language.getText
                (13,67), language.getText(13,68), language.getText(13,69), BLACK, black));

        gameBoard[23] = new PropertyField(23, RED,"Østerbrogade", new GUI_Street(language.getText
                (13,70), language.getText(13,71), language.getText(13,72), cyan, BLACK),4400,2200,7,3000,42);

        gameBoard[24] = new PropertyField(24, RED,"Grønningen", new GUI_Street(language.getText
                (13,73), language.getText(13,74), language.getText(13,75), cyan, BLACK),4800,2400,7,3000,43);

        gameBoard[25] = new FerryField(25, BLUE,"Scandlines", new GUI_Shipping(language.getText
                (13,76), language.getText(13,77), language.getText(13,78), cyan, BLACK),4000,2000,1);

        gameBoard[26] = new PropertyField(26, WHITE,"Bredgade", new GUI_Street(language.getText
                (13,79), language.getText(13,80), language.getText(13,81), cyan, BLACK),5200,2600,8,3000,44);

        gameBoard[27] = new PropertyField(27, WHITE,"Kgs. Nytorv", new GUI_Street(language.getText
                (13,82), language.getText(13,83), language.getText(13,84), cyan, BLACK),5200, 2600, 8, 3000,45);

        gameBoard[28] = new SodaField(28, RED,"Coca Cola", new GUI_Brewery(language.getText
                (13,85), language.getText(13,86), language.getText(13,87), cyan, BLACK),5200,2600,2);

        gameBoard[29] = new PropertyField(29, WHITE,"Østergade", new GUI_Street(language.getText
                (13,88), language.getText(13,89), language.getText(13,90), cyan, BLACK),5600,2800,8, 3000,46);

        gameBoard[30] = new JailField(30, BLACK,"Fængsel", new GUI_Jail("default",language.getText
                (13,91), language.getText(13,92), language.getText(13,93), cyan, BLACK));

        gameBoard[31] = new PropertyField(31, YELLOW,"Amagertorv", new GUI_Street(language.getText
                (13,94), language.getText(13,95), language.getText(13,96), cyan, BLACK),6000,3000,9, 4000,47);

        gameBoard[32] = new PropertyField(32, YELLOW,"Vimmelskaftet", new GUI_Street(language.getText
                (13,97), language.getText(13,98), language.getText(13,99), cyan, BLACK),6000,3000,9, 4000,48);

        gameBoard[33] = new ChanceCardField(33, BLACK,"Prøv lykken", new GUI_Chance(language.getText
                (13,100), language.getText(13,101), language.getText(13,102), BLACK, black));

        gameBoard[34] = new PropertyField(34, YELLOW,"Nygade", new GUI_Street(language.getText
                (13,103), language.getText(13,104), language.getText(13,105), cyan, BLACK),6400,3200,9,4000,49);

        gameBoard[35] = new FerryField(35, BLUE,"Scandlines", new GUI_Shipping(language.getText
                (13,106), language.getText(13,107), language.getText(13,108), cyan, BLACK),4000,2000,1);

        gameBoard[36] = new ChanceCardField(36, BLACK,"Prøv lykken", new GUI_Chance(language.getText
                (13,109), language.getText(13,110), language.getText(13,111), BLACK, black));

        gameBoard[37] = new PropertyField(37, MAGENTA,"Frederiksberggade", new GUI_Street(language.getText
                (13,112), language.getText(13,113), language.getText(13,114), cyan, BLACK),7000,3500,10, 4000,50);

        gameBoard[38] = new TaxField(38, cyan,"Ekstraordinærstatsskat", new GUI_Tax(language.getText
                (13,115), language.getText(13,116), language.getText(13,117), cyan, BLACK));

        gameBoard[39] = new PropertyField(39, MAGENTA,"Rådhuspladsen", new GUI_Street(language.getText
                (13,118), language.getText(13,119), language.getText(13,120), cyan, BLACK),8000,4000,10,4000,51);


    }
    public Field[] getGameBoard() {
        return gameBoard;
    }
    public GUI_Field[] getGuiGamebord(){
        GUI_Field[] Fields = new GUI_Field[40];
        for(int i = 0;i<getGameBoard().length;i++){
            Fields[i] = getGameBoard()[i].guiField;
        }
        return Fields;

    }
}
