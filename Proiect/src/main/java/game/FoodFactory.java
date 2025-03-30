package game;

import model.items.FoodItem;
import util.FoodTemplate;

import java.util.List;
import java.util.Random;

public class FoodFactory {
    private static final Random random = new Random();

    private static final List<FoodTemplate> FOOD_TEMPLATES = List.of(
            new FoodTemplate("Power Apple", "A shiny apple that boosts strength."),
            new FoodTemplate("Mystic Berry", "A rare berry said to radiate ancient energy."),
            new FoodTemplate("Iron Root", "Crunchy and packed with mineral defense."),
            new FoodTemplate("Starfruit", "It glows softly and nourishes deeply."),
            new FoodTemplate("Fire Plum", "Favored by phoenixes, it's hot and healing."),
            new FoodTemplate("Vitality Cookie", "A soft snack that restores stamina and spirit.")
    );

    public static FoodItem generateRandomFood(int rank) {
        FoodTemplate template = FOOD_TEMPLATES.get(random.nextInt(FOOD_TEMPLATES.size()));

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
