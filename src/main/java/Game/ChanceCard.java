package Game;

/**
 * @Author Isak Risager
 */
public abstract class ChanceCard
{
    protected int chanceCardID;

    public ChanceCard(int chanceCardID)
    {
        this.chanceCardID = chanceCardID;
    }
    public int getChanceCardID(){return this.chanceCardID;}
}
