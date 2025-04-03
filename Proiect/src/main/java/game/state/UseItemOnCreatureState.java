package game.state;

import game.Game;
import model.Creature;
import game.Inventory;
import model.items.InventoryItem;
import ui.InputHelper;
import ui.UIHelper;

import java.util.List;

public class UseItemOnCreatureState implements GameState {
    private final Creature target;

    public UseItemOnCreatureState(Creature target) {
        this.target = target;
    }

    @Override
    public void display() {
        UIHelper.printTitle("Use item on " + target.getName());
        System.out.println("0. Back");

        Inventory inventory = Game.getInstance().getInventory();
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
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
            System.out.println("Invalid item.");
            return;
        }

        InventoryItem item = inventory.getItems().get(index);

        if (!item.canUseOn(target)) {
            System.out.println("You can’t use this item on " + target.getName() + ".");
            return;
        }

        item.useOn(target);
        inventory.removeItem(index);
        game.goBack(); // go back to SingleCreatureActionState
    }
}
