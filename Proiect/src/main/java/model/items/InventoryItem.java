package model.items;

import model.Creature;

public abstract class InventoryItem {
    protected String name;
    protected String description;

    public InventoryItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract boolean canUseOn(Creature creature);
    public abstract void useOn(Creature creature);
    public abstract String getFullDescription();

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
