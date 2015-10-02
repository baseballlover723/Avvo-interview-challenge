package setGame;

public class Game {
    private Deck deck;
    private Board board;

    public Game() {
        this(new Deck(), new Board());
    }

    public Game(Deck deck, Board board) {
        this.deck = deck;
        this.board = board;
    }

    public Deck getDeck() {
        return this.deck;
    }
    
    public Board getBoard() {
        return this.board;
    }
}
