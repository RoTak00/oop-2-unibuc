package model;

public class Phoenix extends Creature {

    public Phoenix(String name, int rank, int maxHealth, int power, int defense) {
        super(name, rank, maxHealth, power, defense);
    }

    @Override
    public void evolve() {
        if (!isAlive()) return;

        rank += 2;
        maxHealth += 20;
        power += 12;
        defense += 3;
        currentHealth = maxHealth;
    }

    @Override
    public String getType() {
        return "Phoenix";
    }

}
