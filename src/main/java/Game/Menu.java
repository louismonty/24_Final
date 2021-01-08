package Game;

import Controller.GUIController;

public class Menu {
    public void takeTurnMenu(Language language,GUIController guiController,Player player){
        while (true) {
            String playerChose = guiController.buttons(language.getText(0,0), language.getLine(1));
            if (playerChose == language.getText(1, 0)) {
                break;
            }
            else if((playerChose == language.getText(1, 1))){
                System.out.println("test2");
            }
            else if(playerChose == language.getText(1, 2)) {
                System.out.println("test2");
            }
            else if(playerChose == language.getText(1, 3)){
                System.out.println("test3");
            }
            else if(playerChose == language.getText(1, 4)){
                System.out.println("test4");
            }
        }
    }
    public void buyHouseOrHotel(Language language,GUIController guiController,Player player){
        String playerChose = guiController.buttons(language.getText(0, 0));



    }
    }


