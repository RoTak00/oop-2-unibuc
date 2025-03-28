package game.state;

import game.Game;
import ui.UIHelper;
import ui.InputHelper;

import java.util.List;

public class CreatureMenuState implements GameState {

    @Override
    public void display()
    {
        UIHelper.printLine();
        UIHelper.printMenu(List.of(
                "List creatures",
                "Creature Options",
                "Back"
        ));
    }

    @Override
    public void handleInput(Game game)
    {
        int choice = InputHelper.getInt("(Creatures) Choose an option: ");

        switch(choice)
        {
            case 1 -> game.listCreatures();
            case 2 -> game.setState(new CreatureSelectMenuState());
            case 3 -> game.setState(new MainMenuState());
            default -> System.out.println("Invalid choice");
        }
    }
}
