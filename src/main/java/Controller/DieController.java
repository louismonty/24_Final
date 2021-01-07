package Controller;
import Game.Die;


/**
 * @author Lucas
 * Class for DieController that controls the logic for handling Die objects created based on the Die class.
 */

public class DieController {
    public DieController() {
    }

    public static Die die1 = new Die();
    public static Die die2 = new Die();

    public void diceRoll() {
        die1.roll();
        die2.roll();
    }

    public int diceValue() {
        return die1.getFaceValue() + die2.getFaceValue();

    }

    public static boolean isDouble() {
        return die1.getFaceValue() == die2.getFaceValue();
    }


}
