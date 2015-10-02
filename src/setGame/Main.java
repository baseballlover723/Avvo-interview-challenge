package setGame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("running main");
    }
    
    // basically a redirect
    public static boolean method1(Card card1, Card card2, Card card3) {
        return new Set(card1, card2, card3).isValid();
    }
    
    public static boolean method2(Card[] cards) {
        return false;
    }
    
    public static ArrayList<Set> method3() {
        return new ArrayList<Set>();
    }
}
