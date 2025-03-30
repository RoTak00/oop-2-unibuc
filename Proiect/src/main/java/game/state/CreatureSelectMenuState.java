package game.state;

import game.Game;
import model.Creature;
import ui.InputHelper;
import ui.UIHelper;

import java.util.List;

public class CreatureSelectMenuState implements GameState{
    @Override
    public void display()
    {
        UIHelper.printTitle("Choose a creature");
        System.out.println("0. Back");
        Game.getInstance().listCreatures();
    }

    @Override
    public void handleInput(Game game)
    {
        List<Creature> creatures = Game.getInstance().getCreatures();
        if(creatures.isEmpty())
        {
            System.out.println("No creatures owned...");
            game.goBack();
            return;
        }

        int choice = InputHelper.getInt("Select a creature: ");
        if(choice == 0)
        {
            game.goBack();
            return;
        }
        choice = choice - 1;

        if(choice < 0 || choice >= creatures.size())
        {
            System.out.println("Invalid choice");
            return;
        }
        Creature creature = creatures.get(choice);
        game.pushState(new SingleCreatureActionState(creature));

    }
}
