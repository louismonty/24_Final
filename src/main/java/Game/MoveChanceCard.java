package Game;

import Controller.GUIController;
import Controller.PlayerController;

/**
 * @Author Louis & Isak
 */
public class MoveChanceCard extends ChanceCard
{
    private int chanceCardID;

    public MoveChanceCard(int chanceCardID)
    {
        super(chanceCardID);
    }

    public void moveToSpecificField(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController, int newPosition, int textColumn)
    {
        gameboard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition()].guiField.setCar(playerController.getCurrentPlayer().getGUIPlayer(),false);
        playerController.getCurrentPlayer().setPlayerPosition(newPosition);
        gameboard.getGameBoard()[playerController.getCurrentPlayer().getPlayerPosition()].guiField.setCar(playerController.getCurrentPlayer().getGUIPlayer(), true);
        playerController.getCurrentPlayer().setHasMoved(true);
        guiController.showChanceCard(language.getText(26,textColumn));
    }

    public int findNextFerryField(GameBoard gameboard, PlayerController playerController)
    {
        int ferryField = playerController.getCurrentPlayer().getPlayerPosition();
        for(int i = playerController.getCurrentPlayer().getPlayerPosition();gameboard.getGameBoard()[i] instanceof  FerryField;i = (i +1) % 40)
        {
            ferryField = i;
        }
        return ferryField;
    }

    public void startCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        moveToSpecificField(language, guiController, gameboard, playerController, 0, 2);
    }

    public void threeFieldsForwardCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        moveToSpecificField(language, guiController, gameboard, playerController, playerController.getCurrentPlayer().getPlayerPosition()+3, 3);
    }

    public void threeFieldsBackwardsCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        moveToSpecificField(language, guiController, gameboard, playerController, playerController.getCurrentPlayer().getPlayerPosition()-3, 4);
        playerController.getCurrentPlayer().setHasMovedBackwards(true);
    }

    public void frederiksbergAlleCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        moveToSpecificField(language, guiController, gameboard, playerController, 11, 5);
    }

    public void shipyardCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        int ferryField = findNextFerryField(gameboard, playerController);
        moveToSpecificField(language, guiController, gameboard, playerController, ferryField, 6);

        FerryField field = (FerryField)gameboard.getGameBoard()[ferryField];
        if(((FerryField) gameboard.getGameBoard()[ferryField]).owner >= 0)
            playerController.getPlayerArray()[((FerryField) gameboard.getGameBoard()[ferryField]).owner].addBalance((field.rentFerryMultiplier(gameboard))*500);
            playerController.getCurrentPlayer().subtractBalance((field.rentFerryMultiplier(gameboard))*500);
    }

    public void molslinjenCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        moveToSpecificField(language, guiController, gameboard, playerController, 16, 7);
    }
    public void groenningenCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        moveToSpecificField(language, guiController, gameboard, playerController, 24, 8);
    }
    public void vimmelskaftetCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        moveToSpecificField(language, guiController, gameboard, playerController, 32, 9);
    }
    public void ferryCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        moveToSpecificField(language, guiController, gameboard, playerController, findNextFerryField(gameboard, playerController), 10);
    }
    public void strandvejenCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        moveToSpecificField(language, guiController, gameboard, playerController, 19, 11);
    }
    public void raadhuspladsenCard(Language language, GUIController guiController, GameBoard gameboard, PlayerController playerController)
    {
        moveToSpecificField(language, guiController, gameboard, playerController, 39, 12);
    }
}