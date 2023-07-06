package com.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameTest {
    
    Game game = new Game("Test Game", 1, 100, 200, "Genre", "Platform");
    
    @Test
    public void testGameAvailability(){

        assertTrue("Hay existencias", game.isAvailable());
        
        game.substractFromInventory(1);
        assertFalse("ya no hay copias", game.isAvailable());

        game.substractFromInventory(999999);
        assertTrue("La cota inferior de copias disponibles es 0", game.getAvailableAmmount() == 0);

        game.addToInventory(999999);
        assertTrue("Se agregan copias correctamente", game.getAvailableAmmount() == 999999);
    }
}
