public abstract class Entity {
    protected String name;
    protected int hp, maxHp, attack, speed;

    public Entity(String name, int hp, int maxHp, int attack, int speed) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.speed = speed;
    }

    // Getters for display logic
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }
    public int getSpeed() { return speed; }

    public void setHp(int hp) { 
        this.hp = hp;
        if (this.hp > maxHp) this.hp = maxHp;
    }

    public void receiveDamage(int amount) {
        this.hp -= amount;
        if (this.hp < 0) this.hp = 0;
    }

    public abstract void takeTurn(Entity target);
}