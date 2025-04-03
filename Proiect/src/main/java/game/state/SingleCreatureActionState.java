package game.state;

import game.Game;
import model.Creature;
import ui.InputHelper;
import ui.UIHelper;

import java.util.List;

public class SingleCreatureActionState implements GameState {
    private final Creature creature;

    public SingleCreatureActionState(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void display()
    {
        UIHelper.printTitle("Actions: " + creature.getName());
        UIHelper.printMenu(List.of(
                "Back",
                "Show info",
                "Use item",
                "Fight"
        ), 0);
    }

    @Override
    public void handleInput(Game game)
    {
        int choice = InputHelper.getInt("Choose an action: ");

        switch(choice)
        {
            case 0 -> game.goBack();
            case 1 -> System.out.println(creature.getStatus());
            case 2 -> game.pushState(new UseItemOnCreatureState(creature));
            case 3 -> {
                if (creature.isAlive()) {
                    game.pushState(new FightState(creature));
                } else {
                    System.out.println("This creature is dead...");
                }
            }
            default -> System.out.println("Invalid choice");
        }
    }
}
