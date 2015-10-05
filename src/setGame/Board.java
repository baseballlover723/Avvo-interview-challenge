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

    public Set removeRevealedSet() {
        if (this.size() < 3) {
            return null;
        }
        for (int i = 0; i < this.size() - 2; i++) {
            for (int k = i + 1; k < this.size() - 1; k++) {
                for (int j = k + 1; j < this.size(); j++) {
                    Card card1 = this.get(i);
                    Card card2 = this.get(k);
                    Card card3 = this.get(j);
                    Set set = new Set(card1, card2, card3);
                    if (set.isValid()) {
                        this.remove(j);
                        this.remove(k);
                        this.remove(i);
                        return set;
                    }
                }
            }
        }
        return null;
    }

    public boolean hasSetRevealed() {
        if (this.size() < 3) {
            return false;
        }
        for (int i = 0; i < this.size() - 2; i++) {
            for (int k = i + 1; k < this.size() - 1; k++) {
                for (int j = k + 1; j < this.size(); j++) {
                    Card card1 = this.get(i);
                    Card card2 = this.get(k);
                    Card card3 = this.get(j);
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
