package Controller;

import Game.Player;

/**
 * @author “Daniel”
 *
 */

public class PlayerController {

    private static Player[] players;
    private static Player currentPlayer;

    public static void nextPlayer(){
    }

    public static void createPlayer(){

    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        PlayerController.currentPlayer = currentPlayer;
    }

    public static Player[] getPlayerArray() {
        return players;
    }

    public static void setPlayerArray(Player[] players) {
        PlayerController.players = players;
    }


}
