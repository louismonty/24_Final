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
    public void executeChanceCard(Language language, GUIController guiController, GameBoard gameBoard,PlayerController playerController, ChanceCard currentChanceCard){

        switch(currentChanceCard.getChanceCardID()) {
            case 0:
                ((PaymentChanceCard)currentChanceCard).oilPricesCard(language,guiController,gameBoard,playerController);
                 break;
            case 1:
                ((PaymentChanceCard)currentChanceCard).propertyTaxCard(language,guiController,gameBoard,playerController);
                break;
            case 2:
                ((PaymentChanceCard)currentChanceCard).redLightCard(language,guiController,playerController);
                break;
            case 3:
                ((PaymentChanceCard)currentChanceCard).carWashCard(language,guiController,playerController);
                break;
            case 4:
                ((PaymentChanceCard)currentChanceCard).beerCard(language,guiController,playerController);
                break;
            case 5:
                ((PaymentChanceCard)currentChanceCard).carRepairCard(language,guiController,playerController);
                break;
            case 6:
                ((PaymentChanceCard)currentChanceCard).carRepairCard(language,guiController,playerController);
                break;
            case 7:
                ((PaymentChanceCard)currentChanceCard).newTiresCard(language,guiController,playerController);
                break;
            case 8:
                ((PaymentChanceCard)currentChanceCard).parkingTicketCard(language,guiController,playerController);
                break;
            case 9:
                ((PaymentChanceCard)currentChanceCard).carInsuranceCard(language,guiController,playerController);
                break;
            case 10:
                ((PaymentChanceCard)currentChanceCard).cigaretteCard(language,guiController,playerController);
                break;
            case 11:
                ((PaymentChanceCard)currentChanceCard).dentistCard(language,guiController,playerController);
                break;
            case 12:
                ((IncomeChanceCard)currentChanceCard).lotteryCard(language,guiController,playerController);
                break;
            case 13:
                ((IncomeChanceCard)currentChanceCard).lotteryCard(language,guiController,playerController);
                break;
            case 14:
                ((IncomeChanceCard)currentChanceCard).stockDividendsCard(language,guiController,playerController);
                break;
            case 15:
                ((IncomeChanceCard)currentChanceCard).stockDividendsCard(language,guiController,playerController);
                break;
            case 16:
                ((IncomeChanceCard)currentChanceCard).stockDividendsCard(language,guiController,playerController);
                break;
            case 17:
                ((IncomeChanceCard)currentChanceCard).taxReturnCard(language,guiController,playerController);
                break;
            case 18:
                ((IncomeChanceCard)currentChanceCard).gamblingCard(language,guiController,playerController);
                break;
            case 19:
                ((IncomeChanceCard)currentChanceCard).salaryIncreaseCard(language,guiController,playerController);
                break;
            case 20:
                ((IncomeChanceCard)currentChanceCard).premiumBondCard(language,guiController,playerController);
                break;
            case 21:
                ((IncomeChanceCard)currentChanceCard).premiumBondCard(language,guiController,playerController);
                break;
            case 22:
                ((IncomeChanceCard)currentChanceCard).soldFurnitureCard(language,guiController,playerController);
                break;
            case 23:
                ((IncomeChanceCard)currentChanceCard).utilityGardenCard(language,guiController,playerController);
                break;
            case 24:
                ((IncomeChanceCard)currentChanceCard).matadorGrantCard(language,guiController,gameBoard,playerController);
                break;
            case 25:
                ((IncomeChanceCard)currentChanceCard).birthdayCard(language,guiController,playerController);
                break;
            case 26:
                ((IncomeChanceCard)currentChanceCard).potluckCard(language,guiController,playerController);
                break;
            case 27:
                ((IncomeChanceCard)currentChanceCard).familyPartyCard(language,guiController,playerController);
                break;
            case 28:
                ((MoveChanceCard)currentChanceCard).startCard(language,guiController,gameBoard,playerController);
                break;
            case 29:
                ((MoveChanceCard)currentChanceCard).startCard(language,guiController,gameBoard,playerController);
                break;
            case 30:
                ((MoveChanceCard)currentChanceCard).threeFieldsForwardCard(language,guiController,gameBoard,playerController);
                break;
            case 31:
                ((MoveChanceCard)currentChanceCard).threeFieldsBackwardsCard(language,guiController,gameBoard,playerController);
                break;
            case 32:
                ((MoveChanceCard)currentChanceCard).threeFieldsBackwardsCard(language,guiController,gameBoard,playerController);
                break;
            case 33:
                ((MoveChanceCard)currentChanceCard).frederiksbergAlleCard(language,guiController,gameBoard,playerController);
                break;
            case 34:
                ((MoveChanceCard)currentChanceCard).shipyardCard(language,guiController,gameBoard,playerController);
                break;
            case 35:
                ((MoveChanceCard)currentChanceCard).shipyardCard(language,guiController,gameBoard,playerController);
                break;
            case 36:
                ((MoveChanceCard)currentChanceCard).molslinjenCard(language,guiController,gameBoard,playerController);
                break;
            case 37:
                ((MoveChanceCard)currentChanceCard).groenningenCard(language,guiController,gameBoard,playerController);
                break;
            case 38:
                ((MoveChanceCard)currentChanceCard).vimmelskaftetCard(language,guiController,gameBoard,playerController);
                break;
            case 39:
                ((MoveChanceCard)currentChanceCard).ferryCard(language,guiController,gameBoard,playerController);
                break;
            case 40:
                ((MoveChanceCard)currentChanceCard).strandvejenCard(language,guiController,gameBoard,playerController);
                break;
            case 41:
                ((MoveChanceCard)currentChanceCard).raadhuspladsenCard(language,guiController,gameBoard,playerController);
                break;
            case 42:
                ((JailChanceCard)currentChanceCard).getOutOfJailCard(language, guiController, playerController);
                break;
            case 43:
                ((JailChanceCard)currentChanceCard).getOutOfJailCard(language, guiController, playerController);
                break;
            case 44:
                ((JailChanceCard)currentChanceCard).goToJailCard(language, guiController, playerController);
                break;
            case 45:
                ((JailChanceCard)currentChanceCard).getOutOfJailCard(language, guiController, playerController);
                break;




        }
    }
}
