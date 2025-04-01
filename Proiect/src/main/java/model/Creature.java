package model;

import enums.StatType;

public abstract class Creature implements Being {
    protected String name;
    protected int rank;
    protected int maxHealth;
    protected int currentHealth;
    protected int power;
    protected int defense;

    public Creature(String name, int rank, int maxHealth, int power, int defense) {
        this.name = name;
        this.rank = rank;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.power = power;
        this.defense = defense;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public boolean isAlive() {
        return currentHealth > 0;
    }

    @Override
    public void receiveDamage(int amount) {
        currentHealth = Math.max(currentHealth - amount, 0);
    }

    @Override
    public void heal(int amount) {
        if(isAlive()) {
            currentHealth = Math.min(currentHealth + amount, maxHealth);
        }
    }

    public void boostStat(StatType stat, int value) {
        switch (stat) {
            case StatType.POWER -> power += value;
            case StatType.DEFENSE -> defense += value;
            case StatType.MAX_HEALTH -> maxHealth += value;
            case StatType.RANK -> rank += value;
            default -> throw new IllegalStateException("Unexpected value: " + stat);
        }
    }

    @Override
    public int getStat(StatType stat) {
        return switch (stat) {
            case StatType.POWER -> power;
            case StatType.DEFENSE -> defense;
            case StatType.MAX_HEALTH -> maxHealth;
            case StatType.CURRENT_HEALTH -> currentHealth;
            case StatType.RANK -> rank;
        };
    }

    @Override
    public void revive() {
        if (!isAlive()) {
            currentHealth = maxHealth;
        }
    }

    @Override
    public String getStatus() {
        return String.format("%s (%s, Rank %d) - HP: %d/%d | Power: %d | Defense: %d",
                name, getType(), rank, currentHealth, maxHealth, power, defense);
    }

    @Override
    public String getShortStatus()
    {
        return String.format("%s (%s, Rank %d)", name, getType(), rank);
    }

    // Each creature type evolves in a different way
    public abstract void evolve();

    @Override
    public abstract String getType();

}
