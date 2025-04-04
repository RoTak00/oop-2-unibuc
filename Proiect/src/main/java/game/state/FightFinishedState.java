package game.state;

import game.Game;
import game.FoodFactory;
import model.items.RevivalAmulet;
import util.NameFactory;
import model.Creature;
import model.Monster;
import model.items.FoodItem;
import model.items.EvolutionAmulet;
import ui.UIHelper;

import java.util.Random;

public class FightFinishedState implements GameState {
    private final Creature creature;
    private final Monster monster;
    private static final Random random = new Random();

    public FightFinishedState(Creature creature, Monster monster) {
        this.creature = creature;
        this.monster = monster;
    }

    @Override
    public void display() {
        UIHelper.printTitle("Battle Results...");

        if (creature.isAlive() && !monster.isAlive()) {
            System.out.println(creature.getName() + " won the battle!");

            int outcome = random.nextInt(100); // 0–99

            if (outcome < 70) {
                // 70% chance: reward food
                FoodItem food = FoodFactory.generateRandomFood(creature.getRank());
                Game.getInstance().getInventory().addItem(food);
                System.out.println("You found some food after the battle: " + food.getName());

                // 40% chance to generate another
                if (random.nextInt(100) < 40) {
                    FoodItem more_food = FoodFactory.generateRandomFood(creature.getRank() + 1);
                    Game.getInstance().getInventory().addItem(more_food);
                    System.out.println("Lucky, you've found some more quality food: " + more_food.getName());
                }

            } else if (outcome < 80) {
                // 10% chance: reward amulet


                if(random.nextInt(100) < 50) {
                    EvolutionAmulet amulet = new EvolutionAmulet();
                    Game.getInstance().getInventory().addItem(amulet);
                    System.out.println("You discovered a powerful amulet: " + amulet.getName());
                }
                else
                {
                    RevivalAmulet amulet = new RevivalAmulet();
                    Game.getInstance().getInventory().addItem(amulet);
                    System.out.println("You discovered a powerful amulet: " + amulet.getName());
                }


            } else {
                // 20% chance: recruit new creature
                int recruitRank = creature.getRank();
                if (random.nextInt(100) < 20) { // 30% chance inside the 20%
                    recruitRank++;
                }

                Creature newCreature = game.BeingFactory.createRandomCreature(recruitRank);
                Game.getInstance().getCreatures().add(newCreature);
                System.out.println("A wild creature decided to join you: " + newCreature.getName() + " (Rank " + recruitRank + ")");
            }
        } else if (!creature.isAlive()) {
            System.out.println(creature.getName() + " has died...");
        } else {
            System.out.println("The battle ended without a definite result...");
        }

        System.out.println("\n0. Back");
    }

    @Override
    public void handleInput(Game game) {
        game.goBack(); // Exit FightFinishedState
        game.goBack(); // Return to SingleCreatureActionState
    }
}
