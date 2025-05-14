package game.state;

import db.AuditService;
import db.repository.CreatureRepository;
import db.repository.InventoryItemRepository;
import game.Game;
import ui.InputHelper;
import ui.UIHelper;

import java.sql.SQLException;
import java.util.List;

public class SettingsMenuState implements GameState {

    @Override
    public void display() {
        UIHelper.printLine();
        UIHelper.printMenu(List.of(
                "Back",
                "Change Name",
                "Save Now"
        ), 0);
    }

    @Override
    public void handleInput(Game game) throws SQLException {
        int choice = InputHelper.getInt("Choose an option: ");

        switch (choice) {
            case 0 -> game.goBack();
            case 1 -> game.pushState(new ChangeNameState());
            case 2 ->
            {
                CreatureRepository.saveAll(game.getCreatures());
                InventoryItemRepository.saveAll(game.getInventory().getItems());
                AuditService.getInstance().audit("database_flush");

                System.out.println("Database has been flushed (saved current state).");
            }
            default -> System.out.println("Invalid choice.");
        }
    }
}
