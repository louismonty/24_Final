package Controller;

import Game.ChanceCard;
import Game.IncomeChanceCard;
import Game.PaymentChanceCard;

import java.util.Random;

public class ChanceCardController {
    ChanceCard[] chanceCardDeck = new ChanceCard[46];
    public ChanceCardController(){
        int i = 0;

        while(i<12){
            chanceCardDeck[i] = new PaymentChanceCard(i);
            i++;
        }
        while(i<25){
            chanceCardDeck[i] = new IncomeChanceCard(i);
        }
    }


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
}
