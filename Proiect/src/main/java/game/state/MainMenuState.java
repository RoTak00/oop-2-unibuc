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
                "Creatures",
                "Exit"
        ));
    }

    @Override
    public void handleInput(Game game){
        int choice = InputHelper.getInt("Choose an option: ");

        switch(choice)
        {
            case 1 -> game.setState(new CreatureMenuState());
            case 2 -> game.exit();
            default -> System.out.println("Invalid option");
        }
    }
}
