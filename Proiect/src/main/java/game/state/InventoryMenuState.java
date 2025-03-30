package game.state;

import game.Game;
import game.Inventory;
import model.items.InventoryItem;
import ui.InputHelper;
import ui.UIHelper;

import java.util.List;

public class InventoryMenuState implements GameState {

    @Override
    public void display() {
        UIHelper.printTitle("Inventory");

        Inventory inventory = Game.getInstance().getInventory();

        System.out.println("0. Back");

        if (inventory.isEmpty()) {
            System.out.println("📦 Your inventory is empty.");
            return;
        }

        List<InventoryItem> items = inventory.getItems();

        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getFullDescription());
        }
    }

    @Override
    public void handleInput(Game game) {
        Inventory inventory = game.getInventory();

        if (inventory.isEmpty()) {
            game.goBack();
            return;
        }

        int choice = InputHelper.getInt("Choose an item: ");
        if (choice == 0) {
            game.goBack();
            return;
        }

        int index = choice - 1;
        if (index < 0 || index >= inventory.getSize()) {
            System.out.println("❌ Invalid selection.");
            return;
        }

        InventoryItem item = inventory.getItems().get(index);
        game.pushState(new InventoryItemActionState(item, index));
    }
}
