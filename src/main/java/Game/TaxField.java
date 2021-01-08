package Game;

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
    private double taxRate = 0.1;

    public TaxField(int positionID, String name, GUI_Field guiField){
        super(positionID, name, guiField);
        this.incomeTax = incomeTax;
        this.unexpectedTax = unexpectedTax;
        this.taxRate = taxRate;
    }

    public void payIncomeTax(Player currentPlayer){

    }

    public void payUnexpectedTax(Player currentPlayer, GUIController guiController){
        currentPlayer.getAccount().subtractBalance(unexpectedTax);
    }

    public void landOnField(PlayerController playerController, GUIController guiController, Player currentPlayer){
        if(currentPlayer.getPlayerPosition() == 5){
            payIncomeTax();
        }
        else if(currentPlayer.getPlayerPosition() == 39){
            payUnexpectedTax();
        }
    }

}
