import java.util.Scanner;

public class CombatManager {

    /**
     * Starts a speed-based combat loop between the player and an enemy.
     * @param player The user-controlled player
     * @param enemy The monster encountered
     * @return true if player wins, false if player dies (Game Over)
     */
    public boolean startCombat(Player player, Enemy enemy) {
        System.out.println("\n!!! A " + enemy.getName().toUpperCase() + " APPEARS !!!");
        
        // Loop runs as long as both have HP > 0
        while (player.getHp() > 0 && enemy.getHp() > 0) {
            
            // --- Determine Turn Order based on Speed ---
            if (player.getSpeed() >= enemy.getSpeed()) {
                // Player is faster
                player.takeTurn(enemy);
                if (checkDefeat(enemy)) break; // Stop if enemy died

                enemy.takeTurn(player);
                if (checkDefeat(player)) return false; // Game Over
            } 
            else {
                // Enemy is faster
                enemy.takeTurn(player);
                if (checkDefeat(player)) return false; // Game Over

                player.takeTurn(enemy);
                if (checkDefeat(enemy)) break; // Stop if enemy died
            }
        }

        // If we exited the loop and player is alive, they won!
        System.out.println("\nVICTORY! The " + enemy.getName() + " has been defeated.");
        
        // Reward the player (as per your System Architecture)
        player.addGold(enemy.getLootValue());
        player.getInventory().add(enemy.getLootItem());
        System.out.println("Loot found: " + enemy.getLootValue() + " Gold and " + enemy.getLootItem());
        
        return true; 
    }

    /**
     * Helper to check if an entity has fallen
     */
    private boolean checkDefeat(Entity e) {
        if (e.getHp() <= 0) {
            System.out.println(e.getName() + " has fallen!");
            return true;
        }
        return false;
    }
}