package Controller;

import Game.Language;
import Game.Player;
import gui_fields.GUI_Player;

/**
 * @author “Daniel Sutton”
 *
 */

public class PlayerController {

    private Player[] players;
    private Player currentPlayer;
    private int currentPlayerCounter = 0;

    public void nextPlayer(){
        currentPlayerCounter = (currentPlayerCounter + 1) % players.length;
    }

    /**
     * @author Louis
     * @param language
     * @param guiController
     */
    public void createPlayer(Language language, GUIController guiController){
        int numberOfPlayers = guiController.integerInput(language.getText(0,0), 2, 6);
        players = new Player[numberOfPlayers];
        for(int i = 0;i<numberOfPlayers;i++) {
            String playerName = guiController.stringInput(language.getText(0,0));
            players[i]= new Player(playerName);
            guiController.addPlayer(players[i].getGUIPlayer());
        }

    }


    public Player getCurrentPlayer() {
        return players[currentPlayerCounter];
    }


    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player[] getPlayerArray() {
        return players;
    }

    public void setPlayerArray(Player[] players) {
        this.players = players;
    }


}
