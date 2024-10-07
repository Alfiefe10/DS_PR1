package edu.uoc.ds.samples.module2;

import edu.uoc.ds.adt.sequential.Set;
import edu.uoc.ds.samples.module1.generics.SetArrayImpl;

import java.util.Random;

public class Bingo {
    private final Player[] players;
    private int numPlayers;
    private final int numBalls;
    private final int bingoCardSize;
    private Set<Integer> takenOutBalls;
    private final Random bingoCardGenerator;


    public Bingo(int maxNumPlayers, int numBalls, int bingoCardSize) {
        players = new Player[maxNumPlayers];
        this.numPlayers = 0;
        this.numBalls = numBalls;
        this.bingoCardSize = bingoCardSize;
        bingoCardGenerator = new Random();
    }

    public void prepareGame() {
        System.out.println("Prepare game...");
        for (int i = 0; i < numPlayers; i++) {
            Set<Integer> bingoCard = generateBingoCard();
            players[i].setBingoCard(bingoCard);
        }
        takenOutBalls = new SetArrayImpl<Integer>(numBalls);
    }

    protected Set<Integer> generateBingoCard() {
        Set<Integer> bingoCard = new SetArrayImpl<>(bingoCardSize);
        for (int n = 1; n < bingoCardSize; n++)
            bingoCard.add(bingoCardGenerator.nextInt(numBalls) + 1);
        return bingoCard;
    }

    public void newPlayer(String name) {
        Player player = new Player(name);
        players[numPlayers] = player;
        numPlayers++;
    }


    public String play() {
        System.out.println("Game start...");
        String winner = null;
        while (winner == null) {
            int theNumber = drawNumber();
            System.out.println("new number " + theNumber);
            for (int i = 0; i < numPlayers && winner == null; i++) {
                players[i].notifyNumber(theNumber);
                if (players[i].fullBingoCard())
                    winner = players[i].getName();
            }
        }
        System.out.println("Game Over");
        return winner;
    }




    protected int drawNumber() {
        int number = bingoCardGenerator.nextInt(numBalls) + 1;
        while (takenOutBalls.contains(number))
            number = bingoCardGenerator.nextInt(numBalls) + 1;
        takenOutBalls.add(number);
        return number;
    }


    public static void main(String[] args) {
        Bingo bingo = new Bingo(4, 100, 10);
        bingo.newPlayer("Juan");
        bingo.newPlayer("Ana");
        bingo.newPlayer("Maria");
        bingo.newPlayer("Miguel");
        bingo.prepareGame();
        String winner = bingo.play();
        System.out.println("The Winner is: " + winner);
    }

}
