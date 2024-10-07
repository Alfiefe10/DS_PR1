package edu.uoc.ds.samples.module2;

import edu.uoc.ds.adt.sequential.Set;

public class Player {

    private final String name;
    private Set<Integer> bingoCard;

    public Player(String name) {
        this.name = name;
    }


    public void setBingoCard(Set<Integer> bingoCard) {
        this.bingoCard = bingoCard;
        System.out.println(this);
    }


    public void notifyNumber(int num) {
        Integer deletedElem = bingoCard.delete(num);
        if (deletedElem != null)
            System.out.println("(" + name + " noted)");
    }


    public boolean fullBingoCard() {
        return bingoCard.isEmpty();
    }


    public String getName() {
        return name;
    }


    public String toString() {
        return name + ": " + (bingoCard == null ? "Bingo card not initialized" : bingoCard.toString());
    }

}
