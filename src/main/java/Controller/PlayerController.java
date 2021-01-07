package Controller;

import Game.Language;
import Game.Player;
import gui_fields.GUI_Player;

/**
 * @author “Daniel”
 *
 */

public class PlayerController {

    private static Player[] players;
    private static Player currentPlayer;
    private int currentPlayerCounter = 0;

    public void nextPlayer(){
        currentPlayerCounter = (currentPlayerCounter + 1) % players.length;
    }

    public void createPlayer(Language language, GUIController guiController){
        int numberOfPlayers = guiController.integerInput("Antal spiller?", 2, 6);
        String playerName = guiController.stringInput("Hvad hedder du?");
        Player player = new Player(playerName);

    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        PlayerController.currentPlayer = currentPlayer;
    }

    public Player[] getPlayerArray() {
        return players;
    }

    public void setPlayerArray(Player[] players) {
        PlayerController.players = players;
    }


}
