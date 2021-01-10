package Controller;

import Game.*;

import java.util.Random;

public class ChanceCardController {
    ChanceCard[] chanceCardDeck = new ChanceCard[46];
    public ChanceCardController()
    {
        for(int i = 0; i<chanceCardDeck.length; i++)
        if(i<12)
        {
            chanceCardDeck[i] = new PaymentChanceCard(i);
            i++;
        }
        else if(i>=12 && i<27)
        {
            chanceCardDeck[i] = new IncomeChanceCard(i);
        }
        else if(i>=27 && i<44)
        {
            chanceCardDeck[i] = new MoveChanceCard(i);
        }
        else if(i>= 44)
        {
            chanceCardDeck[i] = new JailChanceCard(i);
        }
    }
    ChanceCard currentCard;

    /**
     * Move the cards in the deck 1 time and draws the first card
     * @return the first card in the deck
     */
    public ChanceCard drawChanceCard()
    {
        for(int i = 0; i<=chanceCardDeck.length-1; i++)
        {
            if(i==chanceCardDeck.length-1)
            {
                chanceCardDeck[i] = chanceCardDeck[0];
            }
            else
                chanceCardDeck[i] = chanceCardDeck[i+1];
        }
        currentCard = chanceCardDeck[0];
        return chanceCardDeck[0];
    }

    public void shuffleChanceCardDeck()
    {
        Random random = new Random();

        for (int i = 0; i < chanceCardDeck.length; i++) {

            int r = i + random.nextInt((chanceCardDeck.length ) - i);

            ChanceCard temp = chanceCardDeck[r];
            chanceCardDeck[r] = chanceCardDeck[i];
            chanceCardDeck[i] = temp;
        }
        random=null;
    }
    public void executeChanceCard(GameBoard gameBoard,PlayerController playerController,GUIController guiController,Language language){
    }
}
