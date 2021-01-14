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
        }
    }



    public void pawn(Language language, Player player, GUIController guiController, GameBoard gameBoard) {
        BuyableField[] pawnableFields = pawnableFields(ownedFields(gameBoard, player));
        String buttonClicked = guiController.buttons(language.getText(10, 9), expandStrArr(getStringArrOfName(pawnableFields),language.getText(10,8)));
        for (int i = 0; i < pawnableFields.length; i++) {
            if (pawnableFields[i].getName().equals(buttonClicked) && pawnableFields[i].getIsPawned() != true) {
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
            String buttonClicked = guiController.buttons(language.getText(10, 10), expandStrArr(getStringArrOfName(pawnedFields),language.getText(10,8)));
            for (int i = 0; i < pawnedFields.length; i++) {
                if (pawnedFields[i].getName().equals(buttonClicked) && pawnedFields[i].getIsPawned() != false) {
                    pawnedFields[i].setIsPawned(false);
                    GUI_Ownable guiField = (GUI_Ownable) pawnedFields[i].getGUIField();
                    guiField.setBorder(player.getGUIPlayer().getPrimaryColor());
                    player.subtractBalance(((int)((pawnedFields[i].getPawnValue()/10)+((pawnedFields[i].getPawnValue()/10)*0.1))*10));
                } else {
                    guiController.showMessage(language.getText(1, 1));
                }
            }
        }
    }

    public void sellHouseOrHotel(Language language, Player player, GUIController guiController, GameBoard gameBoard){
        BuyableField[][] buyableFieldsarr = ableToBuy(buyableFields(gameBoard),player);
        BuyableField[] listOfOwnedFields = buyableFieldsarr[10];
        String buttonClicked = guiController.buttons(language.getText(10, 11), expandStrArr(getStringArrOfName(listOfOwnedFields),language.getText(10,8)));
        for (int i = 0; i < listOfOwnedFields.length; i++) {
            if (listOfOwnedFields[i].getName().equals(buttonClicked) && listOfOwnedFields[i].getIsPawned() == false){
                Boolean evenBuild = true;
                PropertyField currentField =(PropertyField) listOfOwnedFields[i];
                GUI_Street currentGUIField = (GUI_Street) currentField.getGUIField();
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
                        currentGUIField.setHouses(currentField.getHouses());
                        player.addBalance(currentField.getHousePrice());
                    } else if (currentField.getHouses() == 5) {
                        currentGUIField.setHotel(false);
                        currentField.setHouses(currentField.getHouses() - 1);
                        currentGUIField.setHouses(currentField.getHouses());
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
        String buttonClicked = guiController.buttons(language.getText(10, 12), expandStrArr(getStringArrOfName(listOfOwnedFields),language.getText(10,8)));
        for (int i = 0; i < listOfOwnedFields.length; i++) {
            if (listOfOwnedFields[i].getName().equals(buttonClicked) && listOfOwnedFields[i].getIsPawned() == false){
                Boolean evenBuild = true;
                 PropertyField currentField =(PropertyField) listOfOwnedFields[i];
                GUI_Street currentGUIField = (GUI_Street) currentField.getGUIField();
                for(int j = 0;j<buyableFieldsarr[currentField.getGroup()-1].length;j++) {
                    PropertyField groupField = (PropertyField) buyableFieldsarr[currentField.getGroup()-1][j];
                    if (currentField.getHouses() > groupField.getHouses()) {
                        evenBuild = false;
                    }
                }
                if(evenBuild){
                    if (currentField.getHouses() < 4) {
                        currentField.setHouses(currentField.getHouses() + 1);
                        currentGUIField.setHouses(currentField.getHouses());
                        player.subtractBalance(currentField.getHousePrice());
                    } else if (currentField.getHouses() == 4) {
                        currentField.setHouses(currentField.getHouses() + 1);
                        currentGUIField.setHotel(true);
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

    /**
     * finds the fields that can be pawned
     * @param ownedFields
     * @return
     */
    public BuyableField[] pawnableFields(BuyableField ownedFields[]){
        BuyableField[]pawnableFields = new BuyableField[0];
        for(int i = 0; i<ownedFields.length;i++){
            if(!ownedFields[i].isPawned){
                pawnableFields = expandArr(pawnableFields,ownedFields[i]);
            }
        }
        return pawnableFields;
    }

    /**
     * finds the fields that is pawned
     * @param ownedFields
     * @return
     */
    public BuyableField[] pawnedFields(BuyableField ownedFields[]){
        BuyableField[]pawnedFields = new BuyableField[0];
        for(int i = 0; i<ownedFields.length;i++){
            if(ownedFields[i].isPawned){
                pawnedFields = expandArr(pawnedFields,ownedFields[i]);
            }
        }
        return pawnedFields;

    }

    /**
     * finds the fields where houses can be bought
      * @param fields
     * @param player
     * @return an 2d array that has all the fields sorted into groups and on the 11 row there is the fields where houses can be bought
     */
    public BuyableField[][] ableToBuy(BuyableField[] fields,Player player){
        BuyableField[][] buyableField = new BuyableField[11][0];
        for(int i = 0;i<fields.length;i++){
            buyableField[fields[i].getGroup()-1] = expandArr(buyableField[fields[i].getGroup()-1],fields[i]);
        }
        for(int i = 0;i<buyableField.length-1;i++){
            boolean hasAllFields = true;
            for(int j = 0;j<buyableField[i].length;j++){
                if(hasAllFields) {
                    if (buyableField[i][j].getOwner() != player.getPlayerID()-1){
                        hasAllFields = false;
                    }
                }
            }
            if(hasAllFields && i != 0 && i!=1){
                BuyableField[] tempArr = buyableField[10];
                for(int j =0;j<buyableField[i].length;j++){
                    tempArr = expandArr(tempArr,buyableField[i][j]);
                }
                buyableField[10] = tempArr;
            }
        }
        return buyableField;
    }

    /**
     * finds the fields that can be bought
     * @param gameBoard
     * @return the the fields that can be bought in an BuyableField array
     */
        public BuyableField[] buyableFields(GameBoard gameBoard){
        Field[] gameBoardFields = gameBoard.getGameBoard();
        BuyableField[] buyableFields = new BuyableField[0];
        for(int i =0; i<gameBoardFields.length;i++){
            if(gameBoardFields[i] instanceof BuyableField){
                buyableFields = expandArr(buyableFields,(BuyableField) gameBoardFields[i]);
            }
        }
        return buyableFields;
        }


    /**
     * finds the fields that are owned by the player
     * @param gameBoard
     * @param player
     * @return an array of BuyableField that the player owned
     */
    public BuyableField[] ownedFields(GameBoard gameBoard, Player player){
            BuyableField[] ownedArr = new BuyableField[0];
            for (int i = 0; i < gameBoard.getGameBoard().length; i++) {
                if (gameBoard.getGameBoard()[i] instanceof BuyableField) {
                    BuyableField field = (BuyableField) gameBoard.getGameBoard()[i];
                    if (field.getOwner() == player.getPlayerID()-1) {
                        ownedArr = expandArr(ownedArr,field);
                    }
                }
            }
            return ownedArr;
        }


    /**
     * expands an array of fields
     * @param fields the fields array the need to be expanded
     * @param field the field that need to be added to the array
     * @return an array with the new field at the end of the array
     */
    public BuyableField[] expandArr(BuyableField[] fields, BuyableField field){
        BuyableField[] tempArr = new BuyableField[fields.length+1];
        for(int i = 0;i<fields.length;i++){
            tempArr[i] = fields[i];
        }
        tempArr[fields.length] = field;
        return  tempArr;
        }

    /**
     * expands an array of strings
     * @param strings the array of strings
     * @param string the string that you want to add
     * @return an array with the new string at the end of the array
     */
    public String[] expandStrArr(String[] strings, String string){
            String[] tempArr = new String[strings.length+1];
            for(int i = 0;i<strings.length;i++){
                tempArr[i] = strings[i];
            }
            tempArr[strings.length] = string;
            return  tempArr;
    }

    /**
     * creates a string array of names of Fields
     * @param fields that you need the names of
     * @return an string array of names
     */
    public String[] getStringArrOfName (Field[]fields){
            String[] names = new String[fields.length];
            for (int i = 0; i < fields.length; i++) {
                names[i] = fields[i].getName();
            }
            return names;
        }


    }



