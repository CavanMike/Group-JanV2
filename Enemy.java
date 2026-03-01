public class Enemy extends Entity {
    private int lootValue;
    private String lootItem;

    public Enemy(String type, int hp, int attack, int speed, int gold, String item) {
        super(type, hp, hp, attack, speed);
        this.lootValue = gold;
        this.lootItem = item;
    }

    @Override
    public void takeTurn(Entity target) {
        System.out.println("\n--- " + this.getName().toUpperCase() + "'S TURN ---");
        // --- HP DISPLAY ADDED HERE ---
        System.out.println("HP: " + this.getHp() + "/" + this.getMaxHp());
        System.out.println(this.getName() + " attacks " + target.getName() + "!");
        
        target.receiveDamage(this.getAttack());
        System.out.println("Result: " + target.getName() + " took " + this.getAttack() + " damage!");
    }

    public int getLootValue() { return lootValue; }
    public String getLootItem() { return lootItem; }
}