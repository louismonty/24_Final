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
    Color[] colorOfCar = {new Color(255, 0, 227, 255),
            new Color(0, 255, 210),
            new Color(43, 255, 0),
            new Color(255, 183, 0),
            new Color(15, 0, 255),
            new Color(0, 0, 0, 255),
    };

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


    public Player getCurrentPlayer() {
        return players[currentPlayerCounter];
    }

    public void setCurrentPlayer(int currentPlayer)
    {
        this.currentPlayerCounter = currentPlayer%players.length;
    }

    public Player[] getPlayerArray() {
        return players;
    }


    public void setPlayerArray(Player[] players) {
        this.players = players;
    }

    /**
     * @author Isak
     */
    public String getListOfPlayersAsString()
    {
        String list = "\n";
        for(int i = 0; i < getPlayerArray().length; i++)
        {
            String s = String.valueOf(i+1);
            list += s + ": " + getPlayerArray()[i].getName() + "\n";
        }
        return list;
    }


}
