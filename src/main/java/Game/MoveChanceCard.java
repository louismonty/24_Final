package Game;

import Controller.GUIController;

public class MoveChanceCard extends ChanceCard
{
    private int chanceCardID;

    public MoveChanceCard(int chanceCardID)
    {
        super(chanceCardID);
    }

    public void startCard(Language language, Player player, GameBoard gameBoard, GUIController guiController)
    {

        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(),false);
        player.setPlayerPosition(0);
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(), true);
        player.setHasMoved(true);
        guiController.showChanceCard(language.getText(0,0));

    }
    public void threeFieldsForwardCard(Language language, Player player, GameBoard gameBoard, GUIController guiController){
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(),false);
        player.setPlayerPosition(player.getPlayerPosition()+3);
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(), true);
        player.setHasMoved(true);
        guiController.showChanceCard(language.getText(0,0));
    }

    public void threeFieldsBackwardsCard(Language language, Player player, GameBoard gameBoard, GUIController guiController){
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(),false);
        player.setPlayerPosition(player.getPlayerPosition()-3);
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(), true);
        player.setHasMoved(true);
        player.setHasMovedBackwards(true);
        guiController.showChanceCard(language.getText(0,0));
    }

    public void frederiksbergAlleCard(Language language, Player player, GameBoard gameBoard, GUIController guiController){
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(),false);
        player.setPlayerPosition(11);
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(), true);
        player.setHasMoved(true);
        guiController.showChanceCard(language.getText(0,0));
    }


    public void shipyardCard(Language language, Player player, GameBoard gameBoard, GUIController guiController){
        int ferryField = player.getPlayerPosition();
        for(int i = player.getPlayerPosition();gameBoard.getGameBoard()[i] instanceof  FerryField;i = i +1 %40){
            ferryField = i;
        }
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(),false);
        player.setPlayerPosition(ferryField);
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(), true);
        player.setHasMoved(true);
        guiController.showChanceCard(language.getText(0,0));
        FerryField field = (FerryField)gameBoard.getGameBoard()[ferryField];
        player.subtractBalance((field.rentFerryMultiplier(gameBoard))*500);
    }

    public void molslinjenCard(Language language, Player player, GameBoard gameBoard, GUIController guiController){
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(),false);
        player.setPlayerPosition(16);
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(), true);
        player.setHasMoved(true);
        guiController.showChanceCard(language.getText(0,0));
    }
    public void groenningenCard(Language language, Player player, GameBoard gameBoard, GUIController guiController){
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(),false);
        player.setPlayerPosition(24);
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(), true);
        player.setHasMoved(true);
        guiController.showChanceCard(language.getText(0,0));
    }
    public void vimmelskaftetCard(Language language, Player player, GameBoard gameBoard, GUIController guiController){
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(),false);
        player.setPlayerPosition(32);
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(), true);
        player.setHasMoved(true);
        guiController.showChanceCard(language.getText(0,0));
    }
    public void ferryCard(Language language, Player player, GameBoard gameBoard, GUIController guiController){
        int ferryField = player.getPlayerPosition();
        for(int i = player.getPlayerPosition();gameBoard.getGameBoard()[i] instanceof  FerryField;i = i +1 %40){
            ferryField = i;
        }
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(),false);
        player.setPlayerPosition(ferryField);
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(), true);
        player.setHasMoved(true);
        guiController.showChanceCard(language.getText(0,0));
    }
    public void strandvejenCard(Language language, Player player, GameBoard gameBoard, GUIController guiController){
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(),false);
        player.setPlayerPosition(19);
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(), true);
        player.setHasMoved(true);
        guiController.showChanceCard(language.getText(0,0));
    }
    public void raadhuspladsenCard(Language language, Player player, GameBoard gameBoard, GUIController guiController){
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(),false);
        player.setPlayerPosition(39);
        gameBoard.getGameBoard()[player.getPlayerPosition()].guiField.setCar(player.getGUIPlayer(), true);
        player.setHasMoved(true);
        guiController.showChanceCard(language.getText(0,0));
    }


}