package Game;

import gui_fields.GUI_Player;
import org.graalvm.compiler.core.common.Fields;

/**
 * @author “Daniel”
 *
 */

public class Player {

    private String name;
    private Account account;
    private GUI_Player GUIPlayer;
    private int getOutOfJailCard;
    private boolean isInJail;
    private int jailCounter;
    private int doubleCounter;
    private Fields[] ownedFields;
    private int playerPosition;
    private int playerID;
    private int numberOfMoves;
    private boolean hasMoved;


    public Player(String name,int playerID){
        this.name = name;
        account.setBalance(30000);
        this.GUIPlayer = new GUI_Player(name, 30000);
        getOutOfJailCard = 0;
        isInJail = false;
        jailCounter = 0;
        ownedFields = new Fields[0];
        doubleCounter = 0;
        playerPosition = 0;
        this.playerID = playerID;
        this.numberOfMoves = 0;
        hasMoved = false;
    }

    /**
     * @author Louis
     * @param newField
     */
    public void addField(Fields newField){
            int lengtharr = ownedFields.length;
            Fields[] temparr = new Fields[lengtharr + 1];
            for (int i = 0; i < ownedFields.length; i++) {
                temparr[i] = ownedFields[i];
            }
            temparr[lengtharr] = newField;
            ownedFields = temparr;
    }

    /**
     * @author Louis
     * @param ball
     */
    public void addBalance(int ball){
        GUIPlayer.setBalance(account.getBalance()+ball);
        account.addBalance(ball);
    }

    /**
     * @author Louis
     * @param ball
     */
    public void subtractBalance(int ball){
        GUIPlayer.setBalance(account.getBalance()-ball);
        account.subtractBalance(ball);
    }

    public int getNumberOfMoves(){
        return numberOfMoves;
    }

    public void setNumberOfMoves(int numberOfMoves){
        this.numberOfMoves = numberOfMoves;
    }

    public boolean getHasMoved()
    {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved)
    {
        this.hasMoved = hasMoved;
    }

    public int getPlayerID(){
        return playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public GUI_Player getGUIPlayer() {
        return GUIPlayer;
    }

    public void setGUIPlayer(GUI_Player GUIPlayer) {
        this.GUIPlayer = GUIPlayer;
    }

    public int getGetOutOfJailCard() {
        return getOutOfJailCard;
    }

    public void setGetOutOfJailCard(int getOutOfJailCard) {
        this.getOutOfJailCard = getOutOfJailCard;
    }

    public boolean isInJail(boolean b) {
        return isInJail;
    }

    public void setInJail(boolean inJail) {
        isInJail = inJail;
    }

    public int getJailCounter() {
        return jailCounter;
    }

    public void setJailCounter(int jailCounter) {
        this.jailCounter = jailCounter;
    }

    public Fields[] getOwnedFields() {
        return ownedFields;
    }

    public void setOwnedFields(Fields[] ownedFields) {
        this.ownedFields = ownedFields;
    }

    public int getDoubleCounter() {
        return doubleCounter;
    }

    public void setDoubleCounter(int doubleCounter) {
        this.doubleCounter = doubleCounter;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }
}
