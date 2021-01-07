package Controller;
import Game.Die;


/**
 * @author Lucas
 * Class for DieController that controls the logic for handling Die objects created based on the Die class.
 */

public class DieController{
    private Die die1 = new Die();
    private Die die2 = new Die();

    public void diceRoll(){
        die1.roll();
        die2.roll();
    }



}
