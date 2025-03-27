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
            case POWER -> power += value;
            case DEFENSE -> defense += value;
            case MAX_HEALTH -> maxHealth += value;
            default -> throw new IllegalStateException("Unexpected value: " + stat);
        }
    }

    @Override
    public int getStat(StatType stat) {
        return switch (stat) {
            case POWER -> power;
            case DEFENSE -> defense;
            case MAX_HEALTH -> maxHealth;
            case CURRENT_HEALTH -> currentHealth;
            case RANK -> rank;
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

    // Each creature type evolves in a different way
    public abstract void evolve();

    @Override
    public abstract String getType();

}
