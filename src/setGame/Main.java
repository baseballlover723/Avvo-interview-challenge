package setGame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("running main");
    }

    // basically a redirect
    public static boolean method1(Card card1, Card card2, Card card3) {
        boolean validSet = new Set(card1, card2, card3).isValid();
        if (validSet) {
            System.out.println("The given cards are a valid set");
        } else {
            System.out.println("The given cards are not a valid set");
        }
        return validSet;
    }

    public static boolean method2(Card[] cards) {
        Board board = new Board(cards);
        boolean hasSetRevealed = board.hasSetRevealed();
        if (hasSetRevealed) {
            System.out.println("Found a set on the given board");
        } else {
            System.out.println("Could not find a set on the given board");
        }
        return hasSetRevealed;
    }

    public static ArrayList<Set> method3() {
        return new ArrayList<Set>();
    }
}
