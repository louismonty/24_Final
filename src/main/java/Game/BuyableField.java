package Game;


import Controller.*;
import gui_fields.GUI_Field;


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
        return this.owner;
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
            if (guiController.buttons(language.getText(0, 0), language.getLine(0)) == language.getText(0, 0))
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
                BuyableField fieldLandedOn = (BuyableField)gameBoard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition()];
                playerController.getPlayerArray()[fieldLandedOn.getOwner()].addBalance(fieldRent);
            }

    }

    public void buy(Player player)
    {
        owner = player.getPlayerID();
        player.subtractBalance(price);
    }

    public void auction(Language language,GUIController guiController, Player[] players)
    {
        int min = 0;
        int i = 0;
        boolean onGoingAuction = true;
        int amountOfPlayer = players.length;

            while(onGoingAuction ==true)
            {
                i = i + 1 % amountOfPlayer;
                if(players[i]==null)
                {
                    String  playerChose = guiController.buttons(language.getText(0,0),language.getLine(1));
                    if (playerChose == language.getText(0, 0))
                    {
                        if (players[i] == null)
                        {
                            min = guiController.integerInput(language.getText(0, 0) + players[i].getName(), min, 100000);
                            Player lastPlayer = players[i];
                            if(lastPlayer == players[i])
                            {
                                break;
                            }
                        }
                    }
                    else
                        {
                            players[i] = null;
                        }
                }
            }
    }
    public abstract int payRent(PlayerController playerController,GameBoard gameBoard, Language language);
}
