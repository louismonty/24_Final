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
        playerController.setCurrentPlayer(playerController.getPlayerArray()[guiController.integerInput(language.getText(1,1),1,playerController.getPlayerArray().length)-1]);

        while(isGameRunning)
        {
            rules.setExtraTurn(false);
            Player currentPlayer = playerController.getCurrentPlayer();
            if(currentPlayer.isInJail(true))
            {
                jail.inJail(language, guiController, dieController, chanceCardController, playerController);
            }
            else
                {
                    menu.takeTurnMenu(language, gameboard, guiController, currentPlayer);
                    dieController.diceRoll(guiController);

                    rules.doubleExtraTurn(dieController, playerController);
                    if(currentPlayer.getDoubleCounter()==3)
                    {
                        rules.setExtraTurn(false);
                        rules.threeDoubleGoToJail(playerController);
                    }
                    rules.overStartRule(language, guiController, playerController);
                    gameboard.getGameBoard()[currentPlayer.getPlayerPosition()].getGUIField().setCar(currentPlayer.getGUIPlayer(),false);
                    currentPlayer.setPlayerPosition(currentPlayer.getPlayerPosition()+dieController.diceValue());
                    gameboard.getGameBoard()[currentPlayer.getPlayerPosition()%40].getGUIField().setCar(currentPlayer.getGUIPlayer(), true);

                }
            while(true)
            {
                gameboard.getGameBoard()[currentPlayer.getPlayerPosition() % 40].landOnField(gameboard, chanceCardController, playerController, guiController, language);
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
            isGameRunning = rules.win(playerController);
            if(!rules.getExtraTurn())
            {
                currentPlayer.setDoubleCounter(0);
                playerController.nextPlayer();
            }
        }
    }


}
