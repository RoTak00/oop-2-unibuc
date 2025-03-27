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
}
