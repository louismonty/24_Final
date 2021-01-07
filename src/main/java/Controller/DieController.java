package Controller;
import Game.Die;
import Game.Language;


/**
 * @author Lucas
 * Class for DieController that controls the logic for handling Die objects created based on the Die class.
 */

public class DieController {
    public DieController() {
    }

    private Die die1 = new Die();
    private Die die2 = new Die();

    public void diceRoll() {
        die1.roll();
        die2.roll();
    }

    public int diceValue() {
        return die1.getFaceValue() + die2.getFaceValue();

    }

    /**
     * @return boolean
     * isDouble() method returns true if the two dices roll the same faceValue.
     */
    public boolean isDouble() {
        return die1.getFaceValue() == die2.getFaceValue();
    }

    public String toString(Language language){
        return language.getText(0,0);
    }
}
