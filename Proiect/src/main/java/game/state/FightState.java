package game.state;

import game.Game;
import game.battle.BattleService;
import model.Creature;
import model.Monster;
import game.BeingFactory;
import ui.UIHelper;

public class FightState implements GameState {
    private final Creature creature;
    private final Monster monster;

    public FightState(Creature creature) {
        this.creature = creature;
        this.monster = FightState.generateEnemyFor(creature);
    }

    @Override
    public void display() {
        UIHelper.printTitle("⚔️ Fight Start!");
        System.out.println("👤 Your creature: " + creature.getStatus());
        System.out.println("👹 Enemy: " + monster.getStatus());
        System.out.println("Press Enter to begin battle...");
        try {
            System.in.read();
        } catch (Exception ignored) {}
    }

    @Override
    public void handleInput(Game game) {
        BattleService.fight(creature, monster);
        game.pushState(new FightFinishedState(creature, monster));
    }

    // Optional utility if you want to generate the enemy directly here
    public static Monster generateEnemyFor(Creature creature) {
        int rank = Math.max(-1, creature.getRank() - 1);
        return BeingFactory.createRandomMonster(rank);
    }
}
