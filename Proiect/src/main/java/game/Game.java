package game;

import db.DatabaseInitializer;
import db.repository.CreatureRepository;
import db.repository.InventoryItemRepository;
import game.state.GameState;
import game.state.MainMenuState;
import model.Creature;
import model.items.FoodItem;
import ui.InputHelper;
import ui.UIHelper;

import java.sql.SQLException;
import java.util.*;

public class Game {

    private static Game instance;
    private final Deque<GameState> stateStack = new ArrayDeque<>();
    private boolean isRunning = true;

    private List<Creature> creatures = new ArrayList<>();

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


    public void exit() throws SQLException
    {

        CreatureRepository.saveAll(creatures);
        InventoryItemRepository.saveAll(inventory.getItems());
        isRunning = false;
    }

    public void reset() throws SQLException
    {
        this.exit();

        DatabaseInitializer.reset();

        this.start();
    }

    public void start() throws SQLException
    {
        isRunning = true;
        pushState(new MainMenuState());

        creatures = CreatureRepository.loadAll();
        inventory.setItems(InventoryItemRepository.loadAll());

        if(creatures.isEmpty()) {
            Creature creature = BeingFactory.createRandomCreature(1);
            creatures.add(creature);

            System.out.println("Welcome to Pokemock");
            System.out.println("As you wake up, you notice a weird creature next to you...");

            System.out.println(creature.getName() + " says hello...");

            System.out.println(" --- ");
            System.out.println("You notice your right hand, and see that you're holding some food...");
            FoodItem item = FoodFactory.generateRandomFood(1);
            inventory.addItem(item);
        }
        else
        {
            System.out.println("Welcome back to Pokemock!");
        }

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
