package Game;


import Controller.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;


import java.awt.*;

/**
 * @author Louis
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

    /**
     *
     * @param gameBoard
     * @param chanceCardController
     * @param playerController
     * @param guiController
     * @param language
     * Checks if property is bought. If not, then it gives you the option between buying or auctioning it.
     * If it is, then it checks if the player is the owner. If not he pays rent to the owner. If he is, nothing happens.
     */
    @Override
    public void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController playerController, GUIController guiController, Language language)
    {
        if(!isPropertyBought)
        {
            if (guiController.buttons(playerController.getCurrentPlayer().getName(), language.getText(15,3),language.getText(15,4)) == language.getText(15, 3))
            {
                buy(playerController);
            }
            else
                {
                    auction(language, guiController, playerController);
                }
        }
        else {
            int fieldRent = payRent(playerController, gameBoard, language);
            BuyableField fieldLandedOn = (BuyableField) gameBoard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition() % 40];
            if (!playerController.getPlayerArray()[fieldLandedOn.owner-1].isInJail() && !fieldLandedOn.getIsPawned())
            {
                playerController.getCurrentPlayer().subtractBalance(fieldRent);
                playerController.getPlayerArray()[fieldLandedOn.getOwner()].addBalance(fieldRent);
            }
            }
    }

    public void buy(PlayerController playerController)
    {
        this.owner = playerController.getCurrentPlayer().getPlayerID();
        this.isPropertyBought = true;
        playerController.getCurrentPlayer().subtractBalance(price);
        GUI_Ownable buy = (GUI_Ownable) this.guiField;
        buy.setOwnerName(playerController.getCurrentPlayer().getName());
        buy.setBorder(playerController.getCurrentPlayer().getGUIPlayer().getCar().getPrimaryColor());
    }

    /**
     *
     * @param language
     * @param guiController
     * @param playerController
     * Creates an auction, where all players are put into a new temporary array of booleans.
     * If they player decides to decide not to participate they're set to false.
     * The auction keeps going until there's only one player left, which wins the auction and becomes owner of the field.
     */
    public void auction(Language language,GUIController guiController, PlayerController playerController)
    {
        Boolean[] playerInAuction = new Boolean[playerController.getPlayerArray().length];
        int min = 0;
        int i = 0;
        int playerLeftInAuction = playerController.getPlayerArray().length ;
        boolean onGoingAuction = true;
        int amountOfPlayer = playerController.getPlayerArray().length;

            while(onGoingAuction)
            {
                i = ((i + 1) % amountOfPlayer);
                if(playerInAuction[i] == null)
                {
                    if (playerLeftInAuction != 1) {
                        String playerChose = guiController.buttons(playerController.getPlayerArray()[i].getName()+" "+language.getText(15, 6), language.getText(15, 7), language.getText(15, 8));
                        if (playerChose == language.getText(15, 7)) {

                            min = guiController.integerInput(playerController.getPlayerArray()[i].getName() + " " + language.getText(15, 10) +" " + min, min+100, 100000);
                        } else {
                            playerInAuction[i] = false;
                            playerLeftInAuction--;
                        }
                    }else{
                        if(min != 0) {
                            this.owner = playerController.getPlayerArray()[i].getPlayerID();
                            this.isPropertyBought = true;
                            playerController.getPlayerArray()[i].subtractBalance(min);
                            GUI_Ownable buy = (GUI_Ownable) this.guiField;
                            buy.setOwnerName(playerController.getPlayerArray()[i].getName());
                            buy.setBorder(playerController.getPlayerArray()[i].getGUIPlayer().getCar().getPrimaryColor());
                        }
                        break;

                }
                }
            }
    }
    public abstract int payRent(PlayerController playerController,GameBoard gameBoard, Language language);
}
