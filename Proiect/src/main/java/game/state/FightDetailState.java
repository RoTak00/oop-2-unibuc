package game.state;

import game.Game;
import model.FightLogEntry;
import ui.InputHelper;
import ui.UIHelper;

public class FightDetailState implements GameState {

    private final FightLogEntry fight;

    public FightDetailState(FightLogEntry fight) {
        this.fight = fight;
    }

    @Override
    public void display() {
        UIHelper.printTitle("🗡 Fight Details: " + fight.creatureName() + " vs " + fight.monsterName());

        fight.rounds().forEach(round -> {
            System.out.println("Round " + round.roundNumber() + ":");
            System.out.println("  Creature: " + round.creatureAction());
            System.out.println("  Monster: " + round.monsterAction());
        });

        System.out.println("\nFinal Status:");
        System.out.println("  Creature HP: " + fight.finalCreatureHP());
        System.out.println("  Monster HP: " + fight.finalMonsterHP());

        System.out.println("\n0. Back");
    }

    @Override
    public void handleInput(Game game) {
        InputHelper.getInt("Press 0 to go back: ");
        game.goBack();
    }
}
