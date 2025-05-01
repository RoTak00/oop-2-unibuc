package game.state;

import db.AuditService;
import model.Creature;
import game.Inventory;
import game.Game;
import model.items.InventoryItem;
import ui.InputHelper;
import ui.UIHelper;

import java.util.List;


public class InventoryUseTargetState implements GameState {
    private final InventoryItem item;
    private final int itemIndex;

    public InventoryUseTargetState(InventoryItem item, int itemIndex) {
        this.item = item;
        this.itemIndex = itemIndex;
    }

    @Override
    public void display() {
        UIHelper.printTitle("Use " + item.getName() + " on...");
        System.out.println("0. Back");
        Game.getInstance().listCreatures();
    }

    @Override
    public void handleInput(Game game) {
        List<Creature> creatures = game.getCreatures();
        Inventory inventory = game.getInventory();

        if (creatures.isEmpty()) {
            System.out.println("You have no creatures.");
            game.goBack();
            return;
        }

        int index = InputHelper.getInt("Select creature: ");

        if(index == 0)
        {
            game.goBack();
            return;
        }
        index = index - 1;
        if (index >= 0 && index < creatures.size()) {
            Creature target = creatures.get(index);

            if (!item.canUseOn(target)) {
                System.out.println("Cannot use item on this creature.");
                return;
            }

            AuditService.getInstance().audit("use_item_"+itemIndex+"_on_creature_"+index);
            item.useOn(target);
            inventory.removeItem(itemIndex);
            game.goBack(); // back to item action menu
            game.goBack(); // back to inventory
        } else {
            System.out.println("Invalid creature.");
        }
    }
}
