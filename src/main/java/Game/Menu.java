package Game;

import Controller.GUIController;

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
        BuyableField[] pawnedFields = pawned(gameBoard, player, ownedFields(gameBoard, player));
        String playerChose = guiController.buttons(language.getText(0, 0), getStringArrOfName(pawnedFields));
        for (int i = 0; i < pawnedFields.length; i++) {
            if (pawnedFields[i].getName().equals(playerChose) && pawnedFields[i].getIsPawned() != false) {
                pawnedFields[i].setIsPawned(true);
                player.subtractBalance(pawnedFields[i].getPawnValue());
            } else {
                guiController.showMessage(language.getText(0, 0));
            }
        }
    }

    public void buyHouseOrHotel(Language language, Player player, GUIController guiController, GameBoard gameBoard){
        BuyableField[] pawnedFields = pawned(gameBoard, player, ownedFields(gameBoard, player));

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



