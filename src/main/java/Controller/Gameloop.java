package Controller;
import Game.*;

public class Gameloop
{
    private DieController dieController = new DieController();
    private Language language;
    private PlayerController playerController = new PlayerController();
    private GUIController guiController = new GUIController();
    private GameBoard gameboard = new GameBoard(language);
    private ChanceCardController chanceCardController = new ChanceCardController();
    private Rules rules = new Rules();
    private Menu menu = new Menu();
    private Jail jail = new Jail();

    private static boolean isGameRunning = true;

    public void matadorGameloop()
    {
        playerController.createPlayer(language, guiController);

        while(isGameRunning)
        {
            Player currentPlayer = playerController.getCurrentPlayer();
            if(currentPlayer.isInJail(true))
            {
                jail.inJail(dieController, currentPlayer, guiController, chanceCardController, language);
            }
            else
                {
                    menu.takeTurnMenu(language, gameboard, guiController, currentPlayer);
                    dieController.diceRoll(guiController);
                }
            while(true)
            {
                gameboard.getGameBoard()[currentPlayer.getPlayerPosition() % 40].landOnField(gameboard, chanceCardController, playerController, guiController, language);
                rules.overStartRule(currentPlayer, guiController, language);
                if(currentPlayer.getHasMoved())
                {
                    break;
                }
                else
                {
                    currentPlayer.setHasMoved(false);
                }
            }
            rules.bankrupt(currentPlayer, playerController, guiController);
            isGameRunning = rules.win(playerController);
            playerController.nextPlayer();
        }
    }


}
