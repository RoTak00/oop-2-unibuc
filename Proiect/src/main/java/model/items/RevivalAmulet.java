package model.items;

import util.NameFactory;
import util.ItemTemplate;
import model.Creature;

public class RevivalAmulet extends InventoryItem {

    public RevivalAmulet() {
        this(util.NameFactory.generateRandomAmuletTemplate());
    }

    public RevivalAmulet(util.ItemTemplate template) {
        super(template.name(), template.description());
    }

    @Override
    public boolean canUseOn(Creature creature) {
        return !creature.isAlive();
    }

    @Override
    public void useOn(Creature creature) {
        creature.revive();
        System.out.println(creature.getName() + " opens its eyes back up!");
    }

    @Override
    public String getFullDescription() {
        return name + ": " + description + " | Revives a dead creature";
    }
}
