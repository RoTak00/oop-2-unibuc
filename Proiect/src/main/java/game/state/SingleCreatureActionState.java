package game.state;

import db.AuditService;
import game.Game;
import model.Creature;
import ui.InputHelper;
import ui.UIHelper;

import java.util.List;

public class SingleCreatureActionState implements GameState {
    private final Creature creature;

    public SingleCreatureActionState(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void display()
    {
        UIHelper.printTitle("Actions: " + creature.getName());
        UIHelper.printMenu(List.of(
                "Back",
                "Show info",
                "Use item",
                "Pet creature",
                "Fight",
                "Kick out..."
        ), 0);
    }

    @Override
    public void handleInput(Game game)
    {
        int choice = InputHelper.getInt("Choose an action: ");

        switch(choice)
        {
            case 0 -> game.goBack();
            case 1 -> {
                AuditService.getInstance().audit("creature_status_"+creature.getName());
                System.out.println(creature.getStatus());
            }
            case 2 -> game.pushState(new UseItemOnCreatureState(creature));
            case 3 ->
                    {
                        if(creature.isAlive()) {
                            AuditService.getInstance().audit("creature_pet_"+creature.getName());
                            creature.heal(5);
                            System.out.println(creature.getName() + " is happy and healed 5 HP!");
                        }
                        else
                        {
                            System.out.println(creature.getName() + " is dead...");
                        }

                    }
            case 4 -> {
                if (creature.isAlive()) {
                    AuditService.getInstance().audit("creature_fight_"+creature.getName());
                    game.pushState(new FightState(creature));
                } else {
                    System.out.println("This creature is dead...");
                }
            }
            case 5 ->
            {
                AuditService.getInstance().audit("creature_kick_"+creature.getName());

                if(creature.getId() != null)
                {
                    db.repository.CreatureRepository.deleteById(creature.getId());
                }

                game.getCreatures().remove(creature);
                System.out.println(creature.getName() + " has been kicked out...");
                game.goBack();
            }
            default -> System.out.println("Invalid choice");
        }
    }
}
