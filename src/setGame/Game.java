package setGame;

import java.util.ArrayList;

public class Game {
    private Deck deck;
    private Board board;
    private ArrayList<Set> sets;

    public Game() {
        this(new Deck(), new Board());
    }

    public Game(Deck deck, Board board) {
        this.deck = deck;
        this.board = board;
        this.sets = new ArrayList<Set>();
    }

    public Deck getDeck() {
        return this.deck;
    }

    public Board getBoard() {
        return this.board;
    }

    public ArrayList<Set> getFoundSets() {
        return this.sets;
    }

    public void startGame() {
        for (int k = 0; k < 12; k += 3) {
            this.drawThreeCards();
        }
    }

    public void playTurn() {
        while (true) {
            Set foundSet = this.board.removeRevealedSet();
            if (foundSet == null) {
                return;
            }
            this.sets.add(foundSet);
        }
    }

    public void playGame() {
        while (true) {
            this.playTurn();
            if (!this.drawThreeCards()) {
                return;
            }
        }
    }

    private boolean drawThreeCards() {
        if (this.deck.empty()) {
            return false;
        }
        Card topCard = this.deck.pop();
        this.board.add(topCard);

        if (!this.deck.empty()) {
            topCard = this.deck.pop();
            this.board.add(topCard);
        }

        if (!this.deck.empty()) {
            topCard = this.deck.pop();
            this.board.add(topCard);
        }
        return true;
    }
}