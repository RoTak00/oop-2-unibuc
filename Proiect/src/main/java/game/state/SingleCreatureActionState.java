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
                "Show info",
                "Back"
        ));
    }

    @Override
    public void handleInput(Game game)
    {
        int choice = InputHelper.getInt("Choose an action: ");

        switch(choice)
        {
            case 1 -> System.out.println(creature.getStatus());
            case 2 -> game.setState(new CreatureSelectMenuState());
            default -> System.out.println("Invalid choice");
        }
    }
}
