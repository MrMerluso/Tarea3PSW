package com.example;

public class Transaction {
    public final Game game;
    public final String transactionType;
    public final int ammountTransacted;
    public final int moneyTransacted;

    public Transaction(Game game, String transactionType, int ammountTransacted, int moneyTransacted){
        this.game = game;
        this.transactionType = transactionType;
        this.ammountTransacted = ammountTransacted;
        this.moneyTransacted = moneyTransacted;
    }

    public void printTransaction(){
        System.out.printf("%s:\t%s\t%d\t%d\n", transactionType, game.getTitle(), ammountTransacted, moneyTransacted);
    }
}