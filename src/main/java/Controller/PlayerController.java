package Controller;

import Game.Language;
import Game.Player;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

import java.awt.*;

/**
 * @author “Daniel Sutton”
 *
 */

public class PlayerController {

    private Player[] players;
    private Player currentPlayer;
    private int currentPlayerCounter = 0;

    public void nextPlayer(){
        if(players.length > 1)
        {
            currentPlayerCounter = (currentPlayerCounter + 1) % players.length;
        }
    }

    /**
     * @author Louis
     * @param language
     * @param guiController
     */
    Color[] colorOfCar = {new Color(0, 0, 0),
            new Color(0,0,0),
            new Color(0,0,0),
            new Color(0,0,0),
            new Color(0,0,0),
            new Color(0,0,0),
    };
    public void createPlayer(Language language, GUIController guiController){
        int numberOfPlayers = guiController.integerInput(language.getText(2,2), 2, 6);
        players = new Player[numberOfPlayers];
        for(int i = 0;i<numberOfPlayers;i++) {
            String playerName = guiController.stringInput(language.getText(2,3));
            players[i]= new Player(playerName,i+1);
            guiController.addPlayer(players[i].getGUIPlayer());
            players[i].getGUIPlayer().getCar().setPrimaryColor(colorOfCar[i]);
        }

    }

    /**
     * @author Louis
     */
    public Player getCurrentPlayer() {
        return players[currentPlayerCounter];
    }

    /**
     * @author Louis
     */
    public void setCurrentPlayer(int currentPlayer)
    {
        this.currentPlayerCounter = currentPlayer%players.length;
    }

    public Player[] getPlayerArray() {
        return players;
    }

    /**
     * @author Louis
     */
    public void setPlayerArray(Player[] players) {
        this.players = players;
    }


}
