package lab9.ex1;

import java.util.HashMap;
import java.util.Map;

public class ItemManager<T extends Item> {

    private Map<String, T> items;

    public ItemManager() {
        items = new HashMap<>();
    }

    public void add(T item, String name) {
        items.put(name, item);
    }

    public void list()
    {
        for (T item : items.values()) {
            item.use();
        }
    }
}
