package Game;

import gui_fields.GUI_Player;

/**
 * @author “Daniel”
 *
 */

public class Player {

    private static String name;
    private static Account account;
    private static GUIPlayer GUIPlayer;
    private static int getOutOfJailCard;
    private static boolean isInJail;
    private static int jailCounter;
    private static Fields[] ownedFields;
    private static int doubleCounter;

    public Player(String name, Account account, GUIPlayer GUIPlayer){
        Player.name = name;
        Player.account = account;
        Player.GUIPlayer = GUIPlayer;
        getOutOfJailCard = 0;
        isInJail = false;
        jailCounter = 0;
        ownedFields.length = 0;
        doubleCounter = 0;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Player.name = name;
    }

    public static Account getAccount() {
        return account;
    }

    public static void setAccount(Account account) {
        Player.account = account;
    }

    public static GUIPlayer getGUIPlayer() {
        return GUIPlayer;
    }

    public static void setGUIPlayer(GUIPlayer GUIPlayer) {
        Player.GUIPlayer = GUIPlayer;
    }

    public static int getGetOutOfJailCard() {
        return getOutOfJailCard;
    }

    public static void setGetOutOfJailCard(int getOutOfJailCard) {
        Player.getOutOfJailCard = getOutOfJailCard;
    }

    public static boolean isIsInJail() {
        return isInJail;
    }

    public static void setIsInJail(boolean isInJail) {
        Player.isInJail = isInJail;
    }

    public static int getJailCounter() {
        return jailCounter;
    }

    public static void setJailCounter(int jailCounter) {
        Player.jailCounter = jailCounter;
    }

    public static Fields[] getOwnedFields() {
        return ownedFields;
    }

    public static void setOwnedFields(Fields[] ownedFields) {
        Player.ownedFields = ownedFields;
    }

    public static int getDoubleCounter() {
        return doubleCounter;
    }

    public static void setDoubleCounter(int doubleCounter) {
        Player.doubleCounter = doubleCounter;
    }
}
