package Game;

import java.awt.*;
import java.awt.color.*;
import Controller.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

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

    public void payIncomeTax(Player currentPlayer, GUIController guiController){
        if()
        currentPlayer.getAccount().subtractBalance(incomeTax);
    }

    public void payUnexpectedTax(Player currentPlayer, GUIController guiController){
        currentPlayer.getAccount().subtractBalance(unexpectedTax);
    }


    public void landOnField(GameBoard gameBoard, ChanceCardController chanceCardController, PlayerController playerController, GUIController guiController) {
        if(playerController.getCurrentPlayer().getPlayerPosition() == incomeTaxField){
            payIncomeTax(playerController.getCurrentPlayer(), guiController);
        }
        else if(playerController.getCurrentPlayer().getPlayerPosition() == unexpectedTaxField){
            payUnexpectedTax(playerController.getCurrentPlayer(), guiController);
        }
    }
}
