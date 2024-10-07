package edu.uoc.ds.samples.module2;

import org.junit.Test;

public class BingoTest {


    @Test
    public void test() {
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
