package Game;


import Controller.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;


import java.awt.*;

/**
 * @author “Louis”
 *
 */


public abstract class BuyableField extends Field
{

    protected int price;
    protected int owner;
    protected boolean isPropertyBought;
    protected int pawnValue;
    protected boolean isPawned;
    protected int group;

    public BuyableField(int positionID, Color colorID, String name, GUI_Field guiField, int price, int pawnValue, int group)
    {
        super(positionID, colorID, name, guiField);
        this.price = price;
        int owner;
        isPropertyBought = false;
        this.pawnValue = pawnValue;
        this.group = group;
    }

    public int getGroup()
    {
        return this.group;
    }
    public int getOwner()
    {
        return this.owner-1;
    }
    public int getPawnValue() {return this.pawnValue;}
    public int getPrice(){return this.price;}
    public boolean getIsPawned(){return this.isPawned;}
    public void setIsPawned(boolean set) {this.isPawned =set;}


    @Override
    public void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController playerController, GUIController guiController, Language language)
    {
        if(!isPropertyBought)
        {
            if (guiController.buttons(playerController.getCurrentPlayer().getName(), language.getText(15,3),language.getText(15,4)) == language.getText(15, 3))
            {
                buy(playerController.getCurrentPlayer());
            }
            else
                {
                    auction(language, guiController, playerController.getPlayerArray());
                }
        }
        else
            {
                int fieldRent = payRent(playerController,gameBoard, language);
                playerController.getCurrentPlayer().subtractBalance(fieldRent);
                BuyableField fieldLandedOn = (BuyableField)gameBoard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition()%40];
                playerController.getPlayerArray()[fieldLandedOn.getOwner()].addBalance(fieldRent);
            }

    }

    public void buy(Player player)
    {
        this.owner = player.getPlayerID();
        this.isPropertyBought = true;
        player.subtractBalance(price);
        GUI_Ownable buy = (GUI_Ownable) this.guiField;
        buy.setOwnerName(player.getName());
        buy.setBorder(player.getGUIPlayer().getCar().getPrimaryColor());
    }

    public void auction(Language language,GUIController guiController, Player[] players)
    {
        Boolean[] playerInActuin = new Boolean[players.length];
        int min = 0;
        int i = 0;
        int playerLeftInAuction = players.length ;
        boolean onGoingAuction = true;
        int amountOfPlayer = players.length;

            while(onGoingAuction)
            {
                i = ((i + 1) % amountOfPlayer);
                if(playerInActuin[i] == null)
                {
                    if (playerLeftInAuction != 1) {
                        String playerChose = guiController.buttons(players[i].getName()+" "+language.getText(15, 6), language.getText(15, 7), language.getText(15, 8));
                        if (playerChose == language.getText(15, 7)) {

                            min = guiController.integerInput(players[i].getName() + " " + language.getText(15, 10) + min, min, 100000);
                        } else {
                            playerInActuin[i] = false;
                            playerLeftInAuction--;
                        }
                    }else{
                        this.owner = players[i].getPlayerID();
                        this.isPropertyBought = true;
                        players[i].subtractBalance(min);
                        GUI_Ownable buy = (GUI_Ownable) this.guiField;
                        buy.setOwnerName(players[i].getName());
                        buy.setBorder(players[i].getGUIPlayer().getCar().getPrimaryColor());
                    break;
                }
                }
            }
    }
    public abstract int payRent(PlayerController playerController,GameBoard gameBoard, Language language);
}
