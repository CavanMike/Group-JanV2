public class Zombie extends Enemy {

    public Zombie() {
        // Name, HP, Attack, Speed, Gold, Item
        super("Zombie", 60, 12, 5, 15, "Zombie Brain");
    }

    @Override
    public void takeTurn(Entity target) {
        System.out.println("\n--- " + this.getName().toUpperCase() + "'S TURN ---");
        // Displaying HP as requested
        System.out.println("HP: " + this.getHp() + "/" + this.getMaxHp());
        System.out.println("The Zombie moans and bites at " + target.getName() + "!");
        
        target.receiveDamage(this.getAttack());
        System.out.println("Result: " + target.getName() + " took " + this.getAttack() + " damage!");
    }
}