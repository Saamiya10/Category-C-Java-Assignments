class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        if (maxHealth <= 0) {
            throw new IllegalArgumentException("Maximum health must be greater than zero.");
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) return;
        this.health -= amount;
        if (this.health < 0) this.health = 0;
        System.out.println("Took " + amount + " damage -> health = " + this.health);
    }

    public void heal(int amount) {
        if (amount <= 0) return;
        this.health += amount;
        if (this.health > this.maxHealth) this.health = this.maxHealth;
        System.out.println("Healed " + amount + " -> health = " + this.health);
    }

    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
}

public class CharacterHealthManager {
    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}