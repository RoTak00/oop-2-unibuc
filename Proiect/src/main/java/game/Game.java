package game;

import game.state.GameState;
import game.state.MainMenuState;
import model.Creature;
import model.items.FoodItem;
import ui.InputHelper;
import ui.UIHelper;

import java.util.*;

public class Game {

    private static Game instance;
    private final Deque<GameState> stateStack = new ArrayDeque<>();
    private boolean isRunning = true;

    private final List<Creature> creatures = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    private final Inventory inventory = new Inventory();

    private Game() {};

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void pushState(GameState state) {
        stateStack.push(state);
    }

    public void goBack() {
        if (stateStack.size() > 1) {
            stateStack.pop(); // Remove current
        } else {
            System.out.println("You are at the root menu.");
        }
    }

    public Inventory getInventory() {
        return inventory;
    }


    public void exit()
    {
        isRunning = false;
    }

    public void start()
    {
        System.out.println("Welcome to CreatureLand");
        System.out.println("As you wake up, you notice a new creature next to you...");
        pushState(new MainMenuState());

        Creature creature = BeingFactory.createRandomCreature(1);
        creatures.add(creature);

        FoodItem item = FoodFactory.generateRandomFood(1);
        inventory.addItem(item);

        System.out.println(creature.getName() + " says hello...");

        boolean playing = true;
        while(isRunning)
        {
            GameState currentState = stateStack.peek();
            currentState.display();
            currentState.handleInput(this);
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
