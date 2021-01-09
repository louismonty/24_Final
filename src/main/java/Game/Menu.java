package Game;

import Controller.GUIController;

public class Menu {
    public void takeTurnMenu(Language language,GameBoard gameBoard,GUIController guiController,Player player){
        while (true) {
            String playerChose = guiController.buttons(language.getText(0,0), language.getLine(1));
            if (playerChose == language.getText(1, 0)) {
                break;
            }
            else if((playerChose == language.getText(1, 1))){
                System.out.println("test2");
            }
            else if(playerChose == language.getText(1, 2)) {
                System.out.println("test2");
            }
            else if(playerChose == language.getText(1, 3)){
                System.out.println("test3");
            }
            else if(playerChose == language.getText(1, 4)){
                System.out.println("test4");
            }
        }
    }
    public BuyableField[] ownedFields(GameBoard gameBoard,Player player){
        BuyableField[] arr = new BuyableField[0];
        for(int i = 0; i<gameBoard.getGameBoard().length;i++){
            if(gameBoard.getGameBoard()[i] instanceof BuyableField){
                BuyableField field = (BuyableField) gameBoard.getGameBoard()[i];
                if(field.getOwner() == player.getPlayerID()){
                    BuyableField[] tempArr = new BuyableField[arr.length+1];
                    for(int j = 0; j<tempArr.length;j++){
                        tempArr[i] = arr[i]
                    }
                    tempArr[tempArr.length]
                    arr = tempArr;
                }
            }
        }
    return arr;
    }

    public String[] getStringArrOfName(Field[] fields){
        String[] names = new String[fields.length];
        for(int i = 0;i<fields.length;i++){
            names[i]=fields[i].getName();
        }
        return names;
    }


    public void pawn(Language language,Player player,GUIController guiController,GameBoard gameBoard){
        BuyableField[] pawnebelFields = ownedFields(gameBoard,player);
        String playerChose = guiController.buttons(language.getText(0, 0),getStringArrOfName());
        for(int i = 0;i<pawnebelFields.length;i++){
            if(pawnebelFields[i].getName().equals(playerChose) && pawnebelFields[i].getIsPawned != true){
                pawnebelFields[i].setIsPawned(true);
                player.addBalance(pawnebelFields[i].getPawnValue);
            }
            else{
                guiController.showMessage(language.getText(0,0));
            }
        }
    }

    public void buyHouseOrHotel(Language language,GUIController guiController,Player player){
        if(player)
        String playerChose = guiController.buttons(language.getText(0, 0));
        if(playerChose )

    }
    }


