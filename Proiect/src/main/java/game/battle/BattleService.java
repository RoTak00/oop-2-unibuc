package game.battle;

import enums.StatType;
import game.BeingFactory;
import model.Creature;
import model.Monster;

import java.util.Random;

public class BattleService {
    private static final Random random = new Random();

    public static void fight(Creature creature, Monster monster) {
        System.out.println("⚔️ Battle Start: " + creature.getName() + " vs " + monster.getName());

        int round = 1;

        while (creature.isAlive() && monster.isAlive()) {
            System.out.println("\n🔄 Round " + round);

            // Creature attacks
            int dmgToMonster = calculateDamage(creature.getPower(), monster.getDefense());
            monster.receiveDamage(dmgToMonster);
            System.out.println("🩸 " + creature.getName() + " hits " + monster.getName() + " for " + dmgToMonster + " damage.");

            if (!monster.isAlive()) break;

            sleep(250);

            // Monster attacks
            int dmgToCreature = calculateDamage(monster.getPower(), creature.getDefense());
            creature.receiveDamage(dmgToCreature);
            System.out.println("💥 " + monster.getName() + " hits " + creature.getName() + " for " + dmgToCreature + " damage.");

            // Status update
            System.out.println("👤 " + creature.getStatus());
            System.out.println("👹 " + monster.getStatus());

            sleep(1000);
            round++;
        }

        System.out.println("\n🏁 Battle Over!");

        if (creature.isAlive()) {
            System.out.println("✅ " + creature.getName() + " wins!");

            // Random stat increase
            int powerGain = random.nextInt(2) + 1;       // 1–2
            int defenseGain = random.nextInt(2) + 1;     // 1–2
            int healthGain = random.nextInt(3) + 2;      // 2–4

            creature.boostStat(StatType.POWER, powerGain);
            creature.boostStat(StatType.DEFENSE, defenseGain);
            creature.boostStat(StatType.MAX_HEALTH, healthGain);

            System.out.println("📈 Gained stats: +" + powerGain + " Power, +" + defenseGain + " Defense, +" + healthGain + " Max HP");

        } else {
            System.out.println("☠️ " + creature.getName() + " has fainted...");
        }

        System.out.println("🔚 Final Status:");
        System.out.println("👤 " + creature.getStatus());
        System.out.println("👹 " + monster.getStatus());
    }

    private static int calculateDamage(int power, int defense) {
        float base = power - defense * 0.3f;
        int baseDamage = Math.max((int) base, 5);

        // Add random variance ±10%
        int variance = (int) (baseDamage * 0.1);
        return baseDamage + random.nextInt(variance * 2 + 1) - variance;
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

}
