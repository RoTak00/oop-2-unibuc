package game;

import game.state.GameState;
import game.state.MainMenuState;
import model.Creature;
import ui.InputHelper;
import ui.UIHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static Game instance;
    private GameState state;
    private boolean isRunning = true;

    private final List<Creature> creatures = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    private Game() {};

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void exit()
    {
        isRunning = false;
    }

    public void start()
    {
        System.out.println("Welcome to CreatureLand");
        System.out.println("As you wake up, you notice a new creature next to you...");
        this.state = new MainMenuState();

        Creature creature = BeingFactory.createRandomCreature(1);
        creatures.add(creature);

        System.out.println(creature.getName() + " says hello...");

        boolean playing = true;
        while(isRunning)
        {
            state.display();
            state.handleInput(this);
        }
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public void listCreatures()
    {
        for(int i = 0; i < creatures.size(); i++)
        {
            System.out.println((i + 1) + ". " + creatures.get(i).getShortStatus());
        }
    }

}
