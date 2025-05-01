package game.state;

import db.AuditService;
import game.Game;
import ui.InputHelper;
import ui.UIHelper;

import java.sql.SQLException;
import java.util.List;

public class NewGameState implements GameState {
    @Override
    public void display()
    {
        UIHelper.printLine();
        System.out.println("Are you sure?");
        UIHelper.printMenu(List.of(
                "No, nevermind",
                "Yes, start a new game"
        ), 0);
    }

    @Override
    public void handleInput(Game game) throws SQLException {
        int choice = InputHelper.getInt("Choose an option: ");

        switch(choice)
        {
            case 0 -> game.goBack();
            case 1 -> {
                AuditService.getInstance().audit("new_game");
                game.reset();
            }
            default -> game.goBack();
        }
    }
}
