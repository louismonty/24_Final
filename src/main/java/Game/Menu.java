package Game;

import Controller.GUIController;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Street;

import java.awt.*;

public class Menu {
    public void takeTurnMenu(Language language, GameBoard gameBoard, GUIController guiController, Player player) {
        while (true) {
            String[] Text = language.getLine(10);
            String playerChose = guiController.buttons(player.getName()+" "+Text[1],Text[2],Text[3],Text[4],Text[5],Text[6]);
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
        }
    }


    public BuyableField[] pawnebelFields(BuyableField ownedFields[]){
        BuyableField[]pawnebelFields = new BuyableField[0];
        for(int i = 0; i<ownedFields.length;i++){
            if(!ownedFields[i].isPawned){
                pawnebelFields = exspandArr(pawnebelFields,ownedFields[i]);
            }
        }
        return pawnebelFields;
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


    public void pawn(Language language, Player player, GUIController guiController, GameBoard gameBoard) {
        BuyableField[] pawnebelFields = pawnebelFields(ownedFields(gameBoard, player));
        String playerChose = guiController.buttons(language.getText(1, 1), getStringArrOfName(pawnebelFields));
        for (int i = 0; i < pawnebelFields.length; i++) {
            if (pawnebelFields[i].getName().equals(playerChose) && pawnebelFields[i].getIsPawned() != true) {
                pawnebelFields[i].setIsPawned(true);
                GUI_Ownable guiField = (GUI_Ownable) pawnebelFields[i].getGUIField();
                guiField.setBorder(player.getGUIPlayer().getPrimaryColor(), Color.gray);
                player.addBalance(pawnebelFields[i].getPawnValue());
            }
        }
    }

    public void unpawn(Language language, Player player, GUIController guiController, GameBoard gameBoard) {
        BuyableField[] pawnedFields = pawnedFields(ownedFields(gameBoard, player));
        if (pawnedFields != null) {
            String playerChose = guiController.buttons(language.getText(1, 1), getStringArrOfName(pawnedFields));
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
        String playerChose = guiController.buttons(language.getText(1, 1), getStringArrOfName(listOfOwnedFields));
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
                        guiController.showMessage("du har solgt alle huse");
                    }else if (currentField.getHouses() < 5) {
                        currentField.setHouses(currentField.getHouses() - 1);
                        curremtGUIField.setHouses(currentField.getHouses());
                        player.subtractBalance(currentField.getHousePrice());
                    } else if (currentField.getHouses() == 5) {
                        currentField.setHouses(currentField.getHouses() - 1);
                        curremtGUIField.setHotel(false);
                        player.addBalance(currentField.getHousePrice());
                    }

                }else{
                    guiController.showMessage("du skal sælge jævnt");
                }
            }
        }

    }

    public void buyHouseOrHotel(Language language, Player player, GUIController guiController, GameBoard gameBoard){
        BuyableField[][] buyableFieldsarr = ableToBuy(buyableFields(gameBoard),player);
        BuyableField[] listOfOwnedFields = buyableFieldsarr[10];
        String playerChose = guiController.buttons(language.getText(1, 1), getStringArrOfName(listOfOwnedFields));
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
                        guiController.showMessage("du har købt de maksimale");
                    }
                }else{
                    guiController.showMessage("du skal bygge jævnt");
                }
            }
        }

    }

    public BuyableField[] ableToBuy(BuyableField[] fields,Player player){
        BuyableField[][] buyableField = new BuyableField[10][];
        BuyableField[] listOfFieldWithallGroups = new BuyableField[0];
        for(int i = 0;i<fields.length;i++){
            buyableField[fields[i].getGroup()] = exspandArr(buyableField[fields[i].getGroup()],fields[i]);
        }
        for(int i = 0;i<buyableField.length;i++){
            boolean haAllFields = true;
            for(int j = 0;j<buyableField[i].length;j++){
                if(haAllFields) {
                    if (buyableField[i][j].getOwner() != player.getPlayerID()){
                        haAllFields = false;
                    }
                }
            }
            if(haAllFields){
                for(int j =0;j<buyableField[i].length;j++){
                    listOfFieldWithallGroups = exspandArr(listOfFieldWithallGroups,buyableField[i][j]);
                }
            }
        }
        return listOfFieldWithallGroups;
    }

        public BuyableField[] pawned (GameBoard gameBoard, Player player, BuyableField[]field){
            int count = 0;
            for (int i = 0; i < field.length; i++) {
                if (field[i].getIsPawned()) {
                    count++;
                }
            }
            int j = 0;
            BuyableField[] arr = new BuyableField[count];
            for (int i = 0; i < arr.length; i++) {
                if (field[i].getIsPawned()) {
                    arr[j] = field[i];
                    j++;
                }

            }
            return arr;
        }
        public BuyableField[] ownedFields(GameBoard gameBoard, Player player){
            BuyableField[] arr = new BuyableField[0];
            for (int i = 0; i < gameBoard.getGameBoard().length; i++) {
                if (gameBoard.getGameBoard()[i] instanceof BuyableField) {
                    BuyableField field = (BuyableField) gameBoard.getGameBoard()[i];
                    if (field.getOwner() == player.getPlayerID()) {
                        BuyableField[] tempArr = new BuyableField[arr.length + 1];
                        for (int j = 0; j < arr.length; j++) {
                            tempArr[j] = arr[j];
                        }
                        tempArr[arr.length] = field;
                        arr = tempArr;
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

        public String[] getStringArrOfName (Field[]fields){
            String[] names = new String[fields.length];
            for (int i = 0; i < fields.length; i++) {
                names[i] = fields[i].getName();
            }
            return names;
        }


    }



