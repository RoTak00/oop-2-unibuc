package model.items;

import model.Creature;
import enums.StatType;

public class FoodItem extends InventoryItem {
    private final int healAmount;
    private final int powerBuff;
    private final int defenseBuff;
    private final int maxHealthBuff;

    // Simple constructor (heals only)
    public FoodItem(String name, String description, int healAmount) {
        this(name, description, healAmount, 0, 0, 0);
    }

    // Full constructor with buffs
    public FoodItem(String name, String description, int healAmount,
                    int powerBuff, int defenseBuff, int maxHealthBuff) {
        super(name, description);
        this.healAmount = healAmount;
        this.powerBuff = powerBuff;
        this.defenseBuff = defenseBuff;
        this.maxHealthBuff = maxHealthBuff;
    }

    @Override
    public boolean canUseOn(Creature creature) {
        return creature.isAlive(); // Always usable while alive
    }

    @Override
    public void useOn(Creature creature) {
        creature.boostStat(enums.StatType.POWER, powerBuff);
        creature.boostStat(enums.StatType.DEFENSE, defenseBuff);
        creature.boostStat(enums.StatType.MAX_HEALTH, maxHealthBuff);
        creature.heal(healAmount);

        System.out.println("Used " + name + " on " + creature.getName() + "!");
        System.out.println("Healed for " + healAmount + " HP.");
        if (powerBuff != 0) System.out.println("Power increased by " + powerBuff + "!");
        if (defenseBuff != 0) System.out.println("Defense increased by " + defenseBuff + "!");
        if (maxHealthBuff != 0) System.out.println("Max Health increased by " + maxHealthBuff + "!");
    }

    public String getFullDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ").append(description);

        if (healAmount > 0) sb.append(" | Heals ").append(healAmount).append(" HP");
        if (powerBuff > 0) sb.append(" | +").append(powerBuff).append(" Power");
        if (defenseBuff > 0) sb.append(" | +").append(defenseBuff).append(" Defense");
        if (maxHealthBuff > 0) sb.append(" | +").append(maxHealthBuff).append(" Max HP");

        return sb.toString();
    }
}
