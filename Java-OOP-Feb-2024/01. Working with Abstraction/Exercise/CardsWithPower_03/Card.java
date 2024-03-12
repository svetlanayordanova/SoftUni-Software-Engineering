package working_with_abstraction_exercise.CardsWithPower_03;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int getPower() {
        return cardRank.getPower() + cardSuit.getPower();
    }

    public void print() {
        System.out.printf("Card name: %s of %s; Card power: %d",
                cardRank,
                cardSuit,
                getPower());
    }
}
