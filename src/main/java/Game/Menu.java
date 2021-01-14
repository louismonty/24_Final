package Game;

import Controller.GUIController;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Street;

import java.awt.*;

public class Menu {
    public void takeTurnMenu(Language language, GameBoard gameBoard, GUIController guiController, Player player) {
        while (true) {
            String[] Text = language.getLine(10);
            String playerChose = guiController.buttons(player.getName()+" "+Text[1],Text[2],Text[3],Text[4],Text[5],Text[6],"Demo");
            if (playerChose == Text[2]) {
                break;
            } else if ((playerChose == Text[3])) {
                buyHouseOrHotel(language,player,guiController,gameBoard);
            } else if (playerChose == Text[4]) {
                sellHouseOrHotel(language,player,guiController,gameBoard);
            } else if (playerChose == Text[5]) {
                pawn(language,player,guiController,gameBoard);
            } else if (playerChose == Text[6]) {
                unpawn(language,player,guiController,gameBoard);
            }
            else if (playerChose.equals("Demo")) {
                Demo(gameBoard,player,guiController);
            }
        }
    }


    public void Demo(GameBoard gameBoard,Player player,GUIController guiController){
        int i = guiController.integerInput("grund",0,39);
        BuyableField field =(BuyableField) gameBoard.getGameBoard()[i];
        field.owner = player.getPlayerID();

    }

    public void pawn(Language language, Player player, GUIController guiController, GameBoard gameBoard) {
        BuyableField[] pawnableFields = pawnableFields(ownedFields(gameBoard, player));
        String playerChose = guiController.buttons(language.getText(10, 9), exspandStrArr(getStringArrOfName(pawnableFields),language.getText(10,8)));
        for (int i = 0; i < pawnableFields.length; i++) {
            if (pawnableFields[i].getName().equals(playerChose) && pawnableFields[i].getIsPawned() != true) {
                pawnableFields[i].setIsPawned(true);
                GUI_Ownable guiField = (GUI_Ownable) pawnableFields[i].getGUIField();
                guiField.setBorder(player.getGUIPlayer().getPrimaryColor(), Color.gray);
                player.addBalance(pawnableFields[i].getPawnValue());
            }
        }
    }

    public void unpawn(Language language, Player player, GUIController guiController, GameBoard gameBoard) {
        BuyableField[] pawnedFields = pawnedFields(ownedFields(gameBoard, player));
        if (pawnedFields != null) {
            String playerChose = guiController.buttons(language.getText(10, 10), exspandStrArr(getStringArrOfName(pawnedFields),language.getText(10,8)));
            for (int i = 0; i < pawnedFields.length; i++) {
                if (pawnedFields[i].getName().equals(playerChose) && pawnedFields[i].getIsPawned() != false) {
                    pawnedFields[i].setIsPawned(false);
                    GUI_Ownable guiField = (GUI_Ownable) pawnedFields[i].getGUIField();
                    guiField.setBorder(player.getGUIPlayer().getPrimaryColor());
                    player.subtractBalance(pawnedFields[i].getPawnValue());
                } else {
                    guiController.showMessage(language.getText(1, 1));
                }
            }
        }
    }

    public void sellHouseOrHotel(Language language, Player player, GUIController guiController, GameBoard gameBoard){
        BuyableField[][] buyableFieldsarr = ableToBuy(buyableFields(gameBoard),player);
        BuyableField[] listOfOwnedFields = buyableFieldsarr[10];
        String playerChose = guiController.buttons(language.getText(10, 11), exspandStrArr(getStringArrOfName(listOfOwnedFields),language.getText(10,8)));
        for (int i = 0; i < listOfOwnedFields.length; i++) {
            if (listOfOwnedFields[i].getName().equals(playerChose) && listOfOwnedFields[i].getIsPawned() == false){
                Boolean evenBuild = true;
                PropertyField currentField =(PropertyField) listOfOwnedFields[i];
                GUI_Street curremtGUIField = (GUI_Street) currentField.getGUIField();
                for(int j = 0;j<buyableFieldsarr[currentField.getGroup()-1].length;j++) {
                    PropertyField groupField = (PropertyField) buyableFieldsarr[currentField.getGroup()-1][j];
                    if (currentField.getHouses() < groupField.getHouses()) {
                        evenBuild = false;
                    }
                }
                if(evenBuild){
                    if(currentField.getHouses() == 0) {
                        guiController.showMessage(language.getText(10,13));
                    }else if (currentField.getHouses() < 5) {
                        currentField.setHouses(currentField.getHouses() - 1);
                        curremtGUIField.setHouses(currentField.getHouses());
                        player.addBalance(currentField.getHousePrice());
                    } else if (currentField.getHouses() == 5) {
                        curremtGUIField.setHotel(false);
                        currentField.setHouses(currentField.getHouses() - 1);
                        curremtGUIField.setHouses(currentField.getHouses());
                        player.addBalance(currentField.getHousePrice());
                    }

                }else{
                    guiController.showMessage(language.getText(10,14));
                }
            }
        }

    }

    public void buyHouseOrHotel(Language language, Player player, GUIController guiController, GameBoard gameBoard){
        BuyableField[][] buyableFieldsarr = ableToBuy(buyableFields(gameBoard),player);
        BuyableField[] listOfOwnedFields = buyableFieldsarr[10];
        String playerChose = guiController.buttons(language.getText(10, 12), exspandStrArr(getStringArrOfName(listOfOwnedFields),language.getText(10,8)));
        for (int i = 0; i < listOfOwnedFields.length; i++) {
            if (listOfOwnedFields[i].getName().equals(playerChose) && listOfOwnedFields[i].getIsPawned() == false){
                Boolean evenBuild = true;
                 PropertyField currentField =(PropertyField) listOfOwnedFields[i];
                GUI_Street curremtGUIField = (GUI_Street) currentField.getGUIField();
                for(int j = 0;j<buyableFieldsarr[currentField.getGroup()-1].length;j++) {
                    PropertyField groupField = (PropertyField) buyableFieldsarr[currentField.getGroup()-1][j];
                    if (currentField.getHouses() > groupField.getHouses()) {
                        evenBuild = false;
                    }
                }
                if(evenBuild){
                    if (currentField.getHouses() < 4) {
                        currentField.setHouses(currentField.getHouses() + 1);
                        curremtGUIField.setHouses(currentField.getHouses());
                        player.subtractBalance(currentField.getHousePrice());
                    } else if (currentField.getHouses() == 4) {
                        currentField.setHouses(currentField.getHouses() + 1);
                        curremtGUIField.setHotel(true);
                        player.subtractBalance(currentField.getHousePrice());
                    } else {
                        guiController.showMessage(language.getText(10,15));
                    }
                }else{
                    guiController.showMessage(language.getText(10,14));
                }
            }
        }

    }

    public BuyableField[] pawnableFields(BuyableField ownedFields[]){
        BuyableField[]pawnableFields = new BuyableField[0];
        for(int i = 0; i<ownedFields.length;i++){
            if(!ownedFields[i].isPawned){
                pawnableFields = exspandArr(pawnableFields,ownedFields[i]);
            }
        }
        return pawnableFields;
    }
    public BuyableField[] pawnedFields(BuyableField ownedFields[]){
        BuyableField[]pawnedFields = new BuyableField[0];
        for(int i = 0; i<ownedFields.length;i++){
            if(ownedFields[i].isPawned){
                pawnedFields = exspandArr(pawnedFields,ownedFields[i]);
            }
        }
        return pawnedFields;

    }

    public BuyableField[][] ableToBuy(BuyableField[] fields,Player player){
        BuyableField[][] buyableField = new BuyableField[11][0];
        BuyableField[] listOfFieldWithallGroups = new BuyableField[0];
        for(int i = 0;i<fields.length;i++){
            buyableField[fields[i].getGroup()-1] = exspandArr(buyableField[fields[i].getGroup()-1],fields[i]);
        }
        for(int i = 0;i<buyableField.length-1;i++){
            boolean haAllFields = true;
            for(int j = 0;j<buyableField[i].length;j++){
                if(haAllFields) {
                    if (buyableField[i][j].getOwner() != player.getPlayerID()-1){
                        haAllFields = false;
                    }
                }
            }
            if(haAllFields && i != 0 && i!=1){
                BuyableField[] tempArr = buyableField[10];
                for(int j =0;j<buyableField[i].length;j++){
                    tempArr = exspandArr(tempArr,buyableField[i][j]);
                }
                buyableField[10] = tempArr;
            }
        }
        return buyableField;
    }
        public BuyableField[] buyableFields(GameBoard gameBoard){
        Field[] gameBoardFields = gameBoard.getGameBoard();
        BuyableField[] buyableFields = new BuyableField[0];
        for(int i =0; i<gameBoardFields.length;i++){
            if(gameBoardFields[i] instanceof BuyableField){
                buyableFields = exspandArr(buyableFields,(BuyableField) gameBoardFields[i]);
            }
        }
        return buyableFields;
        }

        public BuyableField[] ownedFields(GameBoard gameBoard, Player player){
            BuyableField[] arr = new BuyableField[0];
            for (int i = 0; i < gameBoard.getGameBoard().length; i++) {
                if (gameBoard.getGameBoard()[i] instanceof BuyableField) {
                    BuyableField field = (BuyableField) gameBoard.getGameBoard()[i];
                    if (field.getOwner() == player.getPlayerID()-1) {
                        arr = exspandArr(arr,field);
                    }
                }
            }
            return arr;
        }

        public BuyableField[] exspandArr(BuyableField[] fields, BuyableField field){
        BuyableField[] tempArr = new BuyableField[fields.length+1];
        for(int i = 0;i<fields.length;i++){
            tempArr[i] = fields[i];
        }
        tempArr[fields.length] = field;
        return  tempArr;
        }
    public String[] exspandStrArr(String[] fields, String field){
        String[] tempArr = new String[fields.length+1];
        for(int i = 0;i<fields.length;i++){
            tempArr[i] = fields[i];
        }
        tempArr[fields.length] = field;
        return  tempArr;
    }

        public String[] getStringArrOfName (Field[]fields){
            String[] names = new String[fields.length];
            for (int i = 0; i < fields.length; i++) {
                names[i] = fields[i].getName();
            }
            return names;
        }


    }



