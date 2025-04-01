package util;

import java.util.List;
import java.util.Random;

public class NameFactory {
    private static final String[] PREFIXES = {
            "Zar", "Vor", "Glu", "Fen", "Tra", "Mal", "Xar", "Quo", "Lum", "Dra", "Kel", "Ny"
    };

    private static final String[] MIDDLES = {
            "an", "or", "il", "ur", "el", "ax", "un", "ir", "im", "ev", "ar", "on"
    };

    private static final String[] SUFFIXES = {
            "dor", "ix", "ak", "us", "iel", "or", "eth", "ok", "ath", "ar", "os", "a"
    };

    private static final Random random = new Random();

    public static String generateName() {
        String prefix = PREFIXES[random.nextInt(PREFIXES.length)];
        String middle = MIDDLES[random.nextInt(MIDDLES.length)];
        String suffix = SUFFIXES[random.nextInt(SUFFIXES.length)];

        return capitalize(prefix + middle + suffix);
    }

    private static String capitalize(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

    private static final List<ItemTemplate> AMULET_TEMPLATES = List.of(
            new ItemTemplate("Shimmering Amulet of Ascension", "An ancient relic pulsing with untapped potential."),
            new ItemTemplate("Radiant Sigil of Growth", "Said to be drawn by the stars to lift champions higher."),
            new ItemTemplate("Twilight Medallion", "A quiet emblem that glows at dusk and awakens hidden strength."),
            new ItemTemplate("Celestial Crest", "Forged in the void, it resonates with power."),
            new ItemTemplate("Lucent Rune of Mastery", "Inscribed with secrets of forgotten kings."),
            new ItemTemplate("Arcane Charm of Potential", "Glows softly with a promise of greater power."),
            new ItemTemplate("Echo Amulet", "Whispers of your creature's future greatness.")
    );

    public static ItemTemplate generateRandomAmuletTemplate() {
        return AMULET_TEMPLATES.get(random.nextInt(AMULET_TEMPLATES.size()));
    }
}
