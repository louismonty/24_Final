package Controller;

import Game.Player;
import gui_fields.GUI_Player;

/**
 * @author “Daniel”
 *
 */

public class PlayerController {

    private Player[] players;
    private Player currentPlayer;

    public void nextPlayer(){
    }

    public void createPlayer(){
        int numberOfPlayers;
        for (int i = 6; i < numberOfPlayers ; i++) {
            String playerName;
            Player addPlayer = new Player(playerName);

        }
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
