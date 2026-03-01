import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   WELCOME TO LEAD DEVS: SUKADI BOI'S   ");
        System.out.println("========================================");
        
        // 1. Initialize Player with a Name
        System.out.print("Enter your Hero's Name: ");
        String userName = input.nextLine();
        Player player = new Player(userName);
        
        System.out.println("\nWelcome, " + player.getName() + "!");
        System.out.println("Your journey begins. Every 5th round, a Boss awaits...");
        
        // 2. Initialize the Game Engine
        // We pass the player object so the engine can manage them
        GameEngine engine = new GameEngine(player);
        
        // 3. Start the Game
        try {
            engine.startLoop();
        } catch (Exception e) {
            System.out.println("A glitch in the matrix occurred: " + e.getMessage());
        }

        System.out.println("\n--- Final Score ---");
        System.out.println("Gold Collected: " + player.getGold());
        System.out.println("Thanks for playing Sukadi Boi's!");
    }
}