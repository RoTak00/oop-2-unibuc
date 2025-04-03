package game;

import model.items.FoodItem;
import util.ItemTemplate;

import java.util.List;
import java.util.Random;

public class FoodFactory {
    private static final Random random = new Random();

    private static final List<ItemTemplate> FOOD_TEMPLATES = List.of(
            new ItemTemplate("Power Apple", "A shiny apple that boosts strength."),
            new ItemTemplate("Mystic Berry", "A rare berry said to radiate ancient energy."),
            new ItemTemplate("Iron Root", "Crunchy and packed with mineral defense."),
            new ItemTemplate("Starfruit", "It glows softly and nourishes deeply."),
            new ItemTemplate("Fire Plum", "Favored by phoenixes, it's hot and healing."),
            new ItemTemplate("Vitality Cookie", "A soft snack that restores stamina and spirit."),
            new ItemTemplate("Golden Mango", "Said to grow once every hundred years, radiates warmth."),
            new ItemTemplate("Frost Fig", "Chilled to the core — refreshes body and focus."),
            new ItemTemplate("Blazing Pepper", "So hot it sparks strength and aggression."),
            new ItemTemplate("Duskleaf Salad", "A calming mix of herbs found only in moonlight."),
            new ItemTemplate("Stormberry", "Crackling with electric tang, fuels raw energy."),
            new ItemTemplate("Honeycrisp Gem", "Sticky-sweet and brimming with life essence."),
            new ItemTemplate("Lava Bean", "Molten core gives a burst of fiery endurance."),
            new ItemTemplate("Skymelon", "Light as air, it helps lift even the heaviest spirits."),
            new ItemTemplate("Shade Olive", "Bitter and bold — awakens hidden toughness."),
            new ItemTemplate("Runestone Raisins", "Tiny bites carved with runes of resilience."),
            new ItemTemplate("Moonpetal Tart", "Delicate and glowing — restores harmony to the soul."),
            new ItemTemplate("Thunder Apple", "Crackles with static, revitalizes in a flash."),
            new ItemTemplate("Embernut", "Crunchy, hot, and energizing — sparks inner fire."),
            new ItemTemplate("Glowroot Chip", "Sliced from glowing roots, radiates natural energy."),
            new ItemTemplate("Quartzfruit", "Hard to bite, but strengthens the bones of battle."),
            new ItemTemplate("Wyrmberry Muffin", "A dragon’s favorite — grants a fierce bite."),
            new ItemTemplate("Soothing Nectar", "Thick and golden — instantly calms and heals."),
            new ItemTemplate("Flare Fruit", "Flashes bright red when ripe — surges with vitality."),
            new ItemTemplate("Silent Pear", "Soft, sweet, and subtle — strengthens from the shadows."),
            new ItemTemplate("Ashen Carrot", "Grows in fire-swept lands, oddly nourishing.")

            );

    public static FoodItem generateRandomFood(int rank) {
        ItemTemplate template = FOOD_TEMPLATES.get(random.nextInt(FOOD_TEMPLATES.size()));

        int healAmount = randomAround(10 + rank * 2, 5); // 10-30 HP depending on rank

        int powerBuff = random.nextBoolean() ? randomAround(rank, 1) : 0;
        int defenseBuff = random.nextBoolean() ? randomAround(rank, 1) : 0;
        int maxHealthBuff = random.nextBoolean() ? randomAround(rank * 2, 2) : 0;

        return new FoodItem(template.name(), template.description(), healAmount,
                powerBuff, defenseBuff, maxHealthBuff);
    }

    private static int randomAround(int base, int delta) {
        return base + random.nextInt(delta * 2 + 1) - delta;
    }
}
