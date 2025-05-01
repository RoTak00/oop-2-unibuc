package model.items;

import model.Creature;

public abstract class InventoryItem {
    protected String name;
    protected String description;
    protected Integer id;

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
    public Integer getId() { return id; }
    public void setId(int id) { this.id = id; }

    public abstract String getType();

    public abstract boolean canUseOn(Creature creature);
    public abstract void useOn(Creature creature);
    public abstract String getFullDescription();

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
