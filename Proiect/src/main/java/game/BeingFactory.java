package game;

import model.*;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import enums.CreatureType;
import util.NameFactory;

public class BeingFactory {
    private static final Random random = new Random();

    // model.Creature generators by type
    private static final List<Function<Integer, Creature>> creatureGenerators = List.of(
            BeingFactory::randomDragon,
            BeingFactory::randomGolem,
            BeingFactory::randomPhoenix
    );

    public static Creature createRandomCreature(int rank) {
        int index = random.nextInt(creatureGenerators.size());
        return creatureGenerators.get(index).apply(rank);
    }

    public static Creature createCreature(CreatureType type, int rank) {
        return switch (type) {
            case CreatureType.DRAGON -> randomDragon(rank);
            case CreatureType.GOLEM -> randomGolem(rank);
            case CreatureType.PHOENIX -> randomPhoenix(rank);
            default -> throw new IllegalArgumentException("Unknown creature type: " + type);
        };
    }

    public static Monster createRandomMonster(int rank) {
        String name = NameFactory.generateName();
        int maxHealth = randomAround(80 + rank * 8, 10);
        int power     = randomAround(15 + rank * 2, 3);
        int defense   = randomAround(10 + rank * 2, 3);
        return new Monster(name, rank, maxHealth, power, defense);
    }

    // --- model.Creature Type Generators ---

    private static Dragon randomDragon(int rank) {
        String name = NameFactory.generateName();
        int maxHealth = randomAround(100 + rank * 5, 15);
        int power     = randomAround(25 + rank * 2, 5);
        int defense   = randomAround(20 + rank * 2, 4);
        return new Dragon(name, rank, maxHealth, power, defense);
    }

    private static Golem randomGolem(int rank) {
        String name = NameFactory.generateName();
        int maxHealth = randomAround(110 + rank * 6, 12);
        int power     = randomAround(18 + rank, 3);
        int defense   = randomAround(30 + rank * 2, 5);
        return new Golem(name, rank, maxHealth, power, defense);
    }

    private static Phoenix randomPhoenix(int rank) {
        String name = NameFactory.generateName();
        int maxHealth = randomAround(90 + rank * 4, 10);
        int power     = randomAround(28 + rank * 2, 6);
        int defense   = randomAround(15 + rank, 3);
        return new Phoenix(name, rank, maxHealth, power, defense);
    }

    private static int randomAround(int base, int delta) {
        return base + random.nextInt(delta * 2 + 1) - delta;
    }
}
