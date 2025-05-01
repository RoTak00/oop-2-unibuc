package game;

import model.items.InventoryItem;
import model.Creature;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static final int MAX_SIZE = 10;
    private List<InventoryItem> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public boolean addItem(InventoryItem item) {
        if (items.size() >= MAX_SIZE) {
            System.out.println("Inventory is full. Cannot add " + item.getName());
            return false;
        }
        items.add(item);
        System.out.println("Added " + item.getName() + " to inventory.");
        return true;
    }

    public boolean removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            InventoryItem removed = items.remove(index);
            System.out.println("Removed " + removed.getName() + " from inventory.");
            return true;
        }
        System.out.println("You have no item there.");
        return false;
    }

    public void useItem(int index, Creature target) {
        if (index >= 0 && index < items.size()) {
            InventoryItem item = items.get(index);
            if (!item.canUseOn(target)) {
                System.out.println("Cannot use " + item.getName() + " on this creature.");
                return;
            }

            item.useOn(target);
            items.remove(index); // Assume single-use
            System.out.println("Used " + item.getName() + ".");
        } else {
            System.out.println("You have no item there.");
        }
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("Nothing in your pouch...");
            return;
        }

        System.out.println("Inventory:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getFullDescription());
        }
    }

    public boolean isFull() {
        return items.size() >= MAX_SIZE;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int getSize() {
        return items.size();
    }

    public List<InventoryItem> getItems() {
        return new ArrayList<>(items); // Immutable copy
    }

    public void setItems(List<InventoryItem> items) {
        this.items = items;
    }
}
