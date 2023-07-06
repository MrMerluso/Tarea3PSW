package com.example;

public class Game {
    
    private String title;
    private int availableAmmount;
    private int purchasePrice;
    private int sellingPrice;
    private String genre;
    private String platform;
    
    public Game(String title, int availableAmmount, int purchasePrice, int sellingPrice, String genre, String platform){
        this.title = title;
        this.availableAmmount = availableAmmount;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.genre = genre;
        this.platform = platform;
    }

    public void substractFromInventory(int ammount){
        if (availableAmmount > 0) {
            availableAmmount -= ammount;
        }
    }

    public void addToInventory(int ammount){
        availableAmmount += ammount;
    }

    public boolean isAvailable(){
        return availableAmmount > 0;
    }

    public void printGameInfo(){
        System.out.printf("Título del juego: %s\n", title);
        System.out.printf("Género: %s\n", genre);
        System.out.printf("Plataforma: %s\n", platform);
        System.out.printf("Cantidad disponible: %d\n", availableAmmount);
        System.out.printf("Precio: %d\n", sellingPrice);
    }
    
    public int getAvailableAmmount() {
        return availableAmmount;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public String getTitle() {
        return title;
    }
}
