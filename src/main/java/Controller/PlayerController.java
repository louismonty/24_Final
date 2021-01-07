package Controller;
import Game.Language;
import Game.Player;

/**
 * @author “Daniel”
 *
 */

public class PlayerController {

    private static Player[] players;
    private static Player currentPlayer;
    int currentPlayerCounter = 0;

    public void nextPlayer(){
        currentPlayerCounter = (currentPlayerCounter +1) % players.length;
    }

    public void createPlayer(GUIController guiController, Language language){
        int numberOfPlayers = guiController.integerInput(language.getText(0, 0), 2, 6);
        for (int i = 0; i < numberOfPlayers ; i++) {
            String playerName = guiController.stringInput(language.getText(0,0));
            Player Player = new Player(playerName);
        }
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerCounter];
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
