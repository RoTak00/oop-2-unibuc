package game.state;
import game.Game;
import ui.UIHelper;
import ui.InputHelper;

import java.sql.SQLException;
import java.util.List;

public class MainMenuState implements GameState {
    @Override
    public void display()
    {
        UIHelper.printTitle("Hello, " + Game.getInstance().getUser().getName());
        UIHelper.printMenu(List.of(
                "Exit",
                "Creatures",
                "Inventory",
                "Fight Log",
                "Settings",
                "Start a new game"
        ), 0);
    }

    @Override
    public void handleInput(Game game) throws SQLException {
        int choice = InputHelper.getInt("Choose an option: ");

        switch(choice)
        {
            case 0 -> game.exit();
            case 1 -> game.pushState(new CreatureSelectMenuState());
            case 2 -> game.pushState(new InventoryMenuState());
            case 3 -> game.pushState(new FightLogMenuState());
            case 4 -> game.pushState(new SettingsMenuState());
            case 5 -> game.pushState(new NewGameState());
            default -> System.out.println("Invalid option");
        }
    }
}
