package Game;

import java.awt.*;
import java.awt.color.*;
import Controller.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import Game.Language;
import Game.GameBoard;
import java.lang.Math;

/**
 * @author Lucas
 * TaxField class that extends Field. Includes two methods: payIncomeTax() and payUnexpectedTax().
 */

public class TaxField extends Field {
    private int incomeTax = 4000;
    private int unexpectedTax = 2000;
    private int incomeTaxField = 4; //4 in GameBoard class
    private int unexpectedTaxField = 38; //38 in GameBoard class
    private float taxRate = 0.1f;

    public TaxField(int positionID, Color color, String name, GUI_Field guiField){
        super(positionID, color, name, guiField);
    }

    /**
     * @param currentPlayer
     * @param guiController
     * @return void
     * Player chooses to subtract 4000 or 10% from all his/her belongings.
     */
    public void payIncomeTax(Player currentPlayer, GUIController guiController, Language language, GameBoard gameboard){
        String buttons = guiController.buttons(language.getText(19,5), language.getText(19,6), language.getText(19,7));

        if(buttons.equals(language.getText(19,7))) {
            currentPlayer.getAccount().subtractBalance(incomeTax);
            guiController.showMessage(language.getText(19,2));
        }
        else if(buttons.equals(language.getText(19,6))) {
            int totalAmount = currentPlayer.getAccount().getBalance();
            for (int i = 0; i < gameboard.getGameBoard().length; i++) {
                if (gameboard.getGameBoard()[i] instanceof BuyableField) {
                    totalAmount += ((BuyableField) gameboard.getGameBoard()[i]).getPrice();
                    if (gameboard.getGameBoard()[i] instanceof PropertyField) {
                        if (((PropertyField) gameboard.getGameBoard()[i]).getHouses() > 0) {
                            totalAmount += (((PropertyField) gameboard.getGameBoard()[i]).getHouses() * ((PropertyField) gameboard.getGameBoard()[i]).getHousePrice());
                        }
                    }
                }
            }
            int taxPaymentDue = Math.round(totalAmount * taxRate);
            guiController.showMessage(language.getText(19,2)); // "Du skal betale 10% af dine penge"
            currentPlayer.subtractBalance(taxPaymentDue);
        }
    }

    /**
     * @param currentPlayer
     * @param guiController
     * @return void
     * Unexpected tax gets subtracted from the current player's account.
     */
    public void payUnexpectedTax(Player currentPlayer, GUIController guiController, Language language){
        currentPlayer.getAccount().subtractBalance(unexpectedTax);
        guiController.showMessage(language.getText(19,4)); //"Tax has been deducted."
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

    public void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController playerController, GUIController guiController, Language language) {
        if(playerController.getCurrentPlayer().getPlayerPosition() == incomeTaxField){
            payIncomeTax(playerController.getCurrentPlayer(), guiController, language, gameBoard);
        }
        else if(playerController.getCurrentPlayer().getPlayerPosition() == unexpectedTaxField){
            payUnexpectedTax(playerController.getCurrentPlayer(), guiController, language);
        }
    }
}
