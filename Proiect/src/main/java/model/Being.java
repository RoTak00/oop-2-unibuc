package model;

import enums.StatType;

public interface Being {
    String getName();
    int getRank();

    int getMaxHealth();
    int getCurrentHealth();
    int getPower();
    int getDefense();

    void setId(int id);
    Integer getId();

    boolean isAlive();

    void receiveDamage(int amount);
    void heal(int amount);
    int getStat(StatType stat); // or use enums.StatType
    void revive();

    String getStatus();
    String getShortStatus();
    String getType();
}
