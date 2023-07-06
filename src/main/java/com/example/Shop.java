package com.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Shop {
    
    private HashMap<String, Game> inventory;
    private ArrayList<Transaction> transactions;

    public Shop(){
        inventory = new HashMap<String, Game>();
        transactions = new ArrayList<Transaction>();
        generateInventory();
    }

    public void makeSale(String gameName, int saleAmmount){

        if (!inventory.containsKey(gameName)) {
            System.out.println("Este juego no se encuentra en la tienda");
            return;
        }
        if (!inventory.get(gameName).isAvailable()) {
            System.out.println("Este juego no se encuentra disponible en este momento");
            return;
        }
        if (inventory.get(gameName).getAvailableAmmount() < saleAmmount){
            System.out.println("No tenemos suficientes copias disponibles");
            return;
        }

        Game game = inventory.get(gameName);
        Transaction tr = new Transaction(game, "Venta", -saleAmmount, game.getSellingPrice() * saleAmmount);
        inventory.get(gameName).substractFromInventory(saleAmmount);
        transactions.add(tr);

    }

    public void makePurchase(String gameName, int purchaseAmmount){
        
        if (!inventory.containsKey(gameName)) {
            System.out.println("No podemos comprar este juego");
            return;
        }

        Game game = inventory.get(gameName);
        Transaction tr = new Transaction(game, "Compra", purchaseAmmount, -game.getPurchasePrice() * purchaseAmmount);
        inventory.get(gameName).addToInventory(purchaseAmmount);
        transactions.add(tr);
    }

    public void makeReport(){
        int totalMoney = 0;
        System.out.println("Reporte de ventas");
        for (Transaction transaction : transactions) {
            transaction.printTransaction();
            totalMoney += transaction.moneyTransacted;
        }
        System.out.printf("Ingresos totales: %d", totalMoney);
    }

    public void checkInventory(){
        for (Game game : inventory.values()) {
            game.printGameInfo();
        }
    }

    private void generateInventory(){
        inventory.put("Battlefield 1", new Game("Battlefield 1", 100, 15000, 35000, "Shooter", "PC"));
        inventory.put("The Legend of Zelda: Breath of the Wild", new Game("The Legend of Zelda: Breath of the Wild", 150, 30000, 60000, "Adventure", "Nintendo Switch"));
        inventory.put("Halo: Reach", new Game("Halo: Reach", 50, 5000, 15000, "Shooter", "XBox"));
        inventory.put("The Last of Us 2", new Game("The Last of Us 2", 70, 25000, 45000, "Action", "Play Station"));
        inventory.put("Metal Gear Solid: " + /* I'M STIIIILL IN A DREAAAAAM */ "Snake Eater", new Game("Metal Gear Solid: Snake Eater", 30, 10000, 20000, "Stealth Action", "Play Station")); 
        inventory.put("Left 4 Dead 2", new Game("Left 4 Dead 2", 100, 7000, 10000, "Zombies", "PC"));
        inventory.put("Half Life: Alyx", new Game("Half Life: Alyx", 300, 25000, 40000, "Action", "PC Virtual Reality"));

    }

    public HashMap<String, Game> getInventory() {
        return inventory;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
