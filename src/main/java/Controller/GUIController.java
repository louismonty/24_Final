package Controller;

import gui_main.GUI;

public class GUIController {
    //Todo  we need to load in fields later
    GUI gui = new GUI();

    //
    public String buttons(String msg,String... buttons){
        return gui.getUserButtonPressed(msg,buttons);
    }
}
