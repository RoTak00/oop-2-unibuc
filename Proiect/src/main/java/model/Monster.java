package model;

import enums.StatType;

public class Monster implements Being {
    private final String name;
    private final int rank;
    private final int maxHealth;
    private int currentHealth;
    private final int power;
    private final int defense;
    protected Integer id;

    public Monster(String name, int rank, int maxHealth, int power, int defense) {
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
    public Integer getId() { return id; }

    @Override
    public void setId(int id) { this.id = id; }

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
        if (isAlive()) {
            currentHealth = Math.min(currentHealth + amount, maxHealth);
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
        currentHealth = maxHealth;
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

    @Override
    public String getType() {
        return "Monster";
    }
}
