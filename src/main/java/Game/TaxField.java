package Game;

import java.awt.*;
import java.awt.color.*;
import Controller.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import Game.Language;

/**
 * @author Lucas
 * TaxField class that extends Field. Includes two methods: payIncomeTax() and payUnexpectedTax().
 */

public class TaxField extends Field {
    private int incomeTax = 4000;
    private int unexpectedTax = 2000;
    private int incomeTaxField = 5;
    private int unexpectedTaxField = 39;
    private double taxRate = 0.1;

    public TaxField(int positionID, String name, GUI_Field guiField, Color color){
        super(positionID, color, name, guiField);
    }

    /**
     * @param currentPlayer
     * @param guiController
     * @return void
     * Player chooses to subtract 4000 or 10% from all his/her belongings.
     */
    public void payIncomeTax(Player currentPlayer, GUIController guiController, Language language){
        String valgmulighed = guiController.buttons(language.getText(0,0), language.getText(1,1), language.getText(1,1));

        if(valgmulighed.equals("4000")) {
            currentPlayer.getAccount().subtractBalance(incomeTax);
        }
        /*
        else if(valg.equals("10%")){
            currentPlayer.getAccount().subtractBalance((currentPlayer.getAccount().getBalance() * taxRate));
        }
        */
    }

    /**
     * @param currentPlayer
     * @param guiController
     * @return void
     * Unexpected tax gets subtracted from the current player's account.
     */
    public void payUnexpectedTax(Player currentPlayer, GUIController guiController){
        currentPlayer.getAccount().subtractBalance(unexpectedTax);
    }

    /**
     *
     * @param gameBoard
     * @param chanceCardController
     * @param playerController
     * @param guiController
     * @return void
     * In landOnField payIncomeTax is executed if a player lands on incomeTaxField. Otherwise, payUnexpectedTax is executed
     * if a player lands on unexpectedTaxField.
     */

    public void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController playerController, GUIController guiController) {
        if(playerController.getCurrentPlayer().getPlayerPosition() == incomeTaxField){
            payIncomeTax(playerController.getCurrentPlayer(), guiController, language);
        }
        else if(playerController.getCurrentPlayer().getPlayerPosition() == unexpectedTaxField){
            payUnexpectedTax(playerController.getCurrentPlayer(), guiController, language);
        }
    }
}
