public class BossVers extends Enemy {
    public BossVers() {
       
        super("BossVers", 200, 30, 18, 500, "Legendary Totem");
    }

    @Override
    public void takeTurn(Entity target) {
        System.out.println("\n--- !!! BOSS TURN !!! ---");
        System.out.println("BossVers unleashes a devastating strike on " + target.getName() + "!");
        
        target.receiveDamage(this.getAttack());
        System.out.println("Result: " + target.getName() + " took " + this.getAttack() + " damage!");
    }
}