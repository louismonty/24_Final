package Game;

import gui_fields.GUI_Player;

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
    private int playerPosition;
    private int playerID;
    private int numberOfMoves;
    private boolean hasMoved;
    private boolean hasMovedBackwards;


    public Player(String name,int playerID){
        this.name = name;
        account = new Account();
        this.GUIPlayer = new GUI_Player(name, 30000);
        getOutOfJailCard = 0;
        isInJail = false;
        jailCounter = 0;
        doubleCounter = 0;
        playerPosition = 0;
        this.playerID = playerID;
        this.numberOfMoves = 0;
        hasMoved = false;
        hasMovedBackwards = false;
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

    public boolean getHasMovedBackwards()
    {
        return hasMovedBackwards;
    }

    public void setHasMovedBackwards(boolean hasMovedBackwards)
    {
        this.hasMovedBackwards = hasMovedBackwards;
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
