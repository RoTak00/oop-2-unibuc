package game.battle;

import enums.StatType;
import game.BeingFactory;
import model.Creature;
import model.Monster;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleService {
    private static final Random random = new Random();

    public static void fight(Creature creature, Monster monster) throws SQLException {
        System.out.println("A fight commences: " + creature.getName() + " vs " + monster.getName());

        int round = 1;
        List<FightHistoryHelper.RoundLog> roundLogs = new ArrayList<>();


        while (creature.isAlive() && monster.isAlive()) {
            System.out.println("\n Round " + round);

            // Creature attacks
            int dmgToMonster = calculateDamage(creature.getPower(), monster.getDefense());
            monster.receiveDamage(dmgToMonster);
            String creatureAction = creature.getName() + " hits " + monster.getName() + " for " + dmgToMonster + " damage.";
            System.out.println(creatureAction);

            String monsterAction;
            if (monster.isAlive()){
                sleep(750);

                // Monster attacks
                int dmgToCreature = calculateDamage(monster.getPower(), creature.getDefense());
                creature.receiveDamage(dmgToCreature);
                monsterAction = monster.getName() + " hits " + creature.getName() + " for " + dmgToCreature + " damage.";
                System.out.println(monsterAction);

                // Status update
                System.out.println("Your creature: " + creature.getStatus());
                System.out.println("Monster: " + monster.getStatus());

                sleep(1500);
            }
            else
            {
                monsterAction = monster.getName() + " is defeated.";
            }

            roundLogs.add(new FightHistoryHelper.RoundLog(round, creatureAction, monsterAction));
            round++;

        }

        System.out.println("\nThe battle concludes...");

        if (creature.isAlive()) {
            System.out.println(creature.getName() + " wins!");

            // Random stat increase
            int powerGain = random.nextInt(2) + 1;       // 1–2
            int defenseGain = random.nextInt(2) + 1;     // 1–2
            int healthGain = random.nextInt(3) + 2;      // 2–4

            creature.boostStat(StatType.POWER, powerGain);
            creature.boostStat(StatType.DEFENSE, defenseGain);
            creature.boostStat(StatType.MAX_HEALTH, healthGain);

            System.out.println("Gained stats: +" + powerGain + " Power, +" + defenseGain + " Defense, +" + healthGain + " Max HP");

        } else {
            System.out.println(creature.getName() + " has died...");
        }

        db.repository.MonsterRepository.create(monster);

        String historyJson = FightHistoryHelper.generateFightHistoryJson(creature, monster, roundLogs);

        if(creature.getId() == null)
        {
            db.repository.CreatureRepository.save(creature);
        }

        db.repository.FightRepository.logFight(creature, monster, creature.isAlive(), historyJson);

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
