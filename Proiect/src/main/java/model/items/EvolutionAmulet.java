package model.items;

import util.NameFactory;
import util.ItemTemplate;
import model.Creature;

public class EvolutionAmulet extends InventoryItem {

    public EvolutionAmulet() {
        this(util.NameFactory.generateRandomAmuletTemplate());
    }

    public EvolutionAmulet(util.ItemTemplate template) {
        super(template.name(), template.description());
    }

    @Override
    public boolean canUseOn(Creature creature) {
        return creature.isAlive();
    }

    @Override
    public void useOn(Creature creature) {
        int oldRank = creature.getRank();
        creature.boostStat(enums.StatType.RANK, 1);
        System.out.println(creature.getName() + "'s rank increased from " + oldRank + " to " + creature.getRank() + "!");
    }

    @Override
    public String getFullDescription() {
        return name + ": " + description + " | +1 Rank";
    }
}
