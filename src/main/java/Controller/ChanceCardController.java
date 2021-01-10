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
        PaymentChanceCard card1 = (PaymentChanceCard)currentCard;
        IncomeChanceCard card2 = (IncomeChanceCard)currentCard;
        MoveChanceCard card3 = (MoveChanceCard)currentCard;
        JailChanceCard card4 = (JailChanceCard)currentCard;
        switch(currentCard.getChanceCardID()) {
            case 0:
                 card1.oilPricesCard(language,guiController,gameBoard,playerController);
                 break;
            case 1:
                card1.propertyTaxCard(language,guiController,gameBoard,playerController);
                break;
            case 2:
                card1.redLightCard(language,guiController,playerController);
                break;
            case 3:
                card1.carWashCard(language,guiController,playerController);
                break;
            case 4:
                card1.beerCard(language,guiController,playerController);
                break;
            case 5:
                card1.carRepairCard(language,guiController,playerController);
                break;
            case 6:
                card1.carRepairCard(language,guiController,playerController);
                break;
            case 7:
                card1.newTiresCard(language,guiController,playerController);
                break;
            case 8:
                card1.parkingTicketCard(language,guiController,playerController);
                break;
            case 9:
                card1.carInsuranceCard(language,guiController,playerController);
                break;
            case 10:
                card1.cigaretteCard(language,guiController,playerController);
                break;
            case 11:
                card1.dentistCard(language,guiController,playerController);
                break;
            case 12:
                card2.lotteryCard(language,guiController,playerController);
                break;
            case 13:
                card2.lotteryCard(language,guiController,playerController);
                break;
            case 14:
                card2.stockDividendsCard(language,guiController,playerController);
                break;
            case 15:
                card2.stockDividendsCard(language,guiController,playerController);
                break;
            case 16:
                card2.stockDividendsCard(language,guiController,playerController);
                break;
            case 17:
                card2.taxReturnCard(language,guiController,playerController);
                break;
            case 18:
                card2.gamblingCard(language,guiController,playerController);
                break;
            case 19:
                card2.salaryIncreaseCard(language,guiController,playerController);
                break;
            case 20:
                card2.premiumBondCard(language,guiController,playerController);
                break;
            case 21:
                card2.premiumBondCard(language,guiController,playerController);
                break;
            case 22:
                card2.soldFurnitureCard(language,guiController,playerController);
                break;
            case 23:
                card2.utilityGardenCard(language,guiController,playerController);
                break;
            case 24:
                card2.matadorGrantCard(language,guiController,gameBoard,playerController);
                break;
            case 25:
                card2.birthdayCard(language,guiController,playerController);
                break;
            case 26:
                card2.potluckCard(language,guiController,playerController);
                break;
            case 27:
                card2.familyPartyCard(language,guiController,playerController);
                break;
            case 28:
                card3.startCard(language,guiController,gameBoard,playerController);
                break;
            case 29:
                card3.startCard(language,guiController,gameBoard,playerController);
                break;
            case 30:
                card3.threeFieldsForwardCard(language,guiController,gameBoard,playerController);
                break;
            case 31:
                card3.threeFieldsBackwardsCard(language,guiController,gameBoard,playerController);
                break;
            case 32:
                card3.threeFieldsBackwardsCard(language,guiController,gameBoard,playerController);
                break;
            case 33:
                card3.frederiksbergAlleCard(language,guiController,gameBoard,playerController);
                break;
            case 34:
                card3.shipyardCard(language,guiController,gameBoard,playerController);
                break;
            case 35:
                card3.shipyardCard(language,guiController,gameBoard,playerController);
                break;
            case 36:
                card3.molslinjenCard(language,guiController,gameBoard,playerController);
                break;
            case 37:
                card3.groenningenCard(language,guiController,gameBoard,playerController);
                break;
            case 38:
                card3.vimmelskaftetCard(language,guiController,gameBoard,playerController);
                break;
            case 39:
                card3.ferryCard(language,guiController,gameBoard,playerController);
                break;
            case 40:
                card3.strandvejenCard(language,guiController,gameBoard,playerController);
                break;
            case 41:
                card3.raadhuspladsenCard(language,guiController,gameBoard,playerController);
                break;
            case 42:
                card4.getOutOfJailCard(playerController.getCurrentPlayer(),guiController,language);
                break;
            case 43:
                card4.getOutOfJailCard(playerController.getCurrentPlayer(),guiController,language);
                break;
            case 44:
                card4.goToJailCard(playerController.getCurrentPlayer(),guiController,language);
                break;
            case 45:
                card4.getOutOfJailCard(playerController.getCurrentPlayer(),guiController,language);
                break;




        }
    }
}
