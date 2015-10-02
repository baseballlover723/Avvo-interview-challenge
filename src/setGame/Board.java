package setGame;

public class Board extends Deck {
    public Board() {
        super(0);
    }

    public Board(int deckSize) {
        super(deckSize);
    }

    public Board(Card[] cards) {
        super(cards);
    }

    public boolean hasSetRevealed() {
        if (this.cards.size() < 3) {
            return false;
        }
        for (int i = 0; i < this.cards.size() - 2; i++) {
            for (int k = i + 1; k < this.cards.size() - 1; k++) {
                for (int j = k + 1; j < this.cards.size(); j++) {
                    Card card1 = this.cards.get(i);
                    Card card2 = this.cards.get(k);
                    Card card3 = this.cards.get(j);
                    Set set = new Set(card1, card2, card3);
                    if (set.isValid()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
