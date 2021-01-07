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
    private Fields[] ownedFields;
    private int doubleCounter;

    public Player(String name, Account account, GUI_Player GUIPlayer){
        this.name = name;
        this.account = account;
        this.GUIPlayer = GUIPlayer;
        getOutOfJailCard = 0;
        isInJail = false;
        jailCounter = 0;
        ownedFields;
        doubleCounter = 0;
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

    public boolean isInJail() {
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
}
