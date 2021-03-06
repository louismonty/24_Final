package Controller;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

/**
 * @author Louis
 */
public class GUIController {
    GUI gui;
    public void createGUIBoard(GUI_Field[] fields){
        gui = new GUI(fields);
    }



    public String buttons(String msg,String... buttons){
        return gui.getUserButtonPressed(msg,buttons);
    }
    public void showMessage(String message){
        gui.showMessage(message);
    }
    public void showDice(int faceValueDice1,int x1, int y1,int faceValueDice2,int x2, int y2){
        gui.setDice(faceValueDice1,x1, y1, faceValueDice2, x2, y2);
    }

    /**
     *
     * @param text
     * @param min
     * @param max
     * @return int
     * Creates a box taking an integer input on the GUI from the user.
     */
    public int integerInput(String text,int min, int max){
        int input;
        while(true){
            input = gui.getUserInteger(text,min,max);
            if(min <= input&& input<=max){
                break;
            }
        }
        return input;
    }
    public void addPlayer(GUI_Player player){
        gui.addPlayer(player);
    }
    public String stringInput(String text){
        return gui.getUserString(text);
    }
    //Todo fild ting skal ind senere
    public void showChanceCard(String text){
        gui.displayChanceCard(text);
    }


}
