import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends Entity {
    private int mana;
    private int maxMana;
    private int tempMana;
    private int gold;
    private List<String> inventory;

    public Player(String name) {
        super(name, 100, 100, 15, 12); 
        this.maxMana = 50;
        this.mana = 50;
        this.tempMana = 0;
        this.gold = 0;
        this.inventory = new ArrayList<>();
    }

    @Override
    public void takeTurn(Entity target) {
        Scanner scanner = new Scanner(System.in);
        int totalManaAvailable = this.mana + this.tempMana;
        
        System.out.println("\n--- " + this.getName().toUpperCase() + "'S TURN ---");
        System.out.println("HP: " + this.getHp() + "/" + this.getMaxHp());
        System.out.println("Mana: " + totalManaAvailable);
        System.out.println("1. Attack | 2. Skill");
        
        System.out.print("Select action: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            target.receiveDamage(this.getAttack());
            System.out.println("Basic Attack dealt " + this.getAttack() + " damage!");
        } else if (choice == 2) {
            chooseAndUseSkill(target); 
        }
    }

    public void chooseAndUseSkill(Entity target) {
        List<String> availableSkills = new ArrayList<>();
        
        if (this.inventory.contains("Sword")) availableSkills.add("Sword Slash (10 Mana)");
        if (this.inventory.contains("Bow"))   availableSkills.add("Arrow Rain (15 Mana)");
        if (this.inventory.contains("Staff")) availableSkills.add("Fireball (25 Mana)");
        if (this.inventory.contains("Totem")) availableSkills.add("Totem Heal (20 Mana)");
        
        if (availableSkills.isEmpty()) {
            availableSkills.add("Drill Punch (0 Mana)");
        }

        System.out.println("\n--- SELECT A SKILL ---");
        for (int i = 0; i < availableSkills.size(); i++) {
            System.out.println((i + 1) + ". " + availableSkills.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose your move: ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= availableSkills.size()) {
            String selected = availableSkills.get(choice - 1);
            executeSkillLogic(selected, target);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private void executeSkillLogic(String skillName, Entity target) {
        int damage = 0;
        int manaCost = 0;

        if (skillName.contains("Sword Slash")) {
            damage = this.getAttack() * 2;
            manaCost = 10;
            System.out.println("SWORD SLASH! ⚔️");
        } else if (skillName.contains("Arrow Rain")) {
            damage = (int)(this.getAttack() * 1.5);
            manaCost = 15;
            System.out.println("ARROW RAIN! 🏹");
        } else if (skillName.contains("Fireball")) {
            damage = this.getAttack() + 30;
            manaCost = 25;
            System.out.println("FIREBALL! 🔥");
        } else if (skillName.contains("Totem Heal")) {
            int healAmount = 25;
            this.setHp(this.getHp() + healAmount);
            manaCost = 20;
            System.out.println("TOTEM HEAL! 🌿");
        } else {
            damage = this.getAttack() + 5;
            manaCost = 0;
            System.out.println("DRILL PUNCH! 👊");
        }

        
        if (this.tempMana >= manaCost) {
            this.tempMana -= manaCost;
        } else {
            int remainingCost = manaCost - this.tempMana;
            this.tempMana = 0;
            this.mana -= remainingCost;
        }

        if (damage > 0) target.receiveDamage(damage);
    }

    public void addTempMana(int amount) { this.tempMana += amount; }
    public void clearTempResources() { this.tempMana = 0; }
    public int getGold() { return gold; }
    public void addGold(int amount) { this.gold += amount; }
    public List<String> getInventory() { return inventory; }
}