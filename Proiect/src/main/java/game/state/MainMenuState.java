package game.state;
import game.Game;
import ui.UIHelper;
import ui.InputHelper;

import java.util.List;

public class MainMenuState implements GameState {
    @Override
    public void display()
    {
        UIHelper.printLine();
        UIHelper.printMenu(List.of(
                "Exit",
                "Creatures",
                "Inventory"
        ), 0);
    }

    @Override
    public void handleInput(Game game){
        int choice = InputHelper.getInt("Choose an option: ");

        switch(choice)
        {
            case 0 -> game.exit();
            case 1 -> game.pushState(new CreatureMenuState());
            case 2 -> game.pushState(new InventoryMenuState());
            default -> System.out.println("Invalid option");
        }
    }
}
