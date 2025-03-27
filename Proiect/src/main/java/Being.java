public interface Being {
    String getName();
    int getRank();

    int getMaxHealth();
    int getCurrentHealth();
    int getPower();
    int getDefense();

    boolean isAlive();

    void receiveDamage(int amount);
    void heal(int amount);
    int getStat(StatType stat); // or use StatType
    void revive();

    String getStatus();
    String getType();
}
