package Controller;

import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class GUIController {
    //Todo  we need to load in fields later
    GUI gui = new GUI();

    //
    public String buttons(String msg,String... buttons){
        return gui.getUserButtonPressed(msg,buttons);
    }
    public void showMessage(String message){
        gui.showMessage(message);
    }
    public void showDice(int dice){
        gui.setDie(dice);
    }
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
    public void updatePlayerBal(int bal, GUI_Player player){
        player.setBalance(bal);
    }

    //public boolean isInstanceOfField(int currentposition){
    //    return (field[currentposition] instanceof GUI_Street);
    //}
    public void changeBalce(int bal ,GUI_Player player){
        player.setBalance(bal);
    }
}
