package game.state;

import db.AuditService;
import game.Inventory;
import game.Game;
import model.items.InventoryItem;
import ui.InputHelper;
import ui.UIHelper;

import java.util.List;


public class InventoryItemActionState implements GameState {
    private final InventoryItem item;
    private final int itemIndex;

    public InventoryItemActionState(InventoryItem item, int itemIndex) {
        this.item = item;
        this.itemIndex = itemIndex;
    }

    @Override
    public void display() {
        UIHelper.printTitle("Item: " + item.getName());
        System.out.println(item.getFullDescription());

        UIHelper.printMenu(List.of(
                "Back",
                "Use on a creature",
                "Remove item"
        ), 0);
    }

    @Override
    public void handleInput(Game game) {
        Inventory inventory = game.getInventory();

        int choice = InputHelper.getInt("Choose an action: ");
        switch (choice) {

            case 0 -> game.goBack(); // back to inventory
            case 1 -> game.pushState(new InventoryUseTargetState(item, itemIndex));
            case 2 -> {
                AuditService.getInstance().audit("remove_item_"+itemIndex);
                inventory.removeItem(itemIndex);
                game.goBack(); // back to inventory
            }
            default -> System.out.println("Invalid option.");
        }
    }
}
