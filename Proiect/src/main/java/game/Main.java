package game;

import db.DB;
import db.DatabaseInitializer;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Game game = Game.getInstance();

        try {
            DatabaseInitializer.initialize();
            game.start();
        } catch (SQLException e) {
            e.printStackTrace();

            System.err.println("Database error...");
        }



    }
}
