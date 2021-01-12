package Controller;
import Game.*;

public class Gameloop
{
    private DieController dieController = new DieController();
    private Language language = new Language();
    private PlayerController playerController = new PlayerController();
    private GUIController guiController = new GUIController();
    private ChanceCardController chanceCardController = new ChanceCardController();
    private Rules rules = new Rules();
    private Menu menu = new Menu();
    private Jail jail = new Jail();
    private boolean isGameRunning;

    public Gameloop()
    {
        isGameRunning = true;
    }


    public void matadorGameloop()
    {
        language.loadFile();
        GameBoard gameboard = new GameBoard(language);
        guiController.createGUIBoard(gameboard.getGuiGamebord());
        playerController.createPlayer(language, guiController);
        chanceCardController.shuffleChanceCardDeck();
        playerController.setCurrentPlayer(guiController.integerInput(language.getText(5,2) + playerController.getListOfPlayersAsString(),1,playerController.getPlayerArray().length)-1);

        while(isGameRunning)
        {
            rules.setExtraTurn(false);
            Player currentPlayer = playerController.getCurrentPlayer();
            if(playerController.getCurrentPlayer().getTurnsInJail() == 3)
            {
                rules.threeTurnsInJail(language, guiController, playerController);
            }
            if(currentPlayer.isInJail())
            {
                jail.inJail(language, guiController, dieController, chanceCardController, gameboard, playerController);
            }
            if(currentPlayer.isInJail() && !currentPlayer.getHasRolledToGetOutOfJail())
                {
                    menu.takeTurnMenu(language, gameboard, guiController, currentPlayer);
                    dieController.diceRoll(guiController);
                    currentPlayer.setNumberOfMoves(dieController.diceValue());
                    if(dieController.isDouble())
                    {
                        playerController.getCurrentPlayer().setDoubleCounter(playerController.getCurrentPlayer().getDoubleCounter()+1);
                    }
                    rules.doubleExtraTurn(dieController, playerController);
                    if(currentPlayer.getDoubleCounter()==3)
                    {
                        rules.setExtraTurn(false);
                        rules.threeDoubleGoToJail(playerController);
                    }

                    gameboard.getGameBoard()[currentPlayer.getPlayerPosition()].getGUIField().setCar(currentPlayer.getGUIPlayer(),false);
                    currentPlayer.setPlayerPosition(currentPlayer.getPlayerPosition()+dieController.diceValue());
                    rules.overStartRule(language, guiController, playerController);
                    gameboard.getGameBoard()[currentPlayer.getPlayerPosition()].getGUIField().setCar(currentPlayer.getGUIPlayer(), true);

                }
            while(true)
            {
                gameboard.getGameBoard()[currentPlayer.getPlayerPosition()].landOnField(gameboard, chanceCardController, playerController, guiController, language);
                rules.overStartRule(language, guiController, playerController);
                if(!currentPlayer.getHasMoved())
                {
                    break;
                }
                else
                {
                    currentPlayer.setHasMoved(false);
                }
            }
            rules.bankrupt(guiController, playerController);
            isGameRunning = rules.win(language, guiController, playerController);
            currentPlayer.setHasRolledToGetOutOfJail(false);
            if(!rules.getExtraTurn())
            {
                currentPlayer.setDoubleCounter(0);
                playerController.nextPlayer();
            }
        }
    }


}
