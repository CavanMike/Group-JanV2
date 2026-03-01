import java.util.Random;
import java.util.Scanner;

public class GameEngine {
    private int choiceCounter = 0;
    private Player player; // This will be filled by the constructor
    private CombatManager combat = new CombatManager();
    private CampPhase camp = new CampPhase();
    private Random rand = new Random();

    // ADD THIS CONSTRUCTOR HERE
    public GameEngine(Player player) {
        this.player = player;
    }

    public void startLoop() {
        boolean gameRunning = true;

        while (gameRunning) {
            choiceCounter++; 
            
            System.out.println("\n===========================");
            System.out.println("ROUND: " + choiceCounter);
            System.out.println("===========================");

            if (choiceCounter % 5 == 0) {
                triggerBossEncounter();
            } else {
                triggerRandomPath();
            }

            // Check if player is still alive
            if (player.getHp() <= 0) {
                System.out.println("GAME OVER. Sukadi Boi has fallen...");
                gameRunning = false;
            } else {
                camp.enterCamp(player);
                player.clearTempResources(); 
            }
        }
    }

    private void triggerRandomPath() {
        System.out.println("Pick your path:");
        System.out.println("1. Combat | 2. Item | 3. Shop");
        
        Scanner sc = new Scanner(System.in);
        // Added a check to prevent crashing if user enters something other than a number
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input! You tripped and did nothing.");
            sc.next(); // clear the invalid input
            return;
        }
        
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                Enemy e = new Zombie(); 
                combat.startCombat(player, e);
                break;
            case 2:
                System.out.println("You found a treasure chest!");
                player.getInventory().add("Sword"); 
                break;
            case 3:
                System.out.println("The Merchant greets you.");
                // triggerShop(player); 
                break;
            default:
                System.out.println("You wandered aimlessly.");
                break;
        }
    }

    private void triggerBossEncounter() {
        System.out.println("⚠️ WARNING: A powerful presence approaches...");
        System.out.println("The BossVers blocks your path!");
        
        BossVers boss = new BossVers();
        combat.startCombat(player, boss);
        
        // Only prints if player is still alive
        if (player.getHp() > 0) {
            System.out.println("The Boss has been defeated! The cycle continues...");
        }
    }
}

