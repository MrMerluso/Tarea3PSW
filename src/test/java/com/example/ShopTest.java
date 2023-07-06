package com.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopTest {
    
    @Test
    public void testShopSale(){
        Shop shop = new Shop(); 
        HashMap<String, Game> inventory = shop.getInventory();
        ArrayList<Transaction> transactions = shop.getTransactions();

        String testGame = "Battlefield 1";

        shop.makeSale(testGame, 100);
        assertFalse("Ya no deberian quedar copias del juego", inventory.get(testGame).isAvailable());
        assertTrue(transactions.size() > 0);
    }

    @Test
    public void testShopPurchase(){
        Shop shop = new Shop(); 
        HashMap<String, Game> inventory = shop.getInventory();
        ArrayList<Transaction> transactions = shop.getTransactions();

        String testGame = "Battlefield 1";

        shop.makePurchase(testGame, 100);

        assertTrue(inventory.get(testGame).getAvailableAmmount() == 200);
        assertTrue(transactions.size() > 0);
    }
}
