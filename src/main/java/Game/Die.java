package Game;
import java.util.Random;

/**
 * @author Lucas
 * Blueprint for the creation of Die objects with one method, roll(), and setters/getters.
 * Most logic re-used from CDIO_del3 except for changes to class, variable and object declaration names.
 */

public class Die {
    Random randomNumber = new Random();
    private int faceValue;
    public Die(){}

    public void roll(){
        this.faceValue = randomNumber.nextInt(6)+1;
    }

    public int getFaceValue(){
        return this.faceValue;
    }

    public void setFaceValue(int value){
        this.faceValue = value;
    }
}
