package game.state;

import game.Game;

public interface GameState {
    void display();
    void handleInput(Game game);
}
