package util;

import java.util.List;
import java.util.Random;

public class NameFactory {
    private static final String[] PREFIXES = {
            "Zar", "Vor", "Glu", "Fen", "Tra", "Mal", "Xar", "Quo", "Lum", "Dra", "Kel", "Ny",
            "Thal", "Brae", "Myrr", "Kael", "Skor", "Vyr", "Orok", "Senn", "Aeth", "Grim", "Laz", "Noct"
    };


    private static final String[] MIDDLES = {
            "an", "or", "il", "ur", "el", "ax", "un", "ir", "im", "ev", "ar", "on",
            "eth", "yl", "is", "ae", "oa", "um", "ien", "io", "ae", "ul", "ra", "in"
    };


    private static final String[] SUFFIXES = {
            "dor", "ix", "ak", "us", "iel", "or", "eth", "ok", "ath", "ar", "os", "a",
            "ion", "aris", "gorn", "yth", "eon", "amar", "thys", "andor", "rak", "mir", "gath", "anax"
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
            new ItemTemplate("Echo Amulet", "Whispers of your creature's future greatness."),
            new ItemTemplate("Solar Pendant of Power", "Radiates the warmth of ancient suns, empowering the bearer."),
            new ItemTemplate("Starlit Emblem", "Embedded with fragments of fallen stars, it pulses with energy."),
            new ItemTemplate("Obsidian Talisman", "Dark and smooth, it hums with restrained potential."),
            new ItemTemplate("Runed Band of Clarity", "Etched with glowing runes that sharpen instinct and will."),
            new ItemTemplate("Phantom Crest", "Light as a whisper, said to phase between realms."),
            new ItemTemplate("Wyrmscale Amulet", "Crafted from a legendary dragon’s shed scale."),
            new ItemTemplate("Ether Chain of Balance", "Suspended in motion, it grants harmony and fortitude."),
            new ItemTemplate("Infernal Token", "Smolders softly — only the brave dare wear it."),
            new ItemTemplate("Crown Fragment of the Forgotten", "Broken, yet still mighty. Its presence is undeniable."),
            new ItemTemplate("Gilded Sigil of Legends", "Once worn by heroes — now it seeks a new story."),
            new ItemTemplate("Veilstone Amulet", "Wrapped in mist and memory, it reveals hidden strength."),
            new ItemTemplate("Spirecrest Pendant", "Said to be carved atop the highest mountain peak."),
            new ItemTemplate("Chalice Medallion", "Symbol of forgotten rites, still potent with ancient vows."),
            new ItemTemplate("Embercoil Locket", "A tiny flame dances within — eternal and untamed."),
            new ItemTemplate("Glimmershard Sigil", "Fragments of light trapped in crystal, bursting with growth."),
            new ItemTemplate("Vortex Rune", "Swirls with contained chaos, ready to be unleashed."),
            new ItemTemplate("Howling Emblem", "Echoes with the spirit of storm and beast."),
            new ItemTemplate("Aetherband", "A loop of pure energy, unbound by time."),
            new ItemTemplate("Thornwoven Charm", "Crafted from the heart of a living forest — wild and fierce."),
            new ItemTemplate("Moonbinder Crest", "Links the wearer to celestial rhythms and tides.")
            );

    public static ItemTemplate generateRandomAmuletTemplate() {
        return AMULET_TEMPLATES.get(random.nextInt(AMULET_TEMPLATES.size()));
    }
}
