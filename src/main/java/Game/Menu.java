package Game;

import Controller.GUIController;

public class Menu {
    public String takeTurnMenu(Language language,GUIController guiController){

        return guiController.buttons(language.getText(0,0),language.getLine(1));
    }
}
