package Game;

import Game.*;
import gui_fields.*;
import gui_main.GUI;

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
                (13,3), language.getText(13,3), language.getText(13,3), new Color(210, 43, 43, 255), BLACK));

        gameBoard[1] = new PropertyField(1, BLUE,"Rødovrevej", new GUI_Street(language.getText
                (13,4), language.getText(53,2),getDescription(language,30),language.getText(53,2), new Color(61, 118, 210), BLACK),1200,600,3, 1000,30);

        gameBoard[2] = new ChanceCardField(2, BLACK,"Prøv lykken", new GUI_Chance(language.getText
                (13,2), language.getText(13,2), language.getText(13,2), black, GREEN));

        gameBoard[3] = new PropertyField(3, BLUE,"Hvidovrevej", new GUI_Street(language.getText
                (13,5), language.getText(53,2),getDescription(language,31),language.getText(53,2), new Color(61, 118, 210), BLACK),1200,600,3, 1000,31);

        gameBoard[4] = new TaxField(4, cyan,"Indkomstskat", new GUI_Tax(language.getText
                (13,6), language.getText(13,6), language.getText(13,6), new Color(139, 177, 255), BLACK));

        gameBoard[5] = new FerryField(5, BLUE,"Scandlines", new GUI_Shipping("default",language.getText
                (13,7), language.getText(53,9), getFerryDescription(language),language.getText(53,9), new Color(37, 71, 127), BLACK),4000,2000,1);

        gameBoard[6] = new PropertyField(6, ORANGE,"Roskildevej", new GUI_Street(language.getText
                (13,8), language.getText(53,3), getDescription(language,32),language.getText(53,3), new Color(226, 76, 12), BLACK),2000,1000,4, 1000,32);

        gameBoard[7] = new ChanceCardField(7, BLACK,"Prøv lykken", new GUI_Chance(language.getText
                (13,2), language.getText(13,2), language.getText(13,2), black, GREEN));

        gameBoard[8] = new PropertyField(8, ORANGE,"Valby Langgade", new GUI_Street(language.getText
                (13,9), language.getText(53,3), getDescription(language,33),language.getText(53,3), new Color(226, 76, 12), BLACK),2000,1000,4,1000,33);

        gameBoard[9] = new PropertyField(9, ORANGE,"Allégade", new GUI_Street(language.getText
                (13,10), language.getText(53,4), getDescription(language,34),language.getText(53,4), new Color(226, 76, 12), BLACK),2400,1200,4,1000,34);

        gameBoard[10] = new JailField(10, BLACK,"Fængsel", new GUI_Jail("default",language.getText
                (13,11), language.getText(13,11), language.getText(13,11), black, WHITE));

        gameBoard[11] = new PropertyField(11, YELLOW,"Frederiksberg Allé", new GUI_Street(language.getText
                (13,12), language.getText(53,5), getDescription(language,35),language.getText(53,5), new Color(154, 120, 21), BLACK),2800,1400,5,2000,35);

        gameBoard[12] = new SodaField(12, RED,"Soda", new GUI_Brewery("default",language.getText
                (13,13), language.getText(53,6), (language.getText(58,2)+"\n"+language.getText(55,6)+" "+language.getText(58,6)),language.getText(53,6), new Color(210, 43, 43, 255), BLACK),3000,1500,2);

        gameBoard[13] = new PropertyField(13, YELLOW,"Bülowsvej", new GUI_Street(language.getText
                (13,14), language.getText(53,5),getDescription(language,36),language.getText(53,5), new Color(154, 120, 21), BLACK),2800,1400,5,2000,36);

        gameBoard[14] = new PropertyField(14, YELLOW,"GL. Kongevej", new GUI_Street(language.getText
                (13,15), language.getText(53,7), getDescription(language,37),language.getText(53,7), new Color(154, 120, 21), BLACK),3200,1600,5,2000,37);

        gameBoard[15] = new FerryField(15, RED,"Mols-Linien", new GUI_Shipping("default",language.getText
                (13,16), language.getText(53,9), getFerryDescription(language),language.getText(53,9), new Color(210, 43, 43, 255), BLACK),4000,2000,1);

        gameBoard[16] = new PropertyField(16, GRAY,"Bernstorffsvej", new GUI_Street(language.getText
                (13,17), language.getText(53,8), getDescription(language,38),language.getText(53,8), lightGray, BLACK),3600,1800,6,2000,38);

        gameBoard[17] = new ChanceCardField(17, BLACK,"Prøv lykken", new GUI_Chance(language.getText
                (13,2), language.getText(13,2), language.getText(13,2), black, GREEN));

        gameBoard[18] = new PropertyField(18, GRAY,"Hellerupvej", new GUI_Street(language.getText
                (13,18), language.getText(53,8), getDescription(language,39),language.getText(53,8), lightGray, BLACK),3600,1800,6,2000,39);

        gameBoard[19] = new PropertyField(19, GRAY,"Strandvejen", new GUI_Street(language.getText
                (13,19), language.getText(53,9), getDescription(language,40),language.getText(53,9), lightGray, BLACK),4000,2000,6,2000,40);

        gameBoard[20] = new CustomField(20, cyan,"Parkering", new GUI_Refuge("default",language.getText
                (13,20), language.getText(13,20), language.getText(13,20), new Color(139, 177, 255), BLACK));

        gameBoard[21] = new PropertyField(21, RED,"Trianglen", new GUI_Street(language.getText
                (13,21), language.getText(53,10), getDescription(language,41),language.getText(53,10), new Color(177, 38, 38, 255), BLACK),4400,2200,7,3000,41);

        gameBoard[22] = new ChanceCardField(22, BLACK,"Prøv lykken", new GUI_Chance(language.getText
                (13,2), language.getText(13,2), language.getText(13,2), black, GREEN));

        gameBoard[23] = new PropertyField(23, RED,"Østerbrogade", new GUI_Street(language.getText
                (13,22), language.getText(53,10), getDescription(language,42),language.getText(53,10), new Color(177, 38, 38, 255), BLACK),4400,2200,7,3000,42);

        gameBoard[24] = new PropertyField(24, RED,"Grønningen", new GUI_Street(language.getText
                (13,23), language.getText(53,11), getDescription(language,43),language.getText(53,11), new Color(177, 38, 38, 255), BLACK),4800,2400,7,3000,43);

        gameBoard[25] = new FerryField(25, BLUE,"Scandlines", new GUI_Shipping("default",language.getText
                (13,24), language.getText(53,9), getFerryDescription(language),language.getText(53,9), new Color(37, 71, 127), BLACK),4000,2000,1);

        gameBoard[26] = new PropertyField(26, WHITE,"Bredgade", new GUI_Street(language.getText
                (13,25), language.getText(53,12),getDescription(language,44),language.getText(53,12), white, BLACK),5200,2600,8,3000,44);

        gameBoard[27] = new PropertyField(27, WHITE,"Kgs. Nytorv", new GUI_Street(language.getText
                (13,26), language.getText(53,12), getDescription(language,45),language.getText(53,12), white, BLACK),5200, 2600, 8, 3000,45);

        gameBoard[28] = new SodaField(28, RED,"Coca Cola", new GUI_Brewery("default",language.getText
                (13,27), language.getText(53,6), (language.getText(58,2)+"\n"+language.getText(55,6)+" "+language.getText(58,6)),language.getText(53,6), new Color(210, 43, 43, 255), BLACK),5200,2600,2);

        gameBoard[29] = new PropertyField(29, WHITE,"Østergade", new GUI_Street(language.getText
                (13,28), language.getText(53,13), getDescription(language,46),language.getText(53,13), white, BLACK),5600,2800,8, 3000,46);

        gameBoard[30] = new JailField(30, BLACK,"Fængsel", new GUI_Jail("default",language.getText
                (13,29), language.getText(13,29), language.getText(13,29), black, WHITE));

        gameBoard[31] = new PropertyField(31, YELLOW,"Amagertorv", new GUI_Street(language.getText
                (13,30), language.getText(53,14), getDescription(language,47),language.getText(53,14), yellow, BLACK),6000,3000,9, 4000,47);

        gameBoard[32] = new PropertyField(32, YELLOW,"Vimmelskaftet", new GUI_Street(language.getText
                (13,31), language.getText(53,14), getDescription(language,48),language.getText(53,14), yellow, BLACK),6000,3000,9, 4000,48);

        gameBoard[33] = new ChanceCardField(33, BLACK,"Prøv lykken", new GUI_Chance(language.getText
                (13,2), language.getText(13,2), language.getText(13,2), black, GREEN));

        gameBoard[34] = new PropertyField(34, YELLOW,"Nygade", new GUI_Street(language.getText
                (13,32), language.getText(53,15),getDescription(language,49),language.getText(53,15), yellow, BLACK),6400,3200,9,4000,49);

        gameBoard[35] = new FerryField(35, BLUE,"Scandlines", new GUI_Shipping("default",language.getText
                (13,33), language.getText(53,9), getFerryDescription(language),language.getText(53,9), new Color(37, 71, 127), BLACK),4000,2000,1);

        gameBoard[36] = new ChanceCardField(36, BLACK,"Prøv lykken", new GUI_Chance(language.getText
                (13,2), language.getText(13,2), language.getText(13,2), black, GREEN));

        gameBoard[37] = new PropertyField(37, MAGENTA,"Frederiksberggade", new GUI_Street(language.getText
                (13,34), language.getText(53,16), getDescription(language,50),language.getText(53,16), new Color(105, 35, 175), BLACK),7000,3500,10, 4000,50);

        gameBoard[38] = new TaxField(38, cyan,"Ekstraordinærstatsskat", new GUI_Tax(language.getText
                (13,35), language.getText(53,20), language.getText(13,35), new Color(139, 177, 255), BLACK));

        gameBoard[39] = new PropertyField(39, MAGENTA,"Rådhuspladsen", new GUI_Street(language.getText
                (13,36), language.getText(53,17), getDescription(language,51),language.getText(53,17), new Color(105, 35, 175), BLACK),8000,4000,10,4000,51);


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
    public String getDescription(Language language, int lineNumber)
    {
        String description = "";
        for(int i = 2; i<11; i++)
        {
            description += language.getText(29, i)+" ";
            description += language.getText(lineNumber, i) + "\n";
        }
        return description;
    }
    public String getFerryDescription(Language language)
    {
        String description = "";
        for(int i = 2; i<7; i++)
        {
            description += language.getText(55, i)+" ";
            description += language.getText(56, i) + "\n";
        }
        return description;
    }
}
