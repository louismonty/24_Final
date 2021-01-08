package Game;

import Controller.GUIController;
import Controller.PlayerController;
import gui_fields.GUI_Field;
import Controller.GUIController;

import java.awt.*;

/**
 * @author “Daniel”
 *
 */


public abstract class BuyableField extends Field {

    protected int price;
    protected int rent;
    protected int owner;
    protected boolean isPropertyBought;
    protected int pawnValue;
    protected boolean isPawned;
    protected int group;

    public BuyableField(int positionID, Color colorID, String name, GUI_Field guiField, int price, int rent, int pawnValue, int group)
    {
        super(positionID, colorID, name, guiField);
        this.price = price;
        this.rent = rent;
        int owner;
        isPropertyBought = false;
        this.pawnValue = pawnValue;
        this.group = group;
    }
    public void buyOrAuctionMenu(GUIController guiController, Language language, PlayerController playerController){
        if(guiController.buttons(language.getText(0,0), language.getLine(0)) == language.getText(0,0)){
            buy(playerController.getCurrentPlayer());
        }
        else{
            auction(language,guiController,playerController.getPlayerArray());
        }
    }

    public void buy(Player player) {
        owner = player.getPlayerID;
        player.subtractBalance(price);
    }

    public void auction(Language language,GUIController guiController, Player[] players) {
        int min = 0;
        int i = 0;
        boolean onGoingAuction = true;
        int amountOfPlayer = players.length;

            while(onGoingAuction ==true){
                i = i + 1 % amountOfPlayer;
                if(players[i]==null) {
                    String  playerChose = guiController.buttons(language.getText(0,0),language.getLine(1));
                    if (playerChose == language.getText(0, 0)) {
                        if (players[i] == null) {
                            min = guiController.integerInput(language.getText(0, 0) + players[i].getName(), min, 100000);
                            Player lastPlayer = players[i];
                            if(lastPlayer == players[i]){
                                break;
                            }
                        }
                    } else {
                        players[i] = null;
                    }
                }
            }
    }
}
