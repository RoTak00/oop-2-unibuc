package game.state;

import db.AuditService;
import db.repository.UserRepository;
import game.Game;
import model.User;
import ui.InputHelper;
import ui.UIHelper;

public class ChangeNameState implements GameState {

    @Override
    public void display() {
        UIHelper.printTitle("Change Your Name");
        System.out.println("Current name: " + Game.getInstance().getUser().getName());
    }

    @Override
    public void handleInput(Game game) {
        String newName = InputHelper.getString("Enter your new name: ").trim();

        if (newName.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        User user = game.getUser();
        user.setName(newName);
        UserRepository.update(user);

        AuditService.getInstance().audit("name_changed_"+newName);

        System.out.println("Name changed to " + newName);
        game.goBack(); // back to SettingsMenuState
    }
}
