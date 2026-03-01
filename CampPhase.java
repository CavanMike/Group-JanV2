import java.util.Scanner;

public class CampPhase {

    
    public void enterCamp(Player player) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n--------------------------------");
        System.out.println("CAMP PHASE: Rest and Recover");
        System.out.println("Current HP: " + player.getHp() + "/" + player.getMaxHp());
        System.out.println("--------------------------------");
        System.out.println("1. Heal Up (Restore 30% HP)");
        System.out.println("2. Prepare (Gain +20 Temp Mana)");
        
        System.out.print("What will you do? ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // Heal Logic (30% of max HP)
            int healAmount = (int)(player.getMaxHp() * 0.30);
            int newHp = player.getHp() + healAmount;
            
            // Cap HP at maxHP
            if (newHp > player.getMaxHp()) newHp = player.getMaxHp();
            
            player.setHp(newHp);
            System.out.println("You feel refreshed! Restored " + healAmount + " HP.");
        } 
        else if (choice == 2) {
            // Prepare Logic: Adding Temp Mana
            // This calls the method we built in the Player class earlier!
            player.addTempMana(20);
            System.out.println("You focus your energy. Temporary Mana increased!");
        } 
        else {
            System.out.println("You wasted time staring at the fire. No benefit gained.");
        }
        
        System.out.println("You leave the camp feeling ready for the next challenge.");
    }
}