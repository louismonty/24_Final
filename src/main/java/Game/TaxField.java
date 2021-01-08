package Game;

import java.awt.color.*;
import Controller.*;
import gui_fields.GUI_Field;

/**
 * @author Lucas
 * TaxField class that extends Field. Includes two methods: payIncomeTax() and payUnexpectedTax().
 */

public class TaxField extends Field {
    private int incomeTax = 4000;
    private int unexpectedTax = 2000;

    public TaxField(int positionID, String name, GUI_Field guiField){
        super(positionID, name, guiField);
        this.incomeTax = incomeTax;
        this.unexpectedTax = unexpectedTax;
    }

    public void payIncomeTax(Player currentPlayer){

    }

    public void payUnexpectedTax(Player currentPlayer, GUIController guiController){
        currentPlayer.getAccount().subtractBalance(unexpectedTax);
    }

}
