package game.state;

import game.Game;

import java.sql.SQLException;

public interface GameState {
    void display();
    void handleInput(Game game) throws SQLException ;
}
