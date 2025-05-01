package game.state;

import db.AuditService;
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
                "Back",
                "List creatures",
                "Creature Options"
        ), 0);
    }

    @Override
    public void handleInput(Game game)
    {
        int choice = InputHelper.getInt("(Creatures) Choose an option: ");

        switch(choice)
        {
            case 0 -> game.goBack();
            case 1 -> {
                AuditService.getInstance().audit("list_creatures");
                game.listCreatures();
            }
            case 2 -> game.pushState(new CreatureSelectMenuState());
            default -> System.out.println("Invalid choice");
        }
    }
}
