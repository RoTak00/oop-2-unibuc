package game.state;

import db.repository.FightRepository;
import game.Game;
import model.FightLogEntry;
import ui.InputHelper;
import ui.UIHelper;

import java.util.List;

public class FightLogMenuState implements GameState {

    private List<FightLogEntry> fightLogs;

    @Override
    public void display() {
        UIHelper.printTitle("Fight Log");

        fightLogs = FightRepository.loadAll();

        if (fightLogs.isEmpty()) {
            System.out.println("No fights recorded yet.");
            return;
        }

        UIHelper.printMenu(fightLogs.stream()
                .map(f -> f.creatureName() + " vs " + f.monsterName() +
                        (f.victory() ? " (W)" : " (L)"))
                .toList(), 1);
    }

    @Override
    public void handleInput(Game game) {
        if (fightLogs.isEmpty()) {
            game.goBack();
            return;
        }

        int choice = InputHelper.getInt("Select a fight (0 to go back): ");

        if (choice == 0) {
            game.goBack();
        } else if (choice > 0 && choice <= fightLogs.size()) {
            game.pushState(new FightDetailState(fightLogs.get(choice - 1)));
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
